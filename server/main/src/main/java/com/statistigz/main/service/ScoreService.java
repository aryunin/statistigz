package com.statistigz.main.service;

public interface ScoreService {
    double calculate(long regionId);

    double calculate(long regionId, long projectionId);
}
