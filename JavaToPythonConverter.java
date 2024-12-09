public class JavaToPythonConverter
{
    static
    {
        System.loadLibrary("jni_converter"); // Load the native library
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