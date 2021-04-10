package com.arobs.library.exception;

import org.hibernate.DuplicateMappingException;
import org.hibernate.exception.ConstraintViolationException;
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

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "ResourceNotFoundException thrown: " + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = EmployeeException.class)
    public ResponseEntity<Object> handleEmployee(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "EmployeeException thrown: " + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = InvalidInputException.class)
    public ResponseEntity<Object> handleInvalidInput(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "InvalidInputException thrown: " + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

//    @ExceptionHandler(value = {EmptyResultDataAccessException.class})
//    public ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = EmptyResultDataAccessException.class + ex.getMessage();
//        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//    }

    @ExceptionHandler(value = {IllegalStateException.class, IllegalArgumentException.class, ConstraintViolationException.class})
    public ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "ConstraintViolationException thrown: " + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {DuplicateMappingException.class})
    public ResponseEntity<Object> handeDuplicate(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = DuplicateMappingException.class + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = {IllegalAccessException.class})
    public ResponseEntity<Object> handeIllegalAccess(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = IllegalAccessException.class + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }
}