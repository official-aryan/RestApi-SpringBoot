package com.demo.ExceptionHandling;

public class EmptyResultDataAccessException extends RuntimeException {

	public EmptyResultDataAccessException(String message) {
		super(message);
	}
}
