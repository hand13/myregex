package com.hand13.regex;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class Regex {
    private String regex;
    private Lexer lexer;
    public Regex(String regex) {
        this.regex = regex;
        lexer = new Lexer(regex);
    }
    public boolean match(String target) {
        Reader stringReader = new BufferedReader(new StringReader(target));
        return false;
    }
}
