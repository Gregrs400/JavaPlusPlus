public class JavaToPythonConverter
{
    static
    {
        // Load the library using the full path to ensure it can be found
        System.load("/Users/israelcoleman/IdeaProjects/untitled/src/libjni_converter.so");
    }

    // Declare native method
    public native String convertJavaToPython(String javaCode);

    public static void main(String[] args)
    {
        JavaToPythonConverter converter = new JavaToPythonConverter();
        String javaCode = "public class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello, World!\"); } }";
        String pythonCode = converter.convertJavaToPython(javaCode);
        System.out.println("Python Code: \n" + pythonCode);
    }
}
