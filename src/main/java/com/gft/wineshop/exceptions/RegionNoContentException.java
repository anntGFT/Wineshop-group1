package com.gft.wineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "No content")
public class RegionNoContentException extends RuntimeException {
    
}
