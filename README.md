# Building a simple Compiler from scratch in java

## First step: Lexical Analysis

### What is Lexical Analysis?

Lexical analysis is the first phase of a compiler.
It takes the modified source code from language preprocessors that are written in the form of sentences.
The lexical analyzer breaks these syntax's into a series of tokens, by removing any whitespace or comments in the source code.

- Tokenization: 
    Start by creating a lexer that will take the source code and break it into tokens.
- Regular Expressions: 
    We will use regular expressions to match the tokens.
- Symbol Table: 
    We will use a symbol table to store the tokens.

## Second step: Syntax Analysis

### What is Syntax Analysis?

Syntax analysis is the second phase of a compiler.
It takes the token produced by lexical analysis as input and generates a parse tree (or syntax tree).
Syntax analysis checks the tokens for any syntax errors.
It also adds the additional information to the parse tree.

- Grammar: 
    We will use a grammar to define the syntax of our language.
- Parser: 
    We will use a parser to parse the tokens.
- Abstract Syntax Tree: 
    We will use an abstract syntax tree to store the tokens.
- Error Handling: 
    We will use error handling to handle any syntax errors.