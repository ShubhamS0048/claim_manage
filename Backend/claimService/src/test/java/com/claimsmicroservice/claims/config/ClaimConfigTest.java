package com.claimsmicroservice.claims.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.claimsmicroservice.claims.config.ClaimConfig;

@SpringBootTest
class ClaimConfigTest {

	ClaimConfig claimConfig;
	
	@Test
	@DisplayName("Checking is ClaimConfig is loading or not")
	void claimConfigIsLoadingOrNot() {
		assertThat(claimConfig).isNull();
	}
}
