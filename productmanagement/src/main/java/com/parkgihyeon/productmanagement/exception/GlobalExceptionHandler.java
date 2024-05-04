package com.parkgihyeon.productmanagement.exception;

import com.parkgihyeon.productmanagement.domain.order.exception.NotFoundOrderException;
import com.parkgihyeon.productmanagement.domain.product.exception.NoProductAmountException;
import com.parkgihyeon.productmanagement.domain.product.exception.NotFoundProductException;
import com.parkgihyeon.productmanagement.util.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoProductAmountException.class)
    public ResponseEntity<ErrorMessageDTO> NoProductAmountExceptionHandle(NoProductAmountException e){
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(e.getMessage());
        return new ResponseEntity<>(errorMessageDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundProductException.class)
    public ResponseEntity<ErrorMessageDTO> NotFoundProductExceptionHandle(NotFoundProductException e){
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(e.getMessage());
        return new ResponseEntity<>(errorMessageDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundOrderException.class)
    public ResponseEntity<ErrorMessageDTO> NotFoundOrderExceptionHandle(NotFoundOrderException e){
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(e.getMessage());
        return new ResponseEntity<>(errorMessageDTO, HttpStatus.NOT_FOUND);
    }

}
