package net.xitiz.jrd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  
public class AlterationNotFoundException extends RuntimeException {
    public AlterationNotFoundException(String message) {
        super(message);
    }
}
