package com.statistigz.main.provider;

import com.statistigz.main.entity.Projection;
import com.statistigz.main.entity.Region;

import java.util.List;
import java.util.Optional;

/**
 * @brief абстракция над RegionRepository для удобства
 */
public interface RegionProvider {
    /**
     * @brief Ищет регион по id и году.
     *        Также подгружает связанные проекции и достижения.
     * @param id id региона
     * @param year год актуальности данных
     * @return регион
     */
    Optional<Region> findByIdAndYear(long id, int year);

    /**
     * @brief Ищет все регионы в данной проекции за данный год.
     *        Подгружает проекцию и достижения.
     *        В списке проекций гарантированно будет не больше одной проекции
     * @param projection проекция
     * @param year год актуальности данных
     * @return список регионов
     */
    List<Region> findByProjectionAndYear(Projection projection, int year);

    /**
     * @brief Поиск региона по названию (подстрока)
     * @param name подстрока названия
     * @return список регионов с похожим названием
     */
    List<Region> search(String name);
}
