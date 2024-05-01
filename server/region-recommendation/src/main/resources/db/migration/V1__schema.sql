-- Кластер
CREATE TABLE IF NOT EXISTS cluster (
    id int PRIMARY KEY -- PK id
);

-- Отображение кластера в регионы
CREATE TABLE IF NOT EXISTS cluster_region (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,                        -- PK бесполезный
    cluster_id int REFERENCES cluster(id) ON DELETE CASCADE ON UPDATE CASCADE,  -- FK кластер
    region_id bigint NOT NULL, -- REFERENCES region(id) ON DELETE CASCADE ON UPDATE CASCADE,            -- FK регион
    UNIQUE(cluster_id, region_id)
);

CREATE INDEX cluster_idx ON cluster_region(cluster_id);
CREATE INDEX region_idx  ON cluster_region(region_id);