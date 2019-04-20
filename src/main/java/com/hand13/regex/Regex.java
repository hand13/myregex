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
    public boolean match(String target)throws Exception {
        Reader stringReader = new BufferedReader(new StringReader(target));
        Token token = lexer.getNextToken();
        while (token != null) {
            switch (token.tokenType) {
                case ANY:
                    break;
                case STRING:
                    String value = token.value;
                    for(char c : value.toCharArray()) {
                        int i = stringReader.read();
                        if(i < 0) {
                            return false;
                        }
                        char s = (char)i;
                        if(s != c){
                            return false;
                        }
                    }
                    break;
                case ONEOZ:

            }
            token = lexer.getNextToken();
        }
        return false;
    }
}
