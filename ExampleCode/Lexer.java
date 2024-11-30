import java.util.HashMap;

class TokenizerTokenType {
    protected char currentChar;
    protected String tokenType;

    public TokenizerTokenType(char currentChar, String tokenType){
        this.currentChar = currentChar;
        this.tokenType = tokenType;
    }
}
public class Lexer {
    private final HashMap<String, String> reservedWords = new HashMap<String, String>();
    private final HashMap<Character, TokenizerTokenType> operators = new HashMap<Character, TokenizerTokenType>();
    private final HashMap<String, String> dataTypes = new HashMap<String, String>();
    /* These variables are currently not used.
    //private int position;
    private char currentChar;
     */

    private String input;

    public Lexer(String input){
        this.input = input;
        //this.position = 0; // Currently not used.
        // Reserved Words
        reservedWords.put("if", "reserved word");
        reservedWords.put("elif", "reserved word");
        reservedWords.put("else", "reserved word");
        reservedWords.put("for", "reserved word");
        reservedWords.put("while", "reserved word");
        reservedWords.put("public", "reserved word");
        reservedWords.put("private", "reserved word");
        // Operators
        operators.put('+', new TokenizerTokenType('+', "operator"));
        operators.put('-', new TokenizerTokenType('-', "operator"));
        operators.put('*', new TokenizerTokenType('*', "operator"));
        operators.put('/', new TokenizerTokenType('/', "operator"));
        operators.put('%', new TokenizerTokenType('%', "operator"));
        operators.put('=', new TokenizerTokenType('=', "operator"));
        // Data Types
        dataTypes.put("int", "data type");
        dataTypes.put("str", "data type");
        dataTypes.put("char", "data type");
        dataTypes.put("bool", "data type");
    }

    public void readInput() {
        String[] words = input.split(" ");
        for (String w : words) {
            // Check if the word is a reserved word
            if (reservedWords.containsKey(w)) {
                System.out.println(w + " - " + reservedWords.get(w));
            }
            // Check if the word is a data type
            else if (dataTypes.containsKey(w)) {
                System.out.println(w + " - " + dataTypes.get(w));
            }
            // Check if the word is a single-character operator
            else if (w.length() == 1 && operators.containsKey(w.charAt(0))) {
                System.out.println(w + " - " + operators.get(w.charAt(0)).tokenType);
            }
            // Check if the word is an integer literal (sequence of digits)
            else if (w.matches("\\d+")) {
                System.out.println(w + " - integer literal");
            }
            // Check if the word is a string literal (enclosed in quotes)
            else if (w.matches("\"[^\"]*\"")) {
                System.out.println(w + " - string literal");
            }
            // Check if the word looks like a valid variable name (starts with a letter or underscore)
            else if (w.matches("[a-zA-Z_][a-zA-Z_0-9]*")) {
                System.out.println(w + " - variable");
            }
            // If the word doesn't match any known token
            else {
                System.out.println(w + " - unknown token");
            }
        }
    }

}
