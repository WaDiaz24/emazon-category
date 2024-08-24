package com.emazon.categoria.infrastructure.exception;

import com.emazon.categoria.domain.exception.CategoryInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CategoryInvalidException.class})
    public ResponseEntity<Object> categoryInvalidException(CategoryInvalidException e){
        Map<String, String> response = new HashMap<>();
        response.put("Error", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> errorValidationDto(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors().stream().map(DataValidationError::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    private record DataValidationError(String campo, String error){
            public DataValidationError(FieldError error){
                this(error.getField(), error.getDefaultMessage());
            }
    }
}
