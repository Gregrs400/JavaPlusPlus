import java.util.List;

public class Main {
    public static void main(String[] args){
        JavaPlusPlusTokenizer tokenizer = new JavaPlusPlusTokenizer();
        String input;
        input = tokenizer.readFile("src\\ExampleCode\\Java++CodeExample1.txt");
        System.out.println(input.toString());
        List<Token> tokens = tokenizer.tokenize(input.toString());
        for (Token token : tokens) {
            System.out.print(token.toString());
        }
    }
}
