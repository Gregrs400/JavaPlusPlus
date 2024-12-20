import java.io.*;
import java.util.*;



// Token types
enum TokenType {
    NumericLiteral,
    StringLiteral,
    Operator,
    Variable,
    ReservedWord,
    DataType,
    Punctuation,
    Unknown
}


////something to hold string literals because strings can be a lot of things
//class sL{
//    char val;
//
//    sL(char val){
//        this.val = val;
//    }
//}

// Token class
class Token {
    String value;
    TokenType type;

    Token(String value, TokenType type) {
        this.value = value;
        this.type = type;
    }
}

public class JavaPlusPlusTokenizer {

    //TODO: Questions for how to differentiate certain tokens
    // - is
    // - <, <=
    // - >, >=
    // and other possible additions to reserved Words (static, void, class)

    //Define reserved words and data types
    private static final Set<String> reservedWords = new HashSet<>(Arrays.asList(
            "if", "elif", "else", "for", "while", "return", "func", "def", "is", "in",
            "static", "void", "class", "begin", "end", "println"
    ));
    private static final Set<String> dataTypes = new HashSet<>(Arrays.asList(
            "int", "char", "String", "bool", "float", "double"
    ));
    private static final Set<String> operators = new HashSet<>(Arrays.asList(
            "+", "-", "*", "/", "=", "%", "<", "<=", ">", ">=" , "is"
    ));
    private static final Set<String> punctuation = new HashSet<>(Arrays.asList(
            "(", ")", "[", "]", "{", "}", ";", ","
    ));

    // Categorize tokens based on value
    private static TokenType categorizeToken(String token) {
        if (dataTypes.contains(token)) {
            return TokenType.DataType;
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
            return  TokenType.StringLiteral;
        }
        return TokenType.Unknown;
    }

    // Tokenize the input string into tokens
    private static List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        boolean stringflag = false;

        for (char ch : input.toCharArray()) {
            //exception must be made when " appears in code. It will create a string literal

            if (((Character.isWhitespace(ch) || punctuation.contains(String.valueOf(ch))) && !stringflag)) {

                // Many times punctuation will be found touching char, this will
                // record punctuation while the token is being scanned
                tokens.add(new Token(String.valueOf(ch), categorizeToken(String.valueOf(ch))));

                if (!currentToken.isEmpty()) {
                    tokens.add(new Token(currentToken.toString(), categorizeToken(currentToken.toString())));
                    currentToken.setLength(0);
                }
                continue;
            }

            // crude way of doing this but ill explain
            if(ch == '\"' && !stringflag) {  // a flag is used to see if we are in a "string"
                currentToken.append(ch);
                stringflag = true;           // once we enter a "string" we set the flag to true

            }else if(ch == '\"') {           // finding another quotation means we exit the "string"
                currentToken.append(ch);
                stringflag = false;

            }else if(stringflag) {          // we keep appending all chars while the flag is true
                currentToken.append(ch);

            } else if ((Character.isLetterOrDigit(ch) || operators.contains(String.valueOf(ch)))) {
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
    private static void printReport(List<Token> tokens, int lineCount) {
        Map<TokenType, List<String>> categorizedTokens = new HashMap<>();

        for (Token token : tokens) {
            categorizedTokens.computeIfAbsent(token.type, k -> new ArrayList<>()).add(token.value);
        }

        System.out.println("NumericLiterals: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.NumericLiteral, Collections.emptyList())));
        System.out.println("StringLiterals: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.StringLiteral, Collections.emptyList())));
        System.out.println("Operators: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.Operator, Collections.emptyList())));
        System.out.println("Variables: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.Variable, Collections.emptyList())));
        System.out.println("Punctuation: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.Punctuation, Collections.emptyList())));
        System.out.println("Reserved Words: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.ReservedWord, Collections.emptyList())));
        System.out.println("Data Types: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.DataType, Collections.emptyList())));
        System.out.println("Unknown: " + String.join(" ", categorizedTokens.getOrDefault(TokenType.Unknown, Collections.emptyList())));

        System.out.println("Line Count (excluding comments): " + lineCount);

    }

    public static void main(String[] args){

        File inputFile = new File("src\\ExampleCode\\MangoCode.txt");

        if (!inputFile.exists()) {
            System.err.println("Error: Could not open the file!");
            return;
        }

        StringBuilder input = new StringBuilder();
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.startsWith("//") || trimmedLine.isEmpty()) {
                    continue;
                }
                input.append(line).append(" ");
                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Tokenize input
        List<Token> tokens = tokenize(input.toString());

        // Print categorized tokens
        printReport(tokens, lineCount);
    }
}
