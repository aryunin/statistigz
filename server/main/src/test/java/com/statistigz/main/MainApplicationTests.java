package com.statistigz.main;

import com.statistigz.main.provider.YearProvider;
import com.statistigz.main.repository.ProjectionRepository;
import com.statistigz.main.repository.RegionRepository;
import com.statistigz.main.repository.survey.OptionRepository;
import com.statistigz.main.repository.survey.QuestionRepository;
import com.statistigz.main.repository.survey.SurveyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MainApplicationTests {
	@MockBean
	private ProjectionRepository projectionRepository;
	@MockBean
	private RegionRepository regionRepository;
	@MockBean
	private YearProvider yearProvider;
	@MockBean
	private SurveyRepository surveyRepository;
	@MockBean
	private QuestionRepository questionRepository;
	@MockBean
	private OptionRepository optionRepository;

	@Test
	void contextLoads() {
	}

}
