package com.example.bookingservice.ExceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDTO> alreadyExists(AlreadyExistsException exception,WebRequest request){
		ErrorResponseDTO error=new ErrorResponseDTO(
				request.getDescription(false),
				HttpStatus.CONFLICT,
				exception.getMessage(),
				LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(error);
	}
}
