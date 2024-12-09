import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class interpreter {
//    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

//    public static boolean isNumber(String str) {
//        if (str == null) {
//            return false;
//        }
//        return pattern.matcher(str).matches();
//    }
//    private static double evaluatePostfix(List<String> postfix) {
//        Stack<Double> s = new Stack<>();
//        for (String token : postfix) {
//            if (isNumber(token)) {
//                s.push(Double.parseDouble(token));
//            } else if (token.equals("+")) {
//                double rightOperand = s.pop();
//                double leftOperand = s.pop();
//                s.push(rightOperand + leftOperand);
//            } else if (token.equals("-")) {
//                double rightOperand = s.pop();
//                double leftOperand = s.pop();
//                s.push(leftOperand - rightOperand);
//            } else if (token.equals("*")) {
//                double rightOperand = s.pop();
//                double leftOperand = s.pop();
//                s.push(rightOperand * leftOperand);
//            } else if (token.equals("/")) {
//                double rightOperand = s.pop();
//                double leftOperand = s.pop();
//                s.push(rightOperand + leftOperand);
//            } else if (token.equals("%")) {
//                double rightOperand = s.pop();
//                double leftOperand = s.pop();
//                s.push(leftOperand % rightOperand);
//            }
//        }
//        return s.pop();
//    }


    public static void main(String[] args) {
        String[] javaKeywords = {"abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue", "default", "do",
            "double", "else", "enum", "extends", "final", "finally", "float", "for",
            "goto", "if", "implements", "import", "instanceof", "int", "interface",
            "long", "native", "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

        String[] javaPlusPlusKeywords = {"abstract", "assert", "break", "case", "catch",
            "continue", "default", "do", "elif", "else", "enum", "extends", "final",
            "finally", "for", "func", "if", "implements", "import", "in", "instanceof",
            "native", "new", "package", "return", "static", "strictfp", "super", "switch",
            "synchronized", "throw", "throws", "transient", "try", "var", "void",
            "volatile", "while"};

        JavaPlusPlusTokenizer tokenizer = new JavaPlusPlusTokenizer();
        StringBuilder input = new StringBuilder();
        input = tokenizer.readFile("ExampleCode\\MangoCode.txt");
        List<Token> tokens = tokenizer.tokenize(input.toString());

        // System.out.println("int numOne");
        System.out.println(tokenizer.tokenize("\"Hello Test\""));
        System.out.println(tokenizer.tokenize("int numOne"));
        System.out.println(tokenizer.tokenize("int  numOne"));

    }
}
