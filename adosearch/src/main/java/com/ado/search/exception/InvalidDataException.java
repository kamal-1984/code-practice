/*
 * 
 */
package com.ado.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidDataException.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some constraints are invalid or empty ...")
public class InvalidDataException extends Exception {
	

    /** The Constant serialVersionUID. */
    static final long serialVersionUID = -3387516993224229948L;


    /**
     * Instantiates a new constraints violation exception.
     *
     * @param message the message
     */
    public InvalidDataException(String message)
    {
        super(message);
    }


}
