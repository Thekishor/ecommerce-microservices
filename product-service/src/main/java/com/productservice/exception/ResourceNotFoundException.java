package com.productservice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

    private String resourcename;
    private String fieldname;
    private Object fieldvalue;

    public ResourceNotFoundException(String resourcename, String fieldname, Object fieldvalue) {
        super(String.format("%s not found with %s : %s",resourcename,fieldname,fieldvalue));
        this.resourcename = resourcename;
        this.fieldname = fieldname;
        this.fieldvalue = fieldvalue;
    }
}
