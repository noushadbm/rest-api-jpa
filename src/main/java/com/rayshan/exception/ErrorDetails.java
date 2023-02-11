package com.rayshan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorDetails {
    private Date date;
    private String message;
    private String details;
}
