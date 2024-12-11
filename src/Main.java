import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        JavaPlusPlusTokenizer tokenizer = new JavaPlusPlusTokenizer();
        StringBuilder input = new StringBuilder();
        input = tokenizer.readFile("ExampleCode\\Java++CodeExample1.txt");
        List<Token> tokens = tokenizer.tokenize(input.toString());
        tokenizer.printReport(tokens);
        for (Token token : tokens) {
            System.out.println(token.toString());
        }
//        String str1 = "if";
//        String str2 = "if elif else";
//        String str3 = "for int i = 0";
//        String str4 = "while x = myNum";
//        String str5 = "public str myString";
//        String str6 = "private char grade";
//        String str7 = "+ - * / % =";
//        String str8 = "private bool flag";
//        String str9 = "\"Hello\"";
//        String str10 = " 9_4a";
//        String str11 = "numOne++";
//        String str12 = "+ class Person { }";
    }
}
