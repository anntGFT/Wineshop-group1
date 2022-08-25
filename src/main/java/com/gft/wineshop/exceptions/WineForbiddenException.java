package com.gft.wineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Forbidden request")
public class WineForbiddenException extends RuntimeException {
    
}
