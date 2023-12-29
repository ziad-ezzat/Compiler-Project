import enumsANDmoudels.Token;
import enumsANDmoudels.TokenType;

public class Parser {
    Lexer lexer;
    Token currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.tokenizeExpression().get(0);
    }

    private void match(TokenType tokenType) {
        if (currentToken.getType() == tokenType) {
            currentToken = lexer.tokenizeExpression().get(0);
        } else {
            throw new RuntimeException("Token type mismatch");
        }
    }

    public void expression() {
        match(TokenType.INTEGER);
    }

    public void statement() {
        match(TokenType.IDENTIFIER);
        match(TokenType.EQUAL);
        expression();
    }
}