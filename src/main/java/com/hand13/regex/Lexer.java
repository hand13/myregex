package com.hand13.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class Lexer {
    private Reader regexReader;

    public Lexer(String regex) {
        regexReader = new BufferedReader(new StringReader(regex));
    }

    private char nextChar() throws IOException {
        int m = regexReader.read();
        if (m <= 0) {
            return 0;
        } else {
            return (char) m;
        }
    }

    private String nextString() throws IOException {
        this.regexReader.mark(1);
        char c = this.nextChar();
        StringBuilder str = new StringBuilder();
        while (Character.isDigit(c) || Character.isLetter(c) || c == ' ') {
            str.append(c);
            this.regexReader.mark(1);
            c = this.nextChar();
        }
        this.regexReader.reset();
        return str.toString();
    }

    public Token getNextToken() throws IOException {
        char c = this.nextChar();
        if (c == 0) {
            return null;
        }
        Token token = new Token();
        switch (c) {
            case '[': {
                break;
            }
            case '(': {

            }
            case '.': {
                token.tokenType = TokenType.ANY;
            }
            default: {
                token.tokenType = TokenType.STRING;
                token.value = this.nextString();
            }
        }
        regexReader.mark(6);
        c = this.nextChar();
        if (c == '+' || c == '*' || c == '?') {
            Token inner = token;
            token = new Token();
            token.tos = inner;
            switch (c) {
                case '+':
                    token.tokenType = TokenType.ONE28;
                    break;
                case '*':
                    token.tokenType = TokenType.ZERO28;
                    break;
                case '?':
                    token.tokenType = TokenType.ONEOZ;
                    break;
            }
        } else {
            regexReader.reset();
        }
        return token;
    }
}
