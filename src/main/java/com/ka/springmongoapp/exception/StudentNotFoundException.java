package com.ka.springmongoapp.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super("Student not found. cne : "+message);
    }
}