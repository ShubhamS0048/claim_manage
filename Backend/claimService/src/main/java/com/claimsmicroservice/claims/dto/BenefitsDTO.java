package com.claimsmicroservice.claims.dto;

import java.util.List;

import com.claimsmicroservice.claims.model.Benefits;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BenefitsDTO {
	
	@JsonProperty
	 private List<Benefits> benefits;

	@JsonIgnore
	public List<Benefits> getBenefits() {
		return benefits;
	}

	@JsonIgnore
	public void setBenefits(List<Benefits> benefits) {
		this.benefits = benefits;
	}

	@JsonIgnore
	public BenefitsDTO(List<Benefits> benefits) {
		super();
		this.benefits = benefits;
	}
	
	
	
	
	

}