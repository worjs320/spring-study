package net.madvirus.spring4.chap07.jgkim;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("net.madvirus.spring4.chap07.jgkim")
public class CommonException {
    @ExceptionHandler(Exception.class)
    public String ExceptionHandler() {
        return "error";
    }
}
