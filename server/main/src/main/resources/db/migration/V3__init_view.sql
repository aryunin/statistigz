CREATE MATERIALIZED VIEW IF NOT EXISTS region_projection AS
WITH CTE AS (
	SELECT
		region_id,
		projection_id,
		update_year,
		score,
	MIN(score) OVER (PARTITION BY projection_id, update_year) AS xmin,
	MAX(score) OVER (PARTITION BY projection_id, update_year) AS xmax
	FROM (
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
        GROUP BY rc.region_id, pr.id, update_year
	) AS CTE2
)
SELECT
	region_id,
	projection_id,
	update_year,
	(score - xmin) / (xmax - xmin) AS score
FROM CTE;

CREATE MATERIALIZED VIEW IF NOT EXISTS achievement AS
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

CREATE MATERIALIZED VIEW IF NOT EXISTS region_place AS
SELECT
    region_id,
    update_year,
    RANK() OVER (PARTITION BY update_year ORDER BY score DESC) AS place
FROM region_projection rp
WHERE projection_id = 17;

CREATE INDEX rp_year ON region_projection(update_year);
CREATE INDEX rp_projection_year ON region_projection(projection_id, update_year);
CREATE UNIQUE INDEX rp_id ON region_projection(region_id, projection_id, update_year);
CREATE UNIQUE INDEX ach_id ON achievement(region_id, projection_id, update_year);
CREATE UNIQUE INDEX peg_place_id ON region_place(region_id, update_year);