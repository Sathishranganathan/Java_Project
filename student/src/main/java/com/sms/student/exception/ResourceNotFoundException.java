package com.sms.student.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class ResourceNotFoundException  extends RuntimeException{

    public  ResourceNotFoundException (String message){
        super(message);
    }
}
