package com.example.nto.exception;

public class NoSuchEmployeeException extends RuntimeException{
    public NoSuchEmployeeException(String msg)
    {
        super(msg);
    }
}
