package com.kovalev.dto.response;

import lombok.Getter;

import java.util.Collection;

@Getter
public class BadValidationResponse extends ExceptionResponse {

	private final Collection<String> invalidFields;

	public BadValidationResponse(String message, String cause, Collection<String> invalidFields) {
		super(message, cause);
		this.invalidFields = invalidFields;
	}
}
