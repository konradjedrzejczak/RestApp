package com.konrad.RestaurantApp.Exception;

public class ServiceException extends RuntimeException{

    public ServiceException(String message) {
        super(message);
    }
}
