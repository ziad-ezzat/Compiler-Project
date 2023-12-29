import enumsANDmoudels.Token;
import enumsANDmoudels.TokenType;

import java.util.ArrayList;

public class Lexer {

    String sourceCode;
    ArrayList<Token> tokens;

    public Lexer(String sourceCode) {
        this.sourceCode = sourceCode;
        this.tokens = new ArrayList<>();
    }

    public ArrayList<Token> tokenizeExpression() {
        int i = 0;
        int openParenthesesCount = 0;
        char prevChar = ' ';

        while (i < sourceCode.length()) {
            char c = sourceCode.charAt(i);

            if (c == '+' && prevChar == '+' || c == '-' && prevChar == '-' || c == '*' && prevChar == '*' || c == '/' && prevChar == '/' || c == '+' && prevChar == '-' || c == '-' && prevChar == '+' || c == '+' && prevChar == '*' || c == '*' && prevChar == '+' || c == '+' && prevChar == '/' || c == '/' && prevChar == '+' || c == '-' && prevChar == '*' || c == '*' && prevChar == '-' || c == '-' && prevChar == '/' || c == '/' && prevChar == '-' ) {
                throw new RuntimeException("Invalid syntax: " + prevChar + c);
            }

            if (c == '*' && prevChar == '/')
            {
                // skip everything until we find a closing '*/' if we don't find it throw an error
                i += 2;
                if (i < sourceCode.length()) {
                    c = sourceCode.charAt(i);
                } else {
                    throw new RuntimeException("Invalid syntax: " + prevChar + c);
                }
                while (c != '/' && prevChar != '*') {
                    i++;
                    if (i < sourceCode.length()) {
                        c = sourceCode.charAt(i);
                    } else {
                        throw new RuntimeException("Invalid syntax: " + prevChar + c);
                    }
                }
                i++;
                if (i < sourceCode.length()) {
                    c = sourceCode.charAt(i);
                } else {
                    throw new RuntimeException("Invalid syntax: " + prevChar + c);
                }
                prevChar = c;
                continue;
            }

            switch (c) {
                case '+':
                    tokens.add(new Token(TokenType.PLUS, "+"));
                    i++;
                    break;
                case '-':
                    tokens.add(new Token(TokenType.MINUS, "-"));
                    i++;
                    break;
                case '*':
                    tokens.add(new Token(TokenType.MULTIPLY, "*"));
                    i++;
                    break;
                case '/':
                    tokens.add(new Token(TokenType.DIVIDE, "/"));
                    i++;
                    break;
                case '(':
                    tokens.add(new Token(TokenType.LPAREN, "("));
                    openParenthesesCount++;
                    i++;
                    break;
                case ')':
                    tokens.add(new Token(TokenType.RPAREN, ")"));
                    openParenthesesCount--;
                    if (openParenthesesCount < 0) {
                        throw new RuntimeException("Close parenthesis ')' found without a matching open parenthesis '('");
                    }
                    i++;
                    break;
                case ' ':
                    i++;
                    break;
                case '=':
                    tokens.add(new Token(TokenType.EQUAL, "="));
                    i++;
                    break;
                default:
                    if (Character.isDigit(c)) {
                        StringBuilder digits = new StringBuilder();
                        while (Character.isDigit(c)) {
                            digits.append(c);
                            i++;
                            if (i < sourceCode.length()) {
                                c = sourceCode.charAt(i);
                            } else {
                                break;
                            }
                        }
                        tokens.add(new Token(TokenType.INTEGER, digits.toString()));
                    } else {
                        throw new RuntimeException("Invalid character: " + c);
                    }
            }
            prevChar = c;
        }

        if (openParenthesesCount > 0) {
            throw new RuntimeException("Open parenthesis '(' found without a matching close parenthesis ')'");
        }

        return tokens;
    }

    public ArrayList<Token> tokenizeStatement() {

        int i = 0;
        int openParenthesesCount = 0;
        char prevChar = ' ';

        while (i < sourceCode.length()) {
            char c = sourceCode.charAt(i);

            if (c == '+' && prevChar == '+' || c == '-' && prevChar == '-' || c == '*' && prevChar == '*' || c == '/' && prevChar == '/' || c == '*' && prevChar == '/' || c == '/' && prevChar == '*' || c == '+' && prevChar == '-' || c == '-' && prevChar == '+' || c == '+' && prevChar == '*' || c == '*' && prevChar == '+' || c == '+' && prevChar == '/' || c == '/' && prevChar == '+' || c == '-' && prevChar == '*' || c == '*' && prevChar == '-' || c == '-' && prevChar == '/' || c == '/' && prevChar == '-' ) {
                throw new RuntimeException("Invalid syntax: " + prevChar + c);
            }

            switch (c) {
                case '+':
                    tokens.add(new Token(TokenType.PLUS, "+"));
                    i++;
                    break;
                case '-':
                    tokens.add(new Token(TokenType.MINUS, "-"));
                    i++;
                    break;
                case '*':
                    tokens.add(new Token(TokenType.MULTIPLY, "*"));
                    i++;
                    break;
                case '/':
                    tokens.add(new Token(TokenType.DIVIDE, "/"));
                    i++;
                    break;
                case '(':
                    tokens.add(new Token(TokenType.LPAREN, "("));
                    openParenthesesCount++;
                    i++;
                    break;
                case ')':
                    tokens.add(new Token(TokenType.RPAREN, ")"));
                    openParenthesesCount--;
                    if (openParenthesesCount < 0) {
                        throw new RuntimeException("Close parenthesis ')' found without a matching open parenthesis '('");
                    }
                    i++;
                    break;
                case ' ':
                    i++;
                    break;
                case '=':
                    tokens.add(new Token(TokenType.EQUAL, "="));
                    i++;
                    break;
                default:
                    if (Character.isLetter(c)) {
                        StringBuilder identifier = new StringBuilder();
                        while (Character.isLetter(c)) {
                            identifier.append(c);
                            i++;
                            if (i < sourceCode.length()) {
                                c = sourceCode.charAt(i);
                            } else {
                                break;
                            }
                        }
                        tokens.add(new Token(TokenType.IDENTIFIER, identifier.toString()));
                    } else if (Character.isDigit(c)) {
                        StringBuilder digits = new StringBuilder();
                        while (Character.isDigit(c)) {
                            digits.append(c);
                            i++;
                            if (i < sourceCode.length()) {
                                c = sourceCode.charAt(i);
                            } else {
                                break;
                            }
                        }
                        tokens.add(new Token(TokenType.INTEGER, digits.toString()));
                    } else {
                        throw new RuntimeException("Invalid character: " + c);
                    }
            }

            prevChar = c;
        }

        if (openParenthesesCount > 0) {
            throw new RuntimeException("Open parenthesis '(' found without a matching close parenthesis ')'");
        }

        return tokens;
    }
}