package com.memberService.member;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.memberService.member")
public class MemberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}
	
	@Bean
	public Docket configureSwagger2(){
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.any())
					.apis(RequestHandlerSelectors.basePackage("com.memberService.member"))
			
					.build()
					.apiInfo(apiInfo());
				
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfo(
				"Member Module",
				"Claims Management Microservice",
				"1.0",
				"Shubhangi - Programmer Analyst Trainee || Full Stack ...in.linkedin.com",
				new Contact("Shubhangi", "something.com","Shubhangi01@cognizant.com"),
				"FSE", "https://hello.shubhi.com",
				Collections.emptyList()
		);
	}
	

}
