package com.daos.Controller.Errors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.daos.Exception.Excepcion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorHandler {

   public ResponseEntity<ErrorInfo> methodArgumentNotValidException(HttpServletRequest request, Excepcion e) {
	   //var statusCode= e.getStatusCode(); WARNING
	   
       ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
       return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
   }
   
   static public String formatearErrors(BindingResult result) throws JsonProcessingException {
		
		// PRIMERO TRANSFORMAMOS LA LISTA DE ERRORES DEVUELTOS POR JAVA BEAN VALIDATION
		List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {
		Map<String, String> error= new HashMap<>();
		
		error.put(err.getField(),err.getDefaultMessage() ); return error; }).collect(Collectors.toList());
		
		ErrorMensaje e1 = new ErrorMensaje();
		e1.setCodigo("01");
		e1.setMensajes(errors);
		
		// AHORA USAMOS LA LIBRERÍA JACKSON PARA PASAR EL OBJETO A JSON
		
		ObjectMapper mapper = new ObjectMapper();
		String JSON = mapper.writeValueAsString(e1);
		return JSON;
	}
   

	@ExceptionHandler(Excepcion.class)
	public ResponseEntity<Object> handleExcepcion(Excepcion ex, WebRequest request) {
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("Status Cod", HttpStatus.CONFLICT);
		responseBody.put("Mensaje:", ex.getMensaje());

		return new ResponseEntity<>(responseBody, HttpStatus.CONFLICT);
	}
}