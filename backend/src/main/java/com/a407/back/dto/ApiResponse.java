package com.a407.back.dto;

import com.a407.back.config.SuccessCode;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final int status;
    private final String message;
    private final T data;

    public ApiResponse (SuccessCode successCode, T data) {
        this.status = successCode.getStatus();
        this.message = successCode.getMessage();
        this.data = data;
    }
}