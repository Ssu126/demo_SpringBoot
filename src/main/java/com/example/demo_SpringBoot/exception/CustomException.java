package com.example.demo_SpringBoot.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private ExceptionType type;

    public CustomException(Exception type) {
        super();
    }

    public CustomException(ExceptionType type, Object message) {
        super(type.getDesc() + message.toString());
        this.type = type;
    }
}
