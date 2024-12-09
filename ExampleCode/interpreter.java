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

    public void interpret()
    {
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

        HashMap<String, String> keywords = new HashMap<>();
        HashMap<String, String> dataTypes = new HashMap<>();
        HashMap<String, String> arithmeticOperators = new HashMap<>();
        HashMap<String, String> comparativeOperators = new HashMap<>();
        HashMap<String, String> accessSpecifiers = new HashMap<>();

        keywords.put("abstract", "abstract");
        dataTypes.put("Array", "Array");
        keywords.put("assert", "assert");
        dataTypes.put("bool", "boolean");
        keywords.put("break", "break");
        dataTypes.put("byte", "byte");
        keywords.put("case", "case");
        keywords.put("catch", "catch");
        keywords.put("Class", "Class");
        keywords.put("continue", "continue");
        keywords.put("default", "default");
        keywords.put("do", "do");
        dataTypes.put("double", "double");
        keywords.put("elif", "else if");
        keywords.put("else", "else");
        dataTypes.put("enum", "enum");
        keywords.put("extends", "extends");
        keywords.put("final", "final");
        keywords.put("finally", "finally");
        dataTypes.put("float", "float");
        keywords.put("for", "for");
        keywords.put("if", "if");
        keywords.put("in", " "); // Not sure how to make this work
        dataTypes.put("int", "int");
        keywords.put("implements", "implements");
        keywords.put("import", "import");
        keywords.put("instanceof", "instanceof");
        keywords.put("Interface", "Interface");
        dataTypes.put("long", "long");
        keywords.put("native", "native");
        keywords.put("new", "new");
        keywords.put("package", "package");
        keywords.put("println", "System.out.println");

        accessSpecifiers.put("-", "private");
        accessSpecifiers.put("#", "protected");
        accessSpecifiers.put("+", "public");

        keywords.put("return", "return");
        dataTypes.put("short", "short");
        keywords.put("static", "static");
        keywords.put("stictfp", "strictfp");
        keywords.put("super", "super");
        keywords.put("switch", "switch");

        //Arithmetic

        arithmeticOperators.put("+", "+");
        arithmeticOperators.put("-", "-");
        arithmeticOperators.put("*", "*");
        arithmeticOperators.put("/", "/");
        arithmeticOperators.put("%", "%");
        arithmeticOperators.put("=", "=");

        // Comparative

        comparativeOperators.put("is", "==");
        comparativeOperators.put("<", "<");
        comparativeOperators.put("<=", "<=");
        comparativeOperators.put(">", ">");
        comparativeOperators.put(">=", ">=");
        comparativeOperators.put("!=", "!=");

        JavaPlusPlusTokenizer tokenizer = new JavaPlusPlusTokenizer();
        StringBuilder input = tokenizer.readFile("ExampleCode\\MangoCode.txt");
        List<Token> tokens = tokenizer.tokenize(input.toString());
        ArrayList<String> outputStringList = new ArrayList<>();

        // System.out.println("int numOne");
//        System.out.println(tokenizer.tokenize("\"Hello Test\""));
//        System.out.println(tokenizer.tokenize("int numOne"));
        System.out.println(tokenizer.tokenize("int  numOne"));
//        System.out.println((tokenizer.readFile("ExampleCode/MangoCode.txt").toString()));
//        System.out.println(tokenizer.tokenize(tokenizer.readFile("ExampleCode/MangoCode.txt").toString()));

        // Iterate through tokens
        for (Token token : tokens) {
            if (token.type == TokenType.Whitespace)
            {

                outputStringList.add(token.value);

            }
            else if (token.type == TokenType.DataType)
            {

                outputStringList.add(dataTypes.get(token.value));

            }
            else if (token.type == TokenType.AccessSpecifier)
            {

                outputStringList.add(accessSpecifiers.get(token.value));

            }
            else if (token.type == TokenType.ReservedWord)
            {

                outputStringList.add(dataTypes.get(token.value));

            }
            else if (token.type == TokenType.Operator)
            {

                outputStringList.add(arithmeticOperators.get(token.value));

            }
            else if (token.type == TokenType.Punctuation)
            {

                outputStringList.add(token.value);

            }
            else if (token.type == TokenType.NumericLiteral)
            {

                outputStringList.add(token.value);

            }
            else if (token.type == TokenType.Variable)
            {

                outputStringList.add(token.value);

            }
            else if (token.type == TokenType.EscapeSequence)
            {

                outputStringList.add(token.value);

            }
        }

    }
}
