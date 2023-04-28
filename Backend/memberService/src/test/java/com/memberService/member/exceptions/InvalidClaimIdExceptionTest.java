package com.memberService.member.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.memberService.member.exceptions.InvalidClaimIdException;

@SpringBootTest
public class InvalidClaimIdExceptionTest {
	InvalidClaimIdException invalidClaimIdException = new InvalidClaimIdException("Exception");
	@Test
	 void testComponentTyepNotFoundExceptionTest() {
		
		assertThat(invalidClaimIdException).isNotNull();    
	}
	
}