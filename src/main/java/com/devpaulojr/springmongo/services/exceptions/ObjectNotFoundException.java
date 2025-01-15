package com.devpaulojr.springmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(Object object) {
        super("NotFound: " + object);
    }
}
