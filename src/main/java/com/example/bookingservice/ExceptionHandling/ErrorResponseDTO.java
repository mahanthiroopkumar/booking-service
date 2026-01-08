package com.example.bookingservice.ExceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponseDTO {

	private String apiPath;
	private HttpStatus status;
	private String errorMessage;
	private LocalDateTime time;
	public String getApiPath() {
		return apiPath;
	}
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public ErrorResponseDTO(String apiPath, HttpStatus status, String errorMessage, LocalDateTime time) {
		//super();
		this.apiPath = apiPath;
		this.status = status;
		this.errorMessage = errorMessage;
		this.time = time;
	}
	
}
