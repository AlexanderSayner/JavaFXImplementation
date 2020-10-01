package org.sayner.sandbox.graphics.hellofx.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.reactive.function.client.WebClient;

@FunctionalInterface
public interface RestRequestFunction {
    Object createRequest(WebClient webClient) throws JsonProcessingException;
}
