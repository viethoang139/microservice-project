package com.leviethoang.orderservice.exception;

import com.leviethoang.orderservice.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String fieldResource;
    private String fieldError;
    private Long fieldValue;


    public ResourceNotFoundException(String fieldResource , String fieldError , Long fieldValue){
        super(String.format("%s not found with %s: '%s'",fieldResource,fieldError,fieldValue));
        this.fieldResource = fieldResource;
        this.fieldError = fieldError;
        this.fieldValue = fieldValue;
    }

}
