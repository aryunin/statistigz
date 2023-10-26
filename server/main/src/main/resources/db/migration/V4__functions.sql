CREATE PROCEDURE calculate_common_score()
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Region_Criteria(region_id, criteria_id, update_year, "value")
		SELECT
		region_id,
		49,
		update_year,
		AVG(score)
		FROM region_projection
		GROUP BY region_id, update_year
		ON CONFLICT (region_id, criteria_id, update_year) DO UPDATE
		SET "value" = EXCLUDED."value";
END;
$$;

CREATE PROCEDURE refresh_all()
LANGUAGE plpgsql
AS $$
BEGIN
    REFRESH MATERIALIZED VIEW region_projection; -- TODO ради одной строчки в calculate_common_score. Нужно делать не вьюхи, а таблицы
	CALL calculate_common_score();
    REFRESH MATERIALIZED VIEW region_projection;
	REFRESH MATERIALIZED VIEW achievement;
END;
$$;