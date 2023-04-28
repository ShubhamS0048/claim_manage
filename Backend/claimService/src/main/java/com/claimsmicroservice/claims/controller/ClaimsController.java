package com.claimsmicroservice.claims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claimsmicroservice.claims.client.AuthClient;
import com.claimsmicroservice.claims.dto.ClaimDTO;
import com.claimsmicroservice.claims.dto.ClaimStatusDTO;
import com.claimsmicroservice.claims.exceptions.InvalidClaimIdException;
import com.claimsmicroservice.claims.exceptions.InvalidTokenException;
import com.claimsmicroservice.claims.service.ClaimStatusService;
import com.claimsmicroservice.claims.service.SubmitClaimService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/claimModule")
@Api(value = "For dealing with claim ")
public class ClaimsController {

	@Autowired
	private ClaimStatusService claimStatusService;
	@Autowired
	private SubmitClaimService submitClaimService;
	
	@Autowired
	private AuthClient authClient;
	
	@GetMapping(path="/getClaimStatus/{id}")
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(@PathVariable("id") String id,@RequestHeader(name = "Authorization", required = true) String token)throws InvalidClaimIdException,InvalidTokenException {
		log.info(token);
		if (!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		
		log.info("inside the get Claim Status : BEGIN");
		return claimStatusService.getClaimStatus(id); 
	}
	

	
	@PostMapping(path ="/submitClaim")
	public ResponseEntity<ClaimStatusDTO> submitClaim(@RequestBody ClaimDTO claimDTO,@RequestHeader(name = "Authorization", required = true) String token)throws InvalidTokenException,NullPointerException {
		log.info(token);
		if (!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		log.info("inside the submit Claim : BEGIN");
		return submitClaimService.submitClaim(claimDTO,token);
	}
	
}
