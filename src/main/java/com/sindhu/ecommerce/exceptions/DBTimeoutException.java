package com.sindhu.ecommerce.exceptions;

public class DBTimeoutException extends Exception {
    public DBTimeoutException(String message){
        super(message);
    }
}
