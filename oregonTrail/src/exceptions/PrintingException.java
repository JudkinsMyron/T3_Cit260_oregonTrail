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
public class PrintingException extends Exception {

    public PrintingException() {
    }

    public PrintingException(String string) {
        super(string);
    }

    public PrintingException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PrintingException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PrintingException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
