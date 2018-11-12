package com.delta.cru.utils;

import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcpHandler {
	private StringBuilder swaggerUrl = new StringBuilder();
	private ErrorResponses errorResponse = null;
	private String swaggerSpcfctn="Refer Swagger specification URL for more details:";
	@PostConstruct
	public void buildSwaggerUrl() {
		swaggerUrl.append("/swagger-ui.html#/");
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ErrorResponses> unSupportedMediaType(HttpMediaTypeNotSupportedException ex) {
		errorResponse = new ErrorResponses();
		errorResponse.setCode("415");
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setDeveloperMessage("Unsupported media type");
		errorResponse.setMoreInfo(swaggerSpcfctn + swaggerUrl);
		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(errorResponse);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorResponses> badRequest(MissingServletRequestParameterException ex) {
		errorResponse = new ErrorResponses();
		errorResponse.setCode("400");
		errorResponse.setDeveloperMessage(ex.getParameterName() + " is missing");
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setMoreInfo(swaggerSpcfctn + swaggerUrl);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponses> methodArgumentNotValidRequest(MethodArgumentNotValidException ex) {
		errorResponse = new ErrorResponses();
		errorResponse.setCode("400");
		errorResponse.setDeveloperMessage(ex.getParameter() + " is missing");
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setMoreInfo(swaggerSpcfctn + swaggerUrl);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponses> httpMessageNotReadableExceptionRequest(HttpMessageNotReadableException ex) {
		errorResponse = new ErrorResponses();
		errorResponse.setCode("400");
		errorResponse.setDeveloperMessage(ex.getMessage());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setMoreInfo(swaggerSpcfctn + swaggerUrl);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponses> handleException(Exception ex) {
		errorResponse = new ErrorResponses();
		errorResponse.setCode("500");
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setDeveloperMessage("Internal server error occurred: ");
		errorResponse.setMoreInfo(swaggerSpcfctn + swaggerUrl);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
}
