/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Myron Judkins
 */
public class RiverCrossingException extends Exception {

    public RiverCrossingException() {
    }

    public RiverCrossingException(String message) {
        super(message);
    }

    public RiverCrossingException(String message, Throwable cause) {
        super(message, cause);
    }

    public RiverCrossingException(Throwable cause) {
        super(cause);
    }

    public RiverCrossingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
    
    
}
