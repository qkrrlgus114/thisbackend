package com.parkgihyeon.product.management.presentation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Validation 에러
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException e){
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

        List<String> errors = constraintViolations.stream()
                .map(constraintViolation -> constraintViolation.getPropertyPath() + ", " + constraintViolation.getMessage())
                .toList();

        ErrorMessage errorMessage = new ErrorMessage(errors);

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
