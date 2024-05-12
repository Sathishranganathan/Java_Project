package com.sms.student.exception;

public class CustomerAlreadyExistsException extends RuntimeException{

    public CustomerAlreadyExistsException(String message){
        super(message);
    }
}

