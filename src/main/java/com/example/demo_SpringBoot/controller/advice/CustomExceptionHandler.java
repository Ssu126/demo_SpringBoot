package com.example.demo_SpringBoot.controller.advice;

import com.example.demo_SpringBoot.controller.dto.common.BaseResponse;
import com.example.demo_SpringBoot.exception.CustomException;
import com.example.demo_SpringBoot.exception.ExceptionType;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public BaseResponse<Void> handle(CustomException e) {
        ExceptionType type = e.getType();
        log.atLevel(type.getLevel()).setCause(e).log(e.getMessage());
        return BaseResponse.failure(type);
    }

    @ExceptionHandler
    @ResponseBody
    public BaseResponse<List<FieldErrorDto>> handle(MethodArgumentNotValidException e) {
        List<FieldErrorDto> errors = new ArrayList<>();
        StringBuilder messageBuilder = new StringBuilder();
        for (ObjectError each : e.getBindingResult().getAllErrors()) {
            FieldError eachError = (FieldError) each;
            messageBuilder.append(
                String.format("[%s = %s : %s] ", eachError.getField(), eachError.getRejectedValue(),
                    eachError.getDefaultMessage()));
            errors.add(new FieldErrorDto(eachError.getField(), eachError.getRejectedValue(),
                eachError.getDefaultMessage()));
        }
        log.warn(messageBuilder.toString(), e);
        return BaseResponse.failure(ExceptionType.INVALID_INPUT, errors);
    }

    @ExceptionHandler
    @ResponseBody
    public BaseResponse<Void> handle(Exception e) {
        log.error(e.getMessage(), e);
        return BaseResponse.failure(ExceptionType.UNCLASSIFIED_ERROR);
    }
}