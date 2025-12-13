package com.lhernandez.fibonacci.app.dto;

import java.time.Instant;
import java.util.List;

public record ApiResponseDto<T>(
        boolean success,
        String message,
        T data,
        List<String> errors,
        Instant timeStamp
){
    public ApiResponseDto(T data, String message) {
        this(true, message, data, null, Instant.now());
    }


    public ApiResponseDto(List<String> errors, String message) {
        this(false, message, null, errors, Instant.now());
    }

    public static <T> ApiResponseDto<T> ok(T data) {
        return new ApiResponseDto<>(true, "OK", data, null, Instant.now());
    }

    public static <T> ApiResponseDto<T> ok(T data, String message) {
        return new ApiResponseDto<>(true, message, data, null, Instant.now());
    }

    public static <T> ApiResponseDto<T> error(List<String> errors, String message) {
        return new ApiResponseDto<>(false, message, null, errors, Instant.now());
    }
}
