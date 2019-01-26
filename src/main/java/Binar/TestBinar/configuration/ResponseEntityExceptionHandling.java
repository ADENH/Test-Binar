package Binar.TestBinar.configuration;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import Binar.TestBinar.model.Message;
import Binar.TestBinar.model.Response;

@ControllerAdvice
@RestController
public class ResponseEntityExceptionHandling extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(ProductNotFoundException ex, WebRequest request) {
		Response<Message> exceptionResponse = new Response<>();
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}
