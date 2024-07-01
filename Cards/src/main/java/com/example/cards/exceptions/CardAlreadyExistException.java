package com.example.cards.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CardAlreadyExistException extends RuntimeException{

    public CardAlreadyExistException(String msg) {
        super(msg);
    }
}
