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

        // Initializing keywords hashmap
        keywords.put("abstract", "abstract");
        keywords.put("assert", "assert");
        keywords.put("begin", "{");
        keywords.put("break", "break");
        keywords.put("case", "case");
        keywords.put("catch", "catch");
        keywords.put("class", "class");
        keywords.put("continue", "continue");
        keywords.put("default", "default");
        keywords.put("do", "do");
        keywords.put("elif", "else if");
        keywords.put("else", "else");
        keywords.put("end", "}");
        keywords.put("extends", "extends");
        keywords.put("final", "final");
        keywords.put("finally", "finally");
        keywords.put("for", "for");
        keywords.put("if", "if");
        keywords.put("in", " "); // Need built-in linear search, token before is what is being searched for, token after is where we're searching
        keywords.put("implements", "implements");
        keywords.put("import", "import");
        keywords.put("instanceof", "instanceof");
        keywords.put("Interface", "Interface");
        keywords.put("native", "native");
        keywords.put("new", "new");
        keywords.put("package", "package");
        keywords.put("println", "System.out.println");
        keywords.put("return", "return");
        keywords.put("static", "static");
        keywords.put("stictfp", "strictfp");
        keywords.put("super", "super");
        keywords.put("switch", "switch");
        keywords.put("void", "void");

        // Initializing dataTypes hashmap
        dataTypes.put("Array", "Array");
        dataTypes.put("bool", "boolean");
        dataTypes.put("byte", "byte");
        dataTypes.put("double", "double");
        dataTypes.put("enum", "enum");
        dataTypes.put("float", "float");
        dataTypes.put("int", "int");
        dataTypes.put("long", "long");
        dataTypes.put("short", "short");
        dataTypes.put("String", "String");

        // Initializing accessSpecifiers hashmap
        accessSpecifiers.put("-", "private");
        accessSpecifiers.put("#", "protected");
        accessSpecifiers.put("+", "public");

        // Initializing arithmeticOperators hashmap
        arithmeticOperators.put("+", "+");
        arithmeticOperators.put("-", "-");
        arithmeticOperators.put("*", "*");
        arithmeticOperators.put("/", "/");
        arithmeticOperators.put("%", "%");
        arithmeticOperators.put("=", "=");

        // Initializing comparativeOperators hashmap
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
