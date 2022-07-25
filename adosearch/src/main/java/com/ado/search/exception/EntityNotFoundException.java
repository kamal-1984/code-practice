/*
 * 
 */
package com.ado.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class EntityNotFoundException.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not find entity with id.")
public class EntityNotFoundException extends Exception
{
    
    /** The Constant serialVersionUID. */
    static final long serialVersionUID = -3387516993334229948L;


    /**
     * Instantiates a new entity not found exception.
     *
     * @param message the message
     */
    public EntityNotFoundException(String message)
    {
        super(message);
    }

}
