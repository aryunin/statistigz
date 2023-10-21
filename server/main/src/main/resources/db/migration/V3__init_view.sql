CREATE MATERIALIZED VIEW region_projection AS
SELECT
	rc.region_id AS region_id,
	pr.id AS projection_id,
	AVG(rc."value") AS score
FROM region_criteria rc
JOIN criteria cr
	ON cr.id = rc.criteria_id
JOIN projection pr
	ON pr.id = cr.projection_id
WHERE rc.update_date = (
	SELECT MAX(update_date)
	FROM region_criteria
	WHERE criteria_id = cr.id
	AND projection_id = pr.id
	GROUP BY criteria_id, projection_id
)
GROUP BY rc.region_id, pr.id;

CREATE MATERIALIZED VIEW achievement AS
WITH CTE AS (
    SELECT
        rp.region_id AS region_id,
        rp.projection_id AS projection_id,
		rp.score AS score,
        RANK() OVER (PARTITION BY rp.projection_id ORDER BY rp.score DESC) AS rnk
    FROM region_projection rp
)
SELECT region_id, projection_id, score
FROM CTE
WHERE rnk = 1;