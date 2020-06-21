package com.divitngoc.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.divitngoc.factory.ErrorResponseFactory;
import com.divitngoc.model.error.ErrorResponse;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionController {

	private final ErrorResponseFactory errorResponseFactory;

	/**
	 * 
	 * Example:
	 * <pre>
{
	"httpStatus": 400,
	"field": "songRequest.title",
	"errorMessage": "Title must not be null/blank"
}
	 * </pre>
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> unHandledExceptions(MethodArgumentNotValidException e) {
		final HttpStatus status = HttpStatus.BAD_REQUEST;
		final BindingResult br = e.getBindingResult();

		ErrorResponse error = ErrorResponse.builder().errorMessage(br.getFieldError().getDefaultMessage())
				.field(getFieldPath(br.getFieldError().getArguments())).httpStatus(status.value()).build();
		return ResponseEntity.status(status).body(error);
	}

	private String getFieldPath(Object[] fieldArguments) {
		// TODO add defensive programming
		DefaultMessageSourceResolvable source = (DefaultMessageSourceResolvable) fieldArguments[0];
		return source.getCodes()[0];
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> unHandledExceptions(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseFactory.buildError(e));
	}

}
