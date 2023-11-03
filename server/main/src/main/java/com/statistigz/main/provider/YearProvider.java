package com.statistigz.main.provider;

import java.util.List;

/**
 * @brief Предоставляет доступ к годам обновления данных
 */
public interface YearProvider {
    /**
     * @return года обновлений, отсортированные по убыванию
     */
    List<Integer> getUpdateYears();
}
