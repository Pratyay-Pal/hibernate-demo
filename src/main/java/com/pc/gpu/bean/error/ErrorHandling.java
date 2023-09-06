package com.pc.gpu.bean.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandling {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> requestArgumentErrorHandler(MethodArgumentNotValidException ex){
		List<String> errorList = new ArrayList<>();
		ex.getAllErrors().forEach(error -> errorList.add(error.getDefaultMessage()));
		String errors=String.join(",", errorList);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(errors);
		errorResponse.setStatus(400);
		errorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> requestArgumentErrorHandler(HttpMessageNotReadableException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("No arguments provided");
		errorResponse.setStatus(400);
		errorResponse.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
