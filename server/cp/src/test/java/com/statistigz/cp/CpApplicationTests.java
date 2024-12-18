package com.statistigz.cp;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CpApplicationTests {
	@MockBean
	private EntityManager entityManager;

	@Test
	void contextLoads() {
	}

}
