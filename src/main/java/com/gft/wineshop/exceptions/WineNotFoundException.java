package com.gft.wineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Wine not found")
public class WineNotFoundException extends RuntimeException {
    
}
