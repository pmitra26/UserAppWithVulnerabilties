package com.example.userregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
class LinkException extends RuntimeException {
  public LinkException(String exception) {
    super(exception);
  }
}

