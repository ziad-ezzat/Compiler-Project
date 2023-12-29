package enumsANDmoudels;

import enumsANDmoudels.TokenType;

public class Token {

    TokenType type;
    String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }
}
