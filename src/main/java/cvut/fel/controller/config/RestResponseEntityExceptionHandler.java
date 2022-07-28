package cvut.fel.controller.config;


import cvut.fel.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public static final String FIELD_MISSING = "FIELD_MISSING";
	public static final String FIELD_INVALID = "FIELD_INVALID";
	public static final String FIELD_TOO_LONG = "FIELD_TOO_LONG";

	@ExceptionHandler(value = {NotFoundException.class})
	protected ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorCode());
	}

	@ExceptionHandler(value = {FieldMissingException.class})
	protected ResponseEntity<Object> handleFieldMissingException(FieldMissingException ex) {
		return badRequest(FIELD_MISSING + ": " + ex.getMessage());
	}

	@ExceptionHandler(value = {FieldInvalidException.class})
	protected ResponseEntity<Object> handleFieldInvalidException(FieldInvalidException ex) {
		return badRequest(FIELD_INVALID + ": " + ex.getMessage());
	}

	@ExceptionHandler(value = {FieldTooLongException.class})
	protected ResponseEntity<Object> handleFieldTooLongException(FieldTooLongException ex) {
		return badRequest(FIELD_TOO_LONG + ": " + ex.getMessage());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers,
																  HttpStatus status,
																  WebRequest request) {
		Error err = errorResponse();
		return badRequest(err);
	}

	private ResponseEntity<Object> badRequest(Error error) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	private ResponseEntity<Object> badRequest(String message) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}

	private Error errorResponse() {
		return new Error();
	}

	private String getUuid() {
		return UUID.randomUUID().toString();
	}
}
