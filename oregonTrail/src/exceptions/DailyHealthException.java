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
public class DailyHealthException extends Exception {

    public DailyHealthException() {
    }

    public DailyHealthException(String message) {
        super(message);
    }

    public DailyHealthException(String message, Throwable cause) {
        super(message, cause);
    }

    public DailyHealthException(Throwable cause) {
        super(cause);
    }

    public DailyHealthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
