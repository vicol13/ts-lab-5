package com.ts.labs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchStudentException extends Exception {
    public NoSuchStudentException(String message) {
        super(message);
    }
}
