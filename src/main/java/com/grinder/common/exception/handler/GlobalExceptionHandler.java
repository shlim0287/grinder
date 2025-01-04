package com.grinder.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handlePasswordValidationException(IllegalArgumentException e) {

        log.error("IllegalArgumentException: {}", e.getMessage());
        return "/main/";
    }
}
