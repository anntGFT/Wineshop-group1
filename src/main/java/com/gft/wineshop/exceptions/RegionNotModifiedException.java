package com.gft.wineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_MODIFIED, reason = "Region not modified")
public class RegionNotModifiedException extends RuntimeException {
    
}
