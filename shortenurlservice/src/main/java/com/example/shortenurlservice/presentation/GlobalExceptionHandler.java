package com.example.shortenurlservice.presentation;

import com.example.shortenurlservice.domain.LackShortenUrlException;
import com.example.shortenurlservice.domain.NotFoundShortenUrlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundShortenUrlException.class)
    public ResponseEntity<String> NotFoundShortenUrlExceptionHandle(NotFoundShortenUrlException e){

        return new ResponseEntity<>("단축 URL을 찾지 못했습니다.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LackShortenUrlException.class)
    public ResponseEntity<String> LackShortenUrlExceptionHandle(LackShortenUrlException e){

        return new ResponseEntity<>("단축 URL 생성중 에러가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
