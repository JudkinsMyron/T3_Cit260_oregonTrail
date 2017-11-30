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
public class GamePlayException extends Exception {

    public GamePlayException() {
    }

    public GamePlayException(String message) {
        super(message);
    }

    public GamePlayException(String message, Throwable cause) {
        super(message, cause);
    }

    public GamePlayException(Throwable cause) {
        super(cause);
    }

    public GamePlayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
