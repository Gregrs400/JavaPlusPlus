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
//        // Testing the evaluatePostFix function
//        List<String> list = new ArrayList<String>();
//        list.add("10");
//        list.add("5");
//        list.add("+");
//        double result = evaluatePostfix(list);
//        System.out.println(result); // Should produce 15.0
//
//        // Clear list
//        list.clear();
//        list.add("10");
//        list.add("5");
//        list.add("2");
//        list.add("*");
//        list.add("+");
//        result = evaluatePostfix(list);
//        System.out.println(result); // Should produce 20.0
//
//        // Clear list
//        list.clear();
//        list.add("8");
//        list.add("3");
//        list.add("-");
//        result = evaluatePostfix(list);
//        System.out.println(result); // Should produce 5.0

        JavaPlusPlusTokenizer tokenizer = new JavaPlusPlusTokenizer();

        // System.out.println("int numOne");
        System.out.println(tokenizer.tokenize("\"Hello Test\""));
        System.out.println(tokenizer.tokenize("int numOne"));
        System.out.println(tokenizer.tokenize("int  numOne"));

    }
}
