import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args){
        JavaPlusPlusTokenizer tokenizer = new JavaPlusPlusTokenizer();
        String input;
        input = tokenizer.readFile("src\\ExampleCode\\Java++CodeExample1.txt");
        System.out.println(input.toString());
        List<Token> tokens = tokenizer.tokenize(input.toString());
//        for (Token token : tokens) {
//            System.out.println(token.toString());
//        }
        StringBuilder tokenString = new StringBuilder();
        for (Token token : tokens) {
            tokenString.append(token.value);
        }
        JPPFileCreation jpp = new JPPFileCreation();

        File outputFile = jpp.createOrAccessFile("src\\ExampleCode\\outputFileTest.jpp");

        jpp.writeToFile(outputFile, tokenString.toString());

    }
}
