/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Kevin's Account
 */
public class TrailStopException extends Exception {

    public TrailStopException() {
    }

    public TrailStopException(String string) {
        super(string);
    }

    public TrailStopException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public TrailStopException(Throwable thrwbl) {
        super(thrwbl);
    }

    public TrailStopException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}
