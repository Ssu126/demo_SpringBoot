package com.example.demo_SpringBoot.controller.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseResponse<T> {
    private final boolean success;
    @JsonInclude(Include.NON_EMPTY)
    private final String type;
    @JsonInclude(Include.NON_EMPTY)
    private final String message;
    @JsonInclude(Include.NON_NULL)
    private final T body;

    public static <T> BaseResponse<T> of(boolean success, String type, String message, T body) {
        return new BaseResponse<T>(success, type, message, body);
    }

}
