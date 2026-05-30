package com.dueldle.dueldlebackend.api.exception_handler;

import com.dueldle.dueldlebackend.domain.exception.LolChampionAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LolChampionAlreadyExistsException.class)
    public ProblemDetail championAlreadyExists(LolChampionAlreadyExistsException ex, WebRequest webRequest) {
        var status = HttpStatus.CONFLICT;
        var detail = ex.getMessage();
        var problemDetail = ProblemDetail.forStatusAndDetail(status, detail);
        problemDetail.setTitle("Champion already exists.");
        return problemDetail;
    }
}
