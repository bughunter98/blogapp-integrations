package com.springboot.blog.blogrestapi.exceptions;

import com.springboot.blog.blogrestapi.pojos.ErrorDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //with in this class we are going to handle global and specific exceptions
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException
    (ResourceNotFoundException exception, WebRequest webRequest/*, HttpServletRequest httpServletRequest*/) {
        /*One can get request URI and client information from WebRequest using webRequest. getDescription(true).
        true will show user's information such as client id and false will just print URI*/
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                exception.getMessage(), webRequest.getSessionId(), webRequest.getDescription(false));
        //we can use httpServletRequest also to get the url.
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BlogAPIException.class)
    public ResponseEntity<ErrorDetails> handleBlogRestAPIException(BlogAPIException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                exception.getMessage(), webRequest.getSessionId(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // let's say we are getting any other exceptions apart from the above 2 . byDefault all the
    // exceptions are handled by Exception .. as all the exceptions extend Exception class..
    // even runtimeException also extends Exception class
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDetails> handleDifferentTypesofRestAPIException(Exception exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                exception.getMessage(), webRequest.getSessionId(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // below method is used to handle global exception for requestEntity exceptions
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
           String fieldName = ((FieldError)error).getField();
           String errorMessage = error.getDefaultMessage();
           errors.put(fieldName,errorMessage);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
