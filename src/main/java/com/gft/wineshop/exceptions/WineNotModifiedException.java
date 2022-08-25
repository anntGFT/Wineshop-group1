package com.gft.wineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_MODIFIED, reason = "Wine not modified")
public class WineNotModifiedException extends RuntimeException {
    
}
