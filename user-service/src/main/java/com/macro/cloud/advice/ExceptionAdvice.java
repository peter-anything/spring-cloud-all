package com.macro.cloud.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public String handlerException(Exception e) {
        return e.getMessage();
    }
}
