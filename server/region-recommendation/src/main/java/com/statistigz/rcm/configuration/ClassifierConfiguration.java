package com.statistigz.rcm.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClassifierConfiguration {
    @Value("${service.classifier.host}")
    private String host;
    @Value("${service.classifier.port}")
    private String port;
    @Value("${service.classifier.path}")
    private String path;
    @Value("${service.classifier.protocol}")
    private String protocol;

    @Bean
    public WebClient classifierClient() {
        return WebClient.builder().baseUrl(protocol + "://" + host + ":" + port + path).build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
