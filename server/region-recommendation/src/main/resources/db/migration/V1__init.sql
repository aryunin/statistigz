-- Кластер
CREATE TABLE IF NOT EXISTS cluster (
    id int PRIMARY KEY -- PK id
);

-- Отображение кластера в регионы
CREATE TABLE IF NOT EXISTS cluster_region (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,                        -- PK бесполезный
    cluster_id int REFERENCES cluster(id) ON DELETE CASCADE ON UPDATE CASCADE,  -- FK кластер
    region_id bigint NOT NULL, -- REFERENCES region(id) ON DELETE CASCADE ON UPDATE CASCADE,            -- FK регион todo см. порядок миграций БД сервисов (порядок запуска сервисов)
    UNIQUE(cluster_id, region_id)
);

-- Данные
INSERT INTO cluster(id) VALUES (0);
INSERT INTO cluster_region(cluster_id, region_id) VALUES (0, 7), (0, 19), (0, 21), (0, 51), (0, 72);

INSERT INTO cluster(id) VALUES (1);
INSERT INTO cluster_region(cluster_id, region_id) VALUES (1, 1), (1, 6), (1, 47), (1, 52), (1, 60);

INSERT INTO cluster(id) VALUES (2);
INSERT INTO cluster_region(cluster_id, region_id) VALUES (2, 1), (2, 18), (2, 28), (2, 47), (2, 60);

INSERT INTO cluster(id) VALUES (3);
INSERT INTO cluster_region(cluster_id, region_id) VALUES (3, 10), (3, 16), (3, 18), (3, 28), (3, 55);

INSERT INTO cluster(id) VALUES (4);
INSERT INTO cluster_region(cluster_id, region_id) VALUES (4, 18), (4, 28), (4, 47), (4, 60), (4, 80);

INSERT INTO cluster(id) VALUES (5);
INSERT INTO cluster_region(cluster_id, region_id) VALUES (5, 73), (5, 74), (5, 77), (5, 79), (5, 80);