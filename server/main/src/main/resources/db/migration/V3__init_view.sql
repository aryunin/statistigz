CREATE MATERIALIZED VIEW region_projection AS
SELECT
	rc.region_id AS region_id,
	pr.id AS projection_id,
	rc.update_year AS update_year,
	AVG(rc."value") AS score
FROM region_criteria rc
JOIN criteria cr
	ON cr.id = rc.criteria_id
JOIN projection pr
	ON pr.id = cr.projection_id
GROUP BY rc.region_id, pr.id, update_year;

CREATE MATERIALIZED VIEW achievement AS
WITH CTE AS (
    SELECT
        rp.region_id AS region_id,
        rp.projection_id AS projection_id,
        rp.update_year AS update_year,
		rp.score AS score,
        RANK() OVER (PARTITION BY rp.projection_id, rp.update_year ORDER BY rp.score DESC) AS rnk
    FROM region_projection rp
)
SELECT region_id, projection_id, update_year, score
FROM CTE
WHERE rnk = 1;