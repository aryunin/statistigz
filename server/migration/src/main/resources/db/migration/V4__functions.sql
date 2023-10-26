CREATE PROCEDURE calculate_common_score() AS $$
    INSERT INTO Region_Criteria(region_id, criteria_id, update_year, "value")
		SELECT
		region_id,
		49,
		update_year,
		AVG(score)
		FROM region_projection
		GROUP BY region_id, update_year
		ON CONFLICT (region_id, criteria_id, update_year) DO UPDATE
		SET "value" = EXCLUDED."value"
$$ LANGUAGE SQL;

CREATE PROCEDURE refresh_all() AS $$
	CALL calculate_common_score();
    REFRESH MATERIALIZED VIEW CONCURRENTLY region_projection;
	REFRESH MATERIALIZED VIEW CONCURRENTLY achievement;
$$ LANGUAGE SQL;