import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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

        HashMap<String, String> javaPlusPlusToJava = new HashMap<>();
        javaPlusPlusToJava.put("abstract", "abstract");
        javaPlusPlusToJava.put("Array", "Array");
        javaPlusPlusToJava.put("assert", "assert");
        javaPlusPlusToJava.put("bool", "boolean");
        javaPlusPlusToJava.put("break", "break");
        javaPlusPlusToJava.put("byte", "byte");
        javaPlusPlusToJava.put("case", "case");
        javaPlusPlusToJava.put("catch", "catch");
        javaPlusPlusToJava.put("Class", "Class");
        javaPlusPlusToJava.put("continue", "continue");
        javaPlusPlusToJava.put("default", "default");
        javaPlusPlusToJava.put("do", "do");
        javaPlusPlusToJava.put("double", "double");
        javaPlusPlusToJava.put("elif", "else if");
        javaPlusPlusToJava.put("else", "else");
        javaPlusPlusToJava.put("enum", "enum");
        javaPlusPlusToJava.put("extends", "extends");
        javaPlusPlusToJava.put("final", "final");
        javaPlusPlusToJava.put("finally", "finally");
        javaPlusPlusToJava.put("float", "float");
        javaPlusPlusToJava.put("for", "for");
        javaPlusPlusToJava.put("if", "if");
        javaPlusPlusToJava.put("in", " "); // Not sure how to make this work
        javaPlusPlusToJava.put("int", "int");
        javaPlusPlusToJava.put("implements", "implements");
        javaPlusPlusToJava.put("import", "import");
        javaPlusPlusToJava.put("instanceof", "instanceof");
        javaPlusPlusToJava.put("Interface", "Interface");
        javaPlusPlusToJava.put("long", "long");
        javaPlusPlusToJava.put("native", "native");
        javaPlusPlusToJava.put("new", "new");
        javaPlusPlusToJava.put("package", "package");
        javaPlusPlusToJava.put("println", "System.out.println");
        javaPlusPlusToJava.put("-", "private");
        javaPlusPlusToJava.put("#", "protected");
        javaPlusPlusToJava.put("+", "public");
        javaPlusPlusToJava.put("return", "return");
        javaPlusPlusToJava.put("short", "short");
        javaPlusPlusToJava.put("static", "static");
        javaPlusPlusToJava.put("stictfp", "strictfp");
        javaPlusPlusToJava.put("super", "super");
        javaPlusPlusToJava.put("switch", "switch");
        //Arithmetic
        javaPlusPlusToJava.put("+", "+");
        javaPlusPlusToJava.put("-", "-"); //Not sure how to make this work
        javaPlusPlusToJava.put("*", "*");
        javaPlusPlusToJava.put("/", "/");
        javaPlusPlusToJava.put("%", "%");
        javaPlusPlusToJava.put("=", "=");
        // Comparative
        javaPlusPlusToJava.put("is", "==");
        javaPlusPlusToJava.put("<", "<"); // Not sure how to make this work
        javaPlusPlusToJava.put("<=", "<=");
        javaPlusPlusToJava.put(">", ">");
        javaPlusPlusToJava.put(">=", ">=");




        JavaPlusPlusTokenizer tokenizer = new JavaPlusPlusTokenizer();
        StringBuilder input = new StringBuilder();
        input = tokenizer.readFile("ExampleCode\\MangoCode.txt");
        List<Token> tokens = tokenizer.tokenize(input.toString());

        // System.out.println("int numOne");
        System.out.println(tokenizer.tokenize("\"Hello Test\""));
        System.out.println(tokenizer.tokenize("int numOne"));
        System.out.println(tokenizer.tokenize("int  numOne"));

        // Iterate through tokens
        for (Token token : tokens) {
            if (token.value.equals("if")) {

            } else if (token.value.equals("elif")) {

            } else if (token.value.equals("else")) {

            } else if (token.value.equals("for")) {

            } else if (token.value.equals("while")) {

            } else if (token.value.equals("return")) {

            } else if (token.value.equals("func")) {

            } else if (token.value.equals("def")) {

            } else if (token.value.equals("is")) {

            } else if (token.value.equals("in")) {

            } else if (token.value.equals("static")) {

            } else if (token.value.equals("void")) {

            } else if (token.value.equals("class")) {

            } else if (token.value.equals("begin")) {

            } else if (token.value.equals("end")) {

            } else if (token.value.equals("println")) {

            } else if (token.value.equals("int")) {

            } else if (token.value.equals("char")) {

            } else if (token.value.equals("String")) {

            } else if (token.value.equals("bool")) {

            } else if (token.value.equals("float")) {

            } else if (token.value.equals("double")) {

            } else if (token.value.equals("+")) {

            } else if (token.value.equals("-")) {

            } else if (token.value.equals("*")) {

            } else if (token.value.equals("/")) {

            } else if (token.value.equals("=")) {

            } else if (token.value.equals("%")) {

            } else if (token.value.equals("<")) {

            } else if (token.value.equals("<=")) {

            } else if (token.value.equals(">")) {

            } else if (token.value.equals(">=")) {

            } else if (token.value.equals("(")) {

            } else if (token.value.equals(")")) {

            } else if (token.value.equals("[")) {

            } else if (token.value.equals("]")) {

            } else if (token.value.equals("{")) {

            } else if (token.value.equals("}")) {

            } else if (token.value.equals(";")) {

            } else if (token.value.equals(",")) {

            }
        }

    }
}
