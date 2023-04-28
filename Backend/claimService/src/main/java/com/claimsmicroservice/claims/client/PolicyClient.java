package com.claimsmicroservice.claims.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.claimsmicroservice.claims.dto.BenefitsDTO;
import com.claimsmicroservice.claims.dto.ClaimAmountDTO;
import com.claimsmicroservice.claims.dto.ProviderDTO;


@FeignClient(name = "policy-service", url = "${Policy.URL}")
public interface PolicyClient {
	@GetMapping(path="/getChainOfProviders/{policyId}")
	public ResponseEntity<ProviderDTO> getChainOfProviders(@PathVariable String policyId,@RequestHeader(name = "Authorization", required = true) String token);
	
	@GetMapping(path="/getEligibleBenefits/{policyId}/{memberId}")
	public ResponseEntity<BenefitsDTO> getEligibleBenefits(@PathVariable String policyId,@PathVariable String memberId,@RequestHeader(name = "Authorization", required = true) String token);
	
	@GetMapping(path="/getEligibleClaimAmount/{policyId}/{memberId}")
	public ResponseEntity<ClaimAmountDTO> getEligibleAmount(@PathVariable String policyId,@PathVariable String memberId,@RequestHeader(name = "Authorization", required = true) String token);
}
