package com.myproject.ratingservice.ratingservice.exception;

import com.myproject.ratingservice.ratingservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandel {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String msg = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
