package net.madvirus.spring4.chap07.jgkim;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice("net.madvirus.spring4.chap07.jgkim")
public class CommonException {
    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public String ExceptionHandler() {
        return "error";
    }
}
