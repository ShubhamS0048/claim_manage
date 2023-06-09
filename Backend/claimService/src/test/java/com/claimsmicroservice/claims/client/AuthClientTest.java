package com.claimsmicroservice.claims.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.claimsmicroservice.claims.client.AuthClient;

@SpringBootTest
class AuthClientTest {

	AuthClient authClient;
	
	@Test
	@DisplayName("Checking is AuthClient is loading or not")
	void authClientIsLoadingOrNot() {
		assertThat(authClient).isNull();
	}
}
