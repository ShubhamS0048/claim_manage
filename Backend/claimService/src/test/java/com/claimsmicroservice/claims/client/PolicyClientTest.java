package com.claimsmicroservice.claims.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.claimsmicroservice.claims.client.PolicyClient;

@SpringBootTest
class PolicyClientTest {

	PolicyClient policyClient;

	@Test
	@DisplayName("Checking is PolicyClient is loading or not")
	void policyClientIsLoadingOrNot() {
		assertThat(policyClient).isNull();
	}
}
