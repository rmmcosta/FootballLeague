package com.rmmcosta.footballleague.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Team not found")
public class TeamNotFoundException extends RuntimeException {
}
