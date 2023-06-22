package com.example.backend.service;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Log4j2
@ControllerAdvice
public class ServiceErrorAdvice {
    private void CommonHandler(Map<String, Object> body, int code, String message, String cause, String trace) {
        body.put("success", false);
        body.put("message", message);
        body.put("timestamp", LocalDateTime.now());
        body.put("status", code);
        body.put("cause", cause);
        body.put("stacktrace", trace);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        CommonHandler(body, HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
                ExceptionUtils.getRootCauseMessage(ex),
                ExceptionUtils.getStackTrace(ex));
        log.error(ex);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
