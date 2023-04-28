package com.claimsmicroservice.claims.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.claimsmicroservice.claims.client.AuthClient;
import com.claimsmicroservice.claims.controller.ClaimsController;
import com.claimsmicroservice.claims.dto.ClaimDTO;
import com.claimsmicroservice.claims.dto.ClaimStatusDTO;
import com.claimsmicroservice.claims.dto.ValidatingDTO;
import com.claimsmicroservice.claims.exceptions.InvalidTokenException;
import com.claimsmicroservice.claims.service.ClaimStatusService;
import com.claimsmicroservice.claims.service.SubmitClaimService;

@SpringBootTest
class ClaimsControllerTest {

	@Autowired
	ClaimsController claimsController;
	@MockBean
	AuthClient authClient;
	@MockBean
	SubmitClaimService submitClaimService;
	@MockBean
	ClaimStatusService claimStatusService;
	
	@Test
    @DisplayName("Checking for Claims Controller - if it is loading or not for @GetMapping")
    void componentProcessingControllerNotNullTest(){
        assertThat(claimsController).isNotNull();
    }
	
	@Test
	@DisplayName("Checking getClaimStatus Endpoint with Invalid Token")
	void testGetClaimStatusEndpointWithInvalidToken() {
		String token="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		when(authClient.getsValidity(token)).thenReturn(validatingDTO);
		
		assertThrows(InvalidTokenException.class, () ->
        claimsController.getClaimStatus("C101",token));
	}
	
	@Test
	@DisplayName("Checking submit Claim Endpoint with Invalid Token")
	void testSubmitClaimEndpointWithInvalidToken() {
		String token="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		when(authClient.getsValidity(token)).thenReturn(validatingDTO);
		ClaimDTO claimDTO=new ClaimDTO();
		assertThrows(InvalidTokenException.class, () ->
        claimsController.submitClaim(claimDTO,token));
	}

	
	@Test
	@DisplayName("Checking the working of get claim Status Endpoint")
	void testGetClaimStatusWithValidParameters() {
		String token="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		
		ClaimStatusDTO claimStatusDTO=new ClaimStatusDTO();
		claimStatusDTO.setClaimId("C101");
		claimStatusDTO.setClaimStatus("Pending");
		claimStatusDTO.setClaimDescription("Verified");
		
		when(authClient.getsValidity(token)).thenReturn(validatingDTO);
		when(claimStatusService.getClaimStatus("C101")).thenReturn(new ResponseEntity<ClaimStatusDTO>(claimStatusDTO,HttpStatus.OK));
		
		
		assertEquals(claimStatusDTO.getClaimId(), claimsController.getClaimStatus("C101",token).getBody().getClaimId()); 
		assertEquals(claimStatusDTO.getClaimStatus(), claimsController.getClaimStatus("C101",token).getBody().getClaimStatus()); 
		assertEquals(claimStatusDTO.getClaimDescription(), claimsController.getClaimStatus("C101",token).getBody().getClaimDescription()); 
	}
	
	@Test
	@DisplayName("Checking the working of Submit claim  Endpoint")
	void testSubmitClaimWithValidParameters() {
		String token="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		ClaimDTO claimDTO=new ClaimDTO();
		ClaimStatusDTO claimStatusDTO=new ClaimStatusDTO();
		claimStatusDTO.setClaimId("C101");
		claimStatusDTO.setClaimStatus("Pending");
		claimStatusDTO.setClaimDescription("Verified");
		
		when(authClient.getsValidity(token)).thenReturn(validatingDTO);
		when(submitClaimService.submitClaim(claimDTO,token)).thenReturn(new ResponseEntity<ClaimStatusDTO>(claimStatusDTO,HttpStatus.OK));
		
		
		assertEquals(claimStatusDTO.getClaimId(), claimsController.submitClaim(claimDTO,token).getBody().getClaimId()); 
		assertEquals(claimStatusDTO.getClaimStatus(), claimsController.submitClaim(claimDTO,token).getBody().getClaimStatus()); 
		assertEquals(claimStatusDTO.getClaimDescription(),claimsController.submitClaim(claimDTO,token).getBody().getClaimDescription()); 
	}
}
