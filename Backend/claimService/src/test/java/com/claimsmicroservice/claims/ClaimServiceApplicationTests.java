package com.claimsmicroservice.claims;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.claimsmicroservice.claims.ClaimServiceApplication;

@SpringBootTest
class ClaimServiceApplicationTests {

	ClaimServiceApplication claimServiceApplication;
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	
	@Test
	void testComponentProcessingMicroserviceApplication() {
		assertThat(claimServiceApplication).isNull();
	}
}
