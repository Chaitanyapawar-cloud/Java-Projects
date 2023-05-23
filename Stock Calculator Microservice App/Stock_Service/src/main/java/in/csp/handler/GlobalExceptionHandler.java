package in.csp.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.csp.exception.StockNotFoundException;
import in.csp.exception.error;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<error> StockNotFoundExHandler(StockNotFoundException se)
	{
		
		return new ResponseEntity<error>(new error(LocalDateTime.now(), se.getMessage(), "Bad_Request"),HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler
	public ResponseEntity<error> AllExpHandler(Exception e)
	{
		
		return new ResponseEntity<error>(new error(LocalDateTime.now(), e.getMessage(), "Bad_Request"),HttpStatus.BAD_REQUEST);
		
	}

}
