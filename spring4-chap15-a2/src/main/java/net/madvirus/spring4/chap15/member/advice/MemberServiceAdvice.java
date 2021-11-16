package net.madvirus.spring4.chap15.member.advice;

import net.madvirus.spring4.chap15.member.api.MemberService;
import net.madvirus.spring4.chap15.member.exception.MemberNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = MemberService.class)
public class MemberServiceAdvice {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<?> memberNotFoundException(MemberNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
