package com.devpaulojr.springmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super("NotFound: Objeto não encontrado!!" );
    }
}
