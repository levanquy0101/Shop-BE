package com.example.shop.exceptions;

public class UserIsExistException extends RuntimeException {
    public UserIsExistException() {
        super("User with this username already exists.");
    }

    public UserIsExistException(String message) {
        super(message);
    }
}