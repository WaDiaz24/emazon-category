package com.emazon.categoria.domain.exception;

public class CategoryInvalidException extends RuntimeException{

    public CategoryInvalidException(String message){
        super(message);
    }
}
