package com.rest.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
public class NotFoundException extends WebApplicationException {
/**
* 
*/
private static final long serialVersionUID = 1L; 
/**
* Create a HTTP 404 (Not Found) exception.
* @param message the String that is the entity of the 404 response.
*/
public NotFoundException(ErrorMessage message) {
      super(Response.status(Response.Status.NOT_FOUND).
      entity(message).type("application/json").build());
    }
}
