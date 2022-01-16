/*
 * 
 */
package com.freenow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class CarAlreadyInUseException.
 */
@ResponseStatus(value = HttpStatus.LOCKED, reason = "Selected car already in use.")
public class CarAlreadyInUseException extends Exception {
	
    /** The Constant serialVersionUID. */
    static final long serialVersionUID = -3387516993334229948L;

    /**
     * Instantiates a new car already in use exception.
     *
     * @param message the message
     */
    public CarAlreadyInUseException(String message)
    {
        super(message);
    }

}
