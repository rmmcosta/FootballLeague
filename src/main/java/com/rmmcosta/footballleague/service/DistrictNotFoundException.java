package com.rmmcosta.footballleague.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "District not found")
public class DistrictNotFoundException extends RuntimeException {
}
