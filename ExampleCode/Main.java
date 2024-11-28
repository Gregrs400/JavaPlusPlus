public class Main {
    public static void main(String[] args){
        String str1 = "if";
        String str2 = "if elif else";
        String str3 = "for int i = 0";
        String str4 = "while x = myNum";
        String str5 = "public str myString";
        String str6 = "private char grade";
        String str7 = "+ - * / % =";
        String str8 = "private bool flag";
        String str9 = "\"Hello\"";
        String str10 = " 9_4a";
        Lexer lexer = new Lexer(str3);
        lexer.readInput();
    }
}
