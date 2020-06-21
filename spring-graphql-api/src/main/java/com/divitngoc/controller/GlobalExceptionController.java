package com.divitngoc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.divitngoc.factory.ErrorResponseFactory;
import com.divitngoc.model.error.ErrorResponse;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionController {

	private final ErrorResponseFactory errorResponseFactory;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> unHandledExceptions(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseFactory.buildError(e));
	}

}
