package org.kodluyoruz.group1.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AuthorNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AuthorNotFoundException(String message) {
        super(message);
    }
}