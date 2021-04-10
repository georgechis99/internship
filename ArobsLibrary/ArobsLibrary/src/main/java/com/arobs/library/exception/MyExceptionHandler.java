package com.arobs.library.exception;

import org.hibernate.DuplicateMappingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    ResponseEntity<Object> onConstraintValidationException(
//            ConstraintViolationException e) {
//        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
//            error.getViolations().add(
//                    new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
//        }
//        return error;
//    }


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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String bodyOfResponse = "MethodArgumentNotValid thrown: " + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

//    @ExceptionHandler(value = {IllegalStateException.class, IllegalArgumentException.class})
//    public ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "ConstraintViolationException thrown: " + ex.getMessage();
//        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> handleBadRequest(ConstraintViolationException ex, WebRequest request) {
        String bodyOfResponse = "ConstraintViolationException thrown: " + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {DuplicateMappingException.class})
    public ResponseEntity<Object> handleDuplicate(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = DuplicateMappingException.class + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = {IllegalAccessException.class})
    public ResponseEntity<Object> handleIllegalAccess(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = IllegalAccessException.class + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }
}