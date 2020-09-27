package org.sayner.sandbox.graphics.hellofx.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    private final WebClient webClient;

    public AppConfig() {
        this.webClient=WebClient
                .builder()
                .baseUrl(readRestApiProperty())
                .build();
    }

    private String readRestApiProperty() {
        final ClassPathResource resource = new ClassPathResource("application.properties");
        final Properties properties = new Properties();
        try {
            logger.info("Trying to read properties file");
            properties.load(resource.getInputStream());
        } catch (IOException e) {
            logger.error("application.properties could not be open: {}",e.getMessage());
            e.printStackTrace();
        }
        return properties.getProperty("rest-api-url");
    }

    public WebClient getWebClient() {
        return webClient;
    }
}
