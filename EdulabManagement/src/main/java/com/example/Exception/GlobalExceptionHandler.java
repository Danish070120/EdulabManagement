package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.entity.Company;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Company> companyNotfoundExceptionHandler(CustomException exception) {
		String message = exception.getMessage();
		Company contact = new Company();
		return new ResponseEntity<Company>(contact, HttpStatus.NOT_FOUND);

	}
}
