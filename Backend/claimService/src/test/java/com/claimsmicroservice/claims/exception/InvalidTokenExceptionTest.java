package com.claimsmicroservice.claims.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.claimsmicroservice.claims.exceptions.InvalidTokenException;

@SpringBootTest
class InvalidTokenExceptionTest {

	 InvalidTokenException  invalidTokenException=new  InvalidTokenException("Exception"); 
	 
	 @Test
	 @DisplayName("Checking if  InvalidTokenException class is loading or not")
	 void  invalidTokenExceptionIsLoadingOrNot() {
		 assertThat(invalidTokenException).isNotNull();
	 }
}
