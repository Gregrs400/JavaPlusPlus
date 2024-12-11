import java.io.*;
import java.util.*;

public class JavaPlusPlusTokenizer {

    //TODO: Questions for how to differentiate certain tokens
    // - is
    // - <, <=
    // - >, >=
    // and other possible additions to reserved Words (static, void, class)

    //Define reserved words and data types
    private final Set<String> reservedWords = new HashSet<>(Arrays.asList(
            "if", "elif", "else", "for", "while", "return", "func", "def", "is", "in",
            "static", "void", "class", "begin", "end", "println"
    ));
    private final Set<String> dataTypes = new HashSet<>(Arrays.asList(
            "int", "char", "String", "bool", "float", "double"
    ));
    private final Set<String> operators = new HashSet<>(Arrays.asList(
            "+", "-", "*", "/", "=", "%", "<", "<=", ">", ">=" , "is"
    ));
    private final Set<String> punctuation = new HashSet<>(Arrays.asList(
            "(", ")", "[", "]", "{", "}", ";", ","
    ));
    private final Set<String> escapeSequences = new HashSet<>(Arrays.asList(
            "\n", "\r", "\t"
    ));
    private final Set<String> accessSpecifiers = new HashSet<>(Arrays.asList("+", "-", "#"));

    public List<Token> tokens = new ArrayList<>();

    // Categorize tokens based on value
    public TokenType categorizeToken(String token) {
        if (dataTypes.contains(token)) {
            return TokenType.DataType;
        }
        if (accessSpecifiers.contains(token)) {
            return TokenType.AccessSpecifier;
        }
        if (token.equals("+"))
        {

            if (tokens.isEmpty())
            {

                return TokenType.AccessSpecifier;

            }
            else if (tokens.get(tokens.size()-1).value.equals("\n") || tokens.get(tokens.size()-1).type == TokenType.Whitespace)
            {

                return TokenType.AccessSpecifier;

            }
            else
            {

                return TokenType.Operator;

            }

        }
        if (reservedWords.contains(token)) {
            return TokenType.ReservedWord;
        }
        if (operators.contains(token)) {
            return TokenType.Operator;
        }
        if (punctuation.contains(token)){
            return TokenType.Punctuation;
        }
        if (Character.isDigit(token.charAt(0))) {
            return TokenType.NumericLiteral;
        }
        if (Character.isAlphabetic(token.charAt(0))) {
            return TokenType.Variable;
        }
        if (token.charAt(0) == '\"'){
            return TokenType.StringLiteral;
        }
        if (token.charAt(0) == ' ')
        {
            return TokenType.Whitespace;
        }
        if (escapeSequences.contains(token))
        {
            return TokenType.EscapeSequence;
        }
        return TokenType.Unknown;
    }

    // Tokenize the input string into tokens
    public List<Token> tokenize(String input) {
        StringBuilder currentToken = new StringBuilder();
        boolean stringFlag = false;

        for (char ch : input.toCharArray()) {
            //exception must be made when " appears in code. It will create a string literal

            if (((Character.isWhitespace(ch) || punctuation.contains(String.valueOf(ch))) && !stringFlag))
            {

                // Many times punctuation will be found touching char, this will
                // record punctuation while the token is being scanned

                // new line checker
                if (ch == '\n')
                {
                    if (!currentToken.isEmpty() && !Character.isWhitespace(currentToken.charAt(currentToken.length() - 1)))
                    {
                        tokens.add(new Token(currentToken.toString(), categorizeToken(currentToken.toString())));
                        currentToken.setLength(0);

                    }

                    currentToken.append(ch);
                    tokens.add(new Token(currentToken.toString(), categorizeToken(currentToken.toString())));
                    currentToken.setLength(0);

                }
                if (!currentToken.isEmpty() && !Character.isWhitespace(currentToken.charAt(currentToken.length() - 1)))
                {
                    tokens.add(new Token(currentToken.toString(), categorizeToken(currentToken.toString())));
                    currentToken.setLength(0);
                    currentToken.append(' ');
                }

                else if (!currentToken.isEmpty() && Character.isWhitespace(currentToken.charAt(currentToken.length() - 1)))
                {
                    currentToken.append(' ');
                }

                else if (!currentToken.isEmpty()) {
                    tokens.add(new Token(currentToken.toString(), categorizeToken(currentToken.toString())));
                    currentToken.setLength(0);
                }
                continue;
            }

            if (currentToken.length() > 1 && !Character.isWhitespace(ch) && Character.isWhitespace(currentToken.charAt(currentToken.length()-1))  && !stringFlag)
            {

                tokens.add(new Token(currentToken.toString(), categorizeToken(currentToken.toString())));
                currentToken.setLength(0);

            }

            // crude way of doing this but ill explain
            if(ch == '\"' && !stringFlag) {  // a flag is used to see if we are in a "string"
                currentToken.append(ch);
                stringFlag = true;           // once we enter a "string" we set the flag to true

            }else if(ch == '\"') {           // finding another quotation means we exit the "string"
                currentToken.append(ch);
                stringFlag = false;

            }else if(stringFlag) {          // we keep appending all chars while the flag is true
                currentToken.append(ch);

            } else if ((Character.isLetterOrDigit(ch) || operators.contains(String.valueOf(ch)))) {
                if (!currentToken.isEmpty() && Character.isWhitespace(currentToken.charAt(currentToken.length()-1)))
                {
                    tokens.add(new Token(currentToken.toString(), categorizeToken(currentToken.toString())));
                    currentToken.setLength(0);
                }
                    currentToken.append(ch);

            } else {
                if (!currentToken.isEmpty()) {
                    tokens.add(new Token(currentToken.toString(), categorizeToken(currentToken.toString())));
                    currentToken.setLength(0);
                }
            }
        }
        if (!currentToken.isEmpty()) {
            tokens.add(new Token(currentToken.toString(), categorizeToken(currentToken.toString())));
        }
        return tokens;
    }

    // Function to print categorized tokens
    public void printReport(List<Token> tokens) {
        Map<TokenType, List<String>> categorizedTokens = new HashMap<>();

        for (Token token : tokens) {
            categorizedTokens.computeIfAbsent(token.type, k -> new ArrayList<>()).add(token.value);
        }

        System.out.println("NumericLiterals: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.NumericLiteral, Collections.emptyList())));
        System.out.println("Access Specifiers: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.AccessSpecifier, Collections.emptyList())));
        System.out.println("StringLiterals: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.StringLiteral, Collections.emptyList())));
        System.out.println("Operators: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.Operator, Collections.emptyList())));
        System.out.println("Variables: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.Variable, Collections.emptyList())));
        System.out.println("Punctuation: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.Punctuation, Collections.emptyList())));
        System.out.println("Reserved Words: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.ReservedWord, Collections.emptyList())));
        System.out.println("Data Types: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.DataType, Collections.emptyList())));
        System.out.println("Unknown: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.Unknown, Collections.emptyList())));
    }


    public StringBuilder readFile(String filePath) {
        File inputFile = new File(filePath);
        StringBuilder input = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.startsWith("//") || trimmedLine.isEmpty()) {
                    continue;
                }
                input.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return input;
        }
        return input;
    }
}
