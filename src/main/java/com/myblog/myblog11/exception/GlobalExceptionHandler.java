package com.myblog.myblog11.exception;

import com.myblog.myblog11.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.crypto.Data;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private com.myblog.myblog11.payload.ErrorDetails ErrorDetails;

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourseNotFoundException(
            ResourseNotFoundException e,
            WebRequest webRequest

    ) {
        ErrorDetails errorDetails=new ErrorDetails(e.getMessage(),new Date(),webRequest.getDescription(true));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }





}
