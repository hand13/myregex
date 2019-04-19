package com.hand13.regex;
/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class RegexException extends Exception {
    private String msg;
    public RegexException(String message) {
        this.msg = message;
    }
    @Override
    public String getMessage() {
        return super.getMessage() + msg;
    }
}
