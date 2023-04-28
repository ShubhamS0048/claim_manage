package com.memberService.member.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.memberService.member.exceptions.InvalidMemberIdException;

@SpringBootTest
public class InvalidTokenExceptionTest {
	InvalidMemberIdException invalidTokenException = new InvalidMemberIdException("Exception");
	@Test
	 void testComponentTyepNotFoundExceptionTest() {
		
		assertThat(invalidTokenException).isNotNull();    
	}
	
}