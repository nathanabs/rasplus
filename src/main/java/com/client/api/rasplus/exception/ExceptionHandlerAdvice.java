package com.client.api.rasplus.exception;

import com.client.api.rasplus.dto.error.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
}
