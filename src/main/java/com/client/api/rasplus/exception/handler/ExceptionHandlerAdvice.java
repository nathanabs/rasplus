package com.client.api.rasplus.exception.handler;

import com.client.api.rasplus.dto.error.ExceptionDto;
import com.client.api.rasplus.exception.BusinessException;
import com.client.api.rasplus.exception.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundException(NotFoundException exception){
        var response = ExceptionDto.builder()
                .message(exception.getMessage())
                .httpStatus(NOT_FOUND)
                .statusCode(NOT_FOUND.value())
                .build();

        return ResponseEntity.status(NOT_FOUND).body(response);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDto> DataIntegrityViolationException(DataIntegrityViolationException exception){
        var response = ExceptionDto.builder()
                .message(exception.getMostSpecificCause().getMessage())
                .httpStatus(BAD_REQUEST)
                .statusCode(BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> methodArgumentNotValidException(MethodArgumentNotValidException exception){

        var map = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            map.put(field, defaultMessage);
        });

        var response = ExceptionDto.builder()
                .message(Arrays.toString(map.entrySet().toArray()))
                .httpStatus(HttpStatus.valueOf(exception.getStatusCode().value()))
                .statusCode(exception.getStatusCode().value())
                .build();

        return ResponseEntity.status(NOT_FOUND).body(response);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionDto> notFoundException(BusinessException exception){
        var response = ExceptionDto.builder()
                .message(exception.getMessage())
                .httpStatus(CONFLICT)
                .statusCode(CONFLICT.value())
                .build();

        return ResponseEntity.status(CONFLICT).body(response);
    }
}
