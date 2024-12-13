import java.util.HashMap;
import java.util.List;

public class Interpreter
{

    public String interpret(String filePath)
    {
        
        HashMap<String, String> keywords = new HashMap<>();
        HashMap<String, String> dataTypes = new HashMap<>();
        HashMap<String, String> arithmeticOperators = new HashMap<>();
        HashMap<String, String> comparativeOperators = new HashMap<>();
        HashMap<String, String> accessSpecifiers = new HashMap<>();
        HashMap<String, String> punctuation = new HashMap<>();

        keywords.put("abstract", "abstract");
        dataTypes.put("Array", "Array");
        keywords.put("assert", "assert");
        dataTypes.put("bool", "boolean");
        keywords.put("break", "break");
        dataTypes.put("byte", "byte");
        keywords.put("case", "case");
        keywords.put("catch", "catch");
        keywords.put("class", "class");
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
        keywords.put("in", " "); // Need built-in linear search, token before is what is being searched for, token after is where we're searching
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
        keywords.put("void", "void");

        accessSpecifiers.put("-", "private");
        accessSpecifiers.put("#", "protected");
        accessSpecifiers.put("+", "public");

        keywords.put("return", "return");
        dataTypes.put("short", "short");
        keywords.put("static", "static");
        keywords.put("stictfp", "strictfp");
        keywords.put("super", "super");
        keywords.put("switch", "switch");
        keywords.put("begin", "{");
        keywords.put("end", "}");
        dataTypes.put("String", "String");

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
        String input = tokenizer.readFile(filePath);
        List<Token> tokens = tokenizer.tokenize(input);
        StringBuilder outputString = new StringBuilder();


        // Iterate through tokens
        for (Token token : tokens) {
            if (token.type == TokenType.Whitespace)
            {

                outputString.append(token.value);

            }
            else if (token.type == TokenType.DataType)
            {

                outputString.append(dataTypes.get(token.value));

            }
            else if (token.type == TokenType.AccessSpecifier)
            {

                outputString.append(accessSpecifiers.get(token.value));

            }
            else if (token.type == TokenType.ReservedWord)
            {

                outputString.append(keywords.get(token.value));

            }
            else if (token.type == TokenType.Operator)
            {

                outputString.append(arithmeticOperators.get(token.value));

            }
            else if (token.type == TokenType.Punctuation)
            {

                outputString.append(token.value);

            }
            else if (token.type == TokenType.NumericLiteral)
            {

                outputString.append(token.value);

            }
            else if (token.type == TokenType.Variable)
            {

                if(token.value.equals("begin\r\n"))
                    outputString.append("{");
                else if (token.value.equals("end\r\n"))
                    outputString.append("}");
                else
                    outputString.append(token.value);

            }
            else if (token.type == TokenType.EscapeSequence)
            {

                outputString.append(token.value);

            }
            else if (token.type == TokenType.StringLiteral)
            {

                outputString.append(token.value);

            }
        }

        return outputString.toString();
    }
}
