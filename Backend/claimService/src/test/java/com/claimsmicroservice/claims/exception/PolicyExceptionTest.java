package com.claimsmicroservice.claims.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.claimsmicroservice.claims.exceptions.PolicyException;

@SpringBootTest
class PolicyExceptionTest {

PolicyException policyException=new PolicyException("Exception");
	
	@Test
	@DisplayName("Checking if PolicyException class is loading or not")
	void policyExceptionIsLoadingOrNot() {
		assertThat(policyException).isNotNull();
	}
}
