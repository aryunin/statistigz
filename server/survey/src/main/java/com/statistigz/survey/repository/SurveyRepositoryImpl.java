package com.statistigz.survey.repository;

import com.statistigz.survey.entity.Option;
import com.statistigz.survey.entity.Question;
import com.statistigz.survey.entity.Survey;
import com.statistigz.survey.exception.MappingException;
import com.statistigz.survey.util.CustomLogger;
import io.r2dbc.spi.Row;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
public class SurveyRepositoryImpl implements SurveyRepository {
    private final CustomLogger logger;
    private final R2dbcEntityTemplate entityTemplate;

    private final String GET_BY_ID_QUERY = """
            SELECT
                s.id AS survey_id, s.name AS survey_name,
                q.id AS question_id, q.survey_id AS question_survey_id, q.text AS question_text, q.order_idx AS question_order_idx,
                o.id AS option_id, o.question_id AS option_question_id, o.text AS option_text, o.order_idx AS option_order_idx
            FROM survey.survey s
            JOIN survey.question q ON s.id=q.survey_id
            JOIN survey.option o ON q.id=o.question_id
            WHERE s.id=:id
            """;

    @Override
    public Mono<Survey> findById(int id) {
        logger.debug(this, "findById()");
        logger.debug(this, "id = " + id);

        return entityTemplate.getDatabaseClient()
                .sql(GET_BY_ID_QUERY)
                .bind("id", id)
                .map(((row, rowMetadata) -> {
                    Survey survey = readSurvey(row);
                    Question question = readQuestion(row);
                    Option option = readOption(row);

                    if (survey == null || question == null || option == null) throw new MappingException("can't read row " + id);

                    survey.setQuestions(Collections.singletonList(question));
                    question.setOptions(Collections.singletonList(option));

                    return survey;
                }))
                .all()
                .onErrorResume(Mono::error)
                .reduce((s1, s2) -> {
                    List<Question> questions = Stream.concat(s1.getQuestions().stream(), s2.getQuestions().stream()).toList();
                    return new Survey(s1.getId(), s1.getName(), questions);
                })
                .map(survey -> {
                    Map<Integer, Question> questionsMap = new HashMap<>();
                    survey.getQuestions()
                            .forEach(question -> questionsMap.merge(question.getId(), question, (q1, q2) -> {
                                List<Option> options = Stream.concat(q1.getOptions().stream(), q2.getOptions().stream()).toList();
                                return new Question(q1.getId(), q1.getSurveyId(), q1.getText(), q1.getOrderIdx(), options);
                            }));
                    List<Question> questions = questionsMap.values().stream().toList();
                    return new Survey(survey.getId(), survey.getName(), questions);
                });
    }

    private static Survey readSurvey(Row row) {
        Integer id  = row.get("survey_id", Integer.class);
        String name = row.get("survey_name", String.class);
        if (id == null || name == null) return  null;
        return new Survey(id, name, null);
    }

    private static Question readQuestion(Row row) {
        Integer id       = row.get("question_id", Integer.class);
        Integer surveyId = row.get("question_survey_id", Integer.class);
        String text      = row.get("question_text", String.class);
        Integer orderIdx = row.get("question_order_idx", Integer.class);
        if (id == null || surveyId == null || text == null || orderIdx == null) return null;
        return new Question(id, surveyId, text, orderIdx, null);
    }

    private static Option readOption(Row row) {
        Integer id         = row.get("option_id", Integer.class);
        Integer questionId = row.get("option_question_id", Integer.class);
        String text        = row.get("option_text", String.class);
        Integer orderIdx   = row.get("option_order_idx", Integer.class);
        if (id == null || questionId == null || text == null || orderIdx == null) return null;
        return new Option(id, questionId, text, orderIdx);
    }
}
