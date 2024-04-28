package com.statistigz.rcm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.statistigz.common.dto.classifier.ClassifierRequestDTO;
import com.statistigz.common.dto.classifier.ClassifierResponseDTO;
import com.statistigz.rcm.exception.ServiceException;
import com.statistigz.rcm.service.ClassifierService;
import com.statistigz.rcm.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class ClassifierServiceImpl implements ClassifierService {
    private final String SERVICE_NAME = "classifier";
    private final String RESOURCE_PATH = "/";

    private final CustomLogger logger;
    private final WebClient classifierClient;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<Integer> getClusterIdBySurveyResult(List<Integer> answers) {
        logger.debug(this, "getRegionsByClusterId()");
        logger.debug(this, "answers = " + answers);

        return classifierClient.post()
                .uri(RESOURCE_PATH)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(new ClassifierRequestDTO(answers)), ClassifierResponseDTO.class)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is2xxSuccessful()) {
                        return clientResponse.bodyToMono(ClassifierResponseDTO.class)
                                .map(ClassifierResponseDTO::cluster);
                    }
                    else {
                        return Mono.error(
                                new ServiceException(SERVICE_NAME, "got status code " + clientResponse.statusCode() + " from service")
                        );
                    }
                }).onErrorResume(ex -> Mono.error(
                        new ServiceException(SERVICE_NAME, "no connection with service")
                ));
    }
}
