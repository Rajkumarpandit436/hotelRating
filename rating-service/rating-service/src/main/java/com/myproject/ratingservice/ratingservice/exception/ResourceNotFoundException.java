package com.myproject.ratingservice.ratingservice.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("resource not found on the server !!");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
