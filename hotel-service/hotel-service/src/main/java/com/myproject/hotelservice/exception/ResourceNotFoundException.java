package com.myproject.hotelservice.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource Not Found on the Server !!");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
