public class Token {
    String value;
    TokenType type;

    Token(String value, TokenType type) {
        this.value = value;
        this.type = type;
    }

    public String toString()
    {
        return "[" + this.value + ", " + this.type + "]";
    }
}
