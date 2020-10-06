package org.sayner.sandbox.graphics.hellofx.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sayner.sandbox.graphics.hellofx.exception.ProxyRestException;
import org.sayner.sandbox.graphics.hellofx.util.RestRequestFunction;
import org.slf4j.Logger;
import org.springframework.core.codec.CodecException;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public abstract class AbstractRestClient {
    protected Logger logger;
    protected WebClient webClient;
    protected ObjectMapper mapper;

    public AbstractRestClient(WebClient webClient, ObjectMapper mapper, Logger logger) {
        this.webClient = webClient;
        this.mapper = mapper;
        this.logger = logger;
    }

    protected <T> Object sendPostRequest(String uri, Object request, Class<T> responseElement) {
        return restRequestTemplate(webClient -> {
            logger.info("Подготовка JSON к отправке по uri {}\n{}",
                    uri, mapper.writeValueAsString(request));
            return webClient
                    .post()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .bodyValue(request)
                    .retrieve()
                    .onStatus(
                            HttpStatus::isError,
                            clientResponse -> handleError(clientResponse.statusCode())
                    )
                    .bodyToMono(responseElement)
                    .block();
        });
    }

    protected <T> Object sendPutRequest(String uri, Integer uriParam, Object request, Class<T> responseElement) {
        return restRequestTemplate(webClient -> webClient
                .put()
                .uri(uriBuilder -> uriBuilder
                        .path(uri)
                        .build(uriParam)
                )
                .header("Content-Type", "application/json")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatus::isError,
                        clientResponse -> handleError(clientResponse.statusCode())
                )
                .bodyToMono(responseElement)
                .block());
    }

    protected <T> Object sendGetRequest(String uri, Class<T> responseElement) {
        return restRequestTemplate(webClient -> webClient
                .get()
                .uri(uri)
                .header("Content-Type", "application/json")
                .retrieve()
                .onStatus(
                        HttpStatus::isError,
                        clientResponse -> handleError(clientResponse.statusCode())
                )
                .bodyToMono(responseElement)
                .block());
    }

    /**
     * Обработка ошибок при запросе к REST API
     *
     * @param function реализация запроса
     * @return ответ от сервера
     */
    protected Object restRequestTemplate(final RestRequestFunction function) {
        Object webResponse = new Object();
        try {
            webResponse = function.createRequest(webClient);
            logger.info("Request completed successfully");
        } catch (JsonProcessingException e) {
            logger.error("Ошибка при записи JSON: {}", e.getMessage());
        } catch (CodecException e) {
            final String msg = "Ошибка выполнения запроса REST API";
            logger.error("{}: {}", msg, e.getMessage());
            throw new ProxyRestException(msg);
        } catch (Throwable e) {
            final String msg = "Нет доступа к REST API";
            logger.error("{}: {}\n{}", msg, e.getClass().getName(), e.getMessage());
            throw new ProxyRestException(msg);
        }
        return webResponse;
    }

    protected Mono<? extends Throwable> handleError(HttpStatus httpStatus) {
        logger.error("Сервис вернул ответ с ошибкой {}:{}", httpStatus.value(), httpStatus.getReasonPhrase());
        return Mono.error(new ProxyRestException(httpStatus.getReasonPhrase()));
    }
}
