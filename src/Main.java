

public class Main {
    public static void main(String[] args) {
        String sourceCode = "370 + 11 + /* ziad */ ( 2 + 2 )";
        Lexer lexer = new Lexer(sourceCode);
        Parser parser = new Parser(lexer);
        parser.expression();

        lexer.tokenizeExpression().forEach(token -> {
            System.out.println(token.getType() + " " + token.getValue());
        });
        System.out.println("Parsing completed successfully");
    }
}