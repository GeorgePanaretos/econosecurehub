package com.backend.econosecurehub.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
