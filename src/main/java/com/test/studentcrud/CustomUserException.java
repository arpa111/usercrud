package com.test.studentcrud;

public class CustomUserException extends RuntimeException{
     CustomUserException(String message)
    {
        super(message);
    }
}
