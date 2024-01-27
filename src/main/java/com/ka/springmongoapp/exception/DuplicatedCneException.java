package com.ka.springmongoapp.exception;

public class DuplicatedCneException extends RuntimeException{

    public DuplicatedCneException(String message){
        super("Cne already in use : "+message);
    }
}
