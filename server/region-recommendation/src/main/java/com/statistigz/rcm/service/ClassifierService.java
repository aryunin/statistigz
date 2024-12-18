package com.statistigz.rcm.service;

import reactor.core.publisher.Mono;

import java.util.List;

public interface ClassifierService {
    Mono<Integer> getClusterIdBySurveyResult(List<Integer> answers);
}
