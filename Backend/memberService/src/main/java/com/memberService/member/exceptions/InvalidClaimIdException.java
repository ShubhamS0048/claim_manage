package com.memberService.member.exceptions;

public class InvalidClaimIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidClaimIdException(String message)
	{
		super(message);
	}

}
