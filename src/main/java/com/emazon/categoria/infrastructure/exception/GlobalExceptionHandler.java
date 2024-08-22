package com.emazon.categoria.infrastructure.exception;

import com.emazon.categoria.domain.exception.CategoryInvalidException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CategoryInvalidException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Object> categoryInvalidException(CategoryInvalidException e, MethodArgumentNotValidException ex){
        Map<String, String> response = new HashMap<>();
        response.put("Error", e.getMessage());
        response.put("Error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
