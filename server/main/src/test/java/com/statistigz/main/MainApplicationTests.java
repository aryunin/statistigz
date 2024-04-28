package com.statistigz.main;

import com.statistigz.main.provider.YearProvider;
import com.statistigz.main.repository.ProjectionRepository;
import com.statistigz.main.repository.RegionRepository;
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

	@Test
	void contextLoads() {
	}

}
