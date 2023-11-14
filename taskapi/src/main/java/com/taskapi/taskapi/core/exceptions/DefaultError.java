package com.taskapi.taskapi.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DefaultError {
    private int error; 
    private String message; 
}
