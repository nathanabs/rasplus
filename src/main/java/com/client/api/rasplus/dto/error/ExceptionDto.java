package com.client.api.rasplus.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ExceptionDto {

    private String message;
    private HttpStatus httpStatus;
    private Integer statusCode;
}
