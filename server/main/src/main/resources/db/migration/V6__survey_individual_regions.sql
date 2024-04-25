INSERT INTO survey.survey(name) VALUES ('Индивидуальный подбор регионов');

-----------------------------------------------------------------------------------------------------------
INSERT INTO survey.question(survey_id, text, order_idx) VALUES (1, 'Ваш возраст', 1);
INSERT INTO survey."option"(question_id, text, order_idx) VALUES
    (1, '12-16', 1),
    (1, '17-22', 2),
    (1, '23-27', 3),
    (1, '28-45', 4),
    (1, '> 45',  5);

-----------------------------------------------------------------------------------------------------------
INSERT INTO survey.question(survey_id, text, order_idx) VALUES (1, 'Ваш пол', 2);
INSERT INTO survey."option"(question_id, text, order_idx) VALUES
    (2, 'М', 1),
    (2, 'Ж', 2);

-----------------------------------------------------------------------------------------------------------
INSERT INTO survey.question(survey_id, text, order_idx) VALUES (1, 'Представьте, что есть система персональной подборки лучших регионов, которые вам наиболее всего подходят, для чего вы бы рассматривали этот список?', 3);
INSERT INTO survey."option"(question_id, text, order_idx) VALUES
    (3, 'Для переезда и постоянного проживания',           1),
    (3, 'Для временного проживания (от месяца до года)',   2),
    (3, 'Для временного проживания (от года до трёх лет)', 3),
    (3, 'Для отдыха (до месяца)',                          4);

--INSERT INTO Survey_Question(question_text) VALUES ('Семейное положение');
--INSERT INTO Survey_Question(question_text) VALUES ('Насколько сильно вас интересует вопрос экологии в регионе будущего проживания?');
--INSERT INTO Survey_Question(question_text) VALUES ('Условия вашего проживания');
--INSERT INTO Survey_Question(question_text) VALUES ('Интересует ли вас уровень заработной платы в регионе?");
--INSERT INTO Survey_Question(question_text) VALUES ('Насколько для вас важна оснащенность региона местами культурного назначения (парки, театры, кинозалы)?');
--INSERT INTO Survey_Question(question_text) VALUES ('Как часто вы пользуетесь общественным транспортом (личным авто)?');
--INSERT INTO Survey_Question(question_text) VALUES ('Насколько внимательно вы следите за новшествами в технической области?');
--INSERT INTO Survey_Question(question_text) VALUES ('Часто ли вы нуждаетесь в качественной медицинской помощи?');
--INSERT INTO Survey_Question(question_text) VALUES ('Часто ли пользуетесь различными услугами в регионе (например, доставкой)?');
--INSERT INTO Survey_Question(question_text) VALUES ('Насколько для вас важен средний уровень жизни в регионе?');
--INSERT INTO Survey_Question(question_text) VALUES ('Важна ли для вас финансовая составляющая региона? (Насколько он богат за счет собственных средств и налоговых сборов)');
--INSERT INTO Survey_Question(question_text) VALUES ('Важен ли для вас показатель уровня образования в регионе?');
--INSERT INTO Survey_Question(question_text) VALUES ('Насколько важна удовлетворенность от экономической деятельности региона? (для предпринимателей)');
--INSERT INTO Survey_Question(question_text) VALUES ('Планируете ли вы устраиваться на работу в новом регионе?');