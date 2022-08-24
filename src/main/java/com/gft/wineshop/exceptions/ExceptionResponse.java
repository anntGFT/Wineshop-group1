package com.gft.wineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;



@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class ExceptionResponse extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExceptionResponse(String message) {
		super(message);
	}
}
