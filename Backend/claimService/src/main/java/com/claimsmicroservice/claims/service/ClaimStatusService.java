package com.claimsmicroservice.claims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.claimsmicroservice.claims.dto.ClaimStatusDTO;
import com.claimsmicroservice.claims.exceptions.InvalidClaimIdException;
import com.claimsmicroservice.claims.repository.ClaimRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClaimStatusService {

	@Autowired
	ClaimRepo claimRepo;
	
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(String id) throws InvalidClaimIdException {
			log.info("inside getClaimStatus in service ");
			ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO();
			String status = claimRepo.getStatus(id);
			String desc = claimRepo.getDescription(id);
			if (status == null) {
				throw new InvalidClaimIdException("Invalid Claim ID");
			}
			claimStatusDTO.setClaimStatus(status);
			claimStatusDTO.setClaimDescription(desc);
			claimStatusDTO.setClaimId(id);
			log.info("inside the get Claim Status : ENDED");
			return new ResponseEntity<>(claimStatusDTO, HttpStatus.OK);
	}

}
