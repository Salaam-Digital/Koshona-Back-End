package com.product.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import java.util.Optional;

@ControllerAdvice
public class ExceptionController implements ProblemHandling {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<Problem> notBlankException(ProductException response) {
        return ResponseEntity.of(
                Optional.of(
                        Problem.builder()
                                .withTitle("NOT FOUND")
                                .withDetail(response.getMessage())
                                .withStatus(Status.NOT_FOUND)
                                .build()
                ));
    }

}
