package com.arobs.library.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.DataTruncation;

@ControllerAdvice
public class DataTruncationExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(DataTruncationExceptionHandler.class);

    @ExceptionHandler(value = {DataTruncation.class})
    public ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request){
        log.info("@ExceptionHandler: \"DataTruncationExceptionHandler\" executed");
        String bodyOfResponse = "Invalid input: too many characters for column" + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }
}
