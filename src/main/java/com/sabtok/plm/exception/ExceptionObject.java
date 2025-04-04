package com.sabtok.plm.exception;

import lombok.Data;

import java.util.Set;

@Data
public class ExceptionObject {

    private int code;

    private Set<String> errors;

    public ExceptionObject(int code,Set<String> errors){
        this.code = code;
        this.errors = errors;
    }
}
