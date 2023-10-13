package com.spring_crud.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String message)
    {
        super(message);
    }
}
