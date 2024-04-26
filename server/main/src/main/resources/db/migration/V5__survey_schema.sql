CREATE SCHEMA IF NOT EXISTS survey;

-- Опрос
CREATE TABLE IF NOT EXISTS survey.survey (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY, -- PK id
    name varchar(255) NOT NULL                           -- название опроса
);

-- Вопрос
CREATE TABLE IF NOT EXISTS survey.question (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,                            -- PK id
    survey_id int REFERENCES survey.survey(id) ON DELETE CASCADE ON UPDATE CASCADE, -- FK опрос
    "text" text NOT NULL,                                                           -- текст вопроса
    order_idx int NOT NULL                                                          -- порядковый номер
);

-- Ответ
CREATE TABLE IF NOT EXISTS survey."option" (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,                                -- PK id
    question_id int REFERENCES survey.question(id) ON DELETE CASCADE ON UPDATE CASCADE, -- FK вопрос
    "text" text NOT NULL,                                                               -- текст ответа
    order_idx int NOT NULL                                                              -- порядковый номер
);