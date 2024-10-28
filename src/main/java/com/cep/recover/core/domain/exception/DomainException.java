package com.cep.recover.core.domain.exception;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private DomainErrorCode errorCode;
    private int statusCode;

    public DomainException(DomainErrorCode errorCode, int statusCode, String msg){
        super(msg);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }
}
