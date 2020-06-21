package com.divitngoc.factory;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.divitngoc.model.error.ErrorResponse;

@Service
public class ErrorResponseFactory {

	public ErrorResponse buildError(Exception e) {
		return buildError(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ErrorResponse buildError(Exception e, HttpStatus status) {
		// TODO redo error msg
		return ErrorResponse.builder()
							.httpStatus(status.value())
							.errorMessage(e.getMessage())
							.build();
	}

}
