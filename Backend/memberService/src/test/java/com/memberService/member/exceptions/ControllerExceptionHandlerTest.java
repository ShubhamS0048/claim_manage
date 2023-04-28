package com.memberService.member.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.memberService.member.exceptions.ControllerExceptionHandler;


@SpringBootTest
public class ControllerExceptionHandlerTest {
	
	@InjectMocks
	ControllerExceptionHandler controllerHandler;
	
	
	@Test
	@DisplayName("Checking if Controller Advice is Loading or not")
	 void testControllerExceptionHandlerTest() {
		
		ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();
		assertThat(controllerExceptionHandler).isNotNull();    
	}
	
	
	
}