package com.company.tpm.common;
import java.time.Instant; import java.util.UUID; import org.slf4j.*; import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*;
@RestControllerAdvice public class ApiExceptionHandler { private static final Logger log=LoggerFactory.getLogger(ApiExceptionHandler.class);
 public record ErrorResponse(String reference,String message,Instant timestamp){}
 @ExceptionHandler({IllegalArgumentException.class,MethodArgumentNotValidException.class}) ResponseEntity<ErrorResponse> bad(Exception e){return response(HttpStatus.BAD_REQUEST,e,"Validation failed");}
 @ExceptionHandler(Exception.class) ResponseEntity<ErrorResponse> unknown(Exception e){return response(HttpStatus.INTERNAL_SERVER_ERROR,e,"Something went wrong. No changes were saved.");}
 private ResponseEntity<ErrorResponse> response(HttpStatus status,Exception e,String message){String ref="ERR-"+UUID.randomUUID().toString().substring(0,8).toUpperCase();log.error("{}",ref,e);return ResponseEntity.status(status).body(new ErrorResponse(ref,message,Instant.now()));}
}
