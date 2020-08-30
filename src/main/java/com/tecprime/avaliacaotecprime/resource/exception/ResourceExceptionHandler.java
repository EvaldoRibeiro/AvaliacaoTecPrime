package com.tecprime.avaliacaotecprime.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tecprime.avaliacaotecprime.services.exceptions.ObjectNotFoundException;



@ControllerAdvice
public class ResourceExceptionHandler {
	 
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
//	@ExceptionHandler(DataIntegrityException.class)
//	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
//		
//		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//	}
//	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
//		
//		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro da Validação", System.currentTimeMillis());
//		for(FieldError x : e.getBindingResult().getFieldErrors()) {
//			err.addError(x.getField(), x.getDefaultMessage());
//		}  		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//	}
//	
//}


}
