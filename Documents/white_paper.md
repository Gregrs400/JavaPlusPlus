# Introduction
Java++ is a superset of the Java programming language aimed at improving Java by adding additional features and shortcuts to make it easier and more efficient at creating applications. In order to achieve this, Java++ will have symbols to denote access modifiers (+ for public, - for private), 'begin' and 'end' to denote code blocks, replacing 'this' keyword with the class name, adding a built-in swap() function to swap the values of variables much quicker, print() and println() statements for printing to the console, among other improvements. With these new helpful features, developers using Java++ can reduce the number of lines of code written, allowing for more concise applications. As the developers of Java++, we believe short, concise code is important as code is read more often than it is written.  

# Language Goals
Our overall goal for Java++ is to have a language that is robust, like Java, but also easy to read and write in, like Python. We aim to make a language that will be easy for beginners to pick up, and easy for experienced programmers to transition to. To accomplish this, Java++ will use short, simple syntax that is more intuitive than native Java's syntax. By using shorter syntax, programs written in Java++ will be much more concise compared to an equivalent program written in Java. The simpler syntax should make it easier for new programmers to pick up on Java++, and overall should make programs written in Java++ more readable. 

# Key Features
Java++ uses symbols for access modifiers - the + for public access, the - for private access, and the # for protected access.
```
// Native Java
public int value;
private String ID;
protected String name;
```

```
// Java++
+ int value;
- String ID;
# String name;
```

Java++ uses 'begin' and 'end' to denote a code block
```
// Native Java
public void greet()
{
  System.out.println("Hello!");
}
```

```
// Java++
+ void greet()
begin
  println("Hello!");
end
```

Java++ uses the class name instead of the 'this' keyword
```
// Native Java
class Person {
    String name;
    void setName(String name) {
        this.name = name;
    }
}

```

```
// Java++
class Person begin  
    - String name;  
    + void setName(String name) begin  
        Person.name = name;  
    end  
end

```

Java++ uses a swap() function to swap values of variables
```
int a = 5;  
int b = 10;  
swap(a, b);  
println(a); // Outputs 10  
println(b); // Outputs 5  
```
Java++ uses print()/println() statements
```
// Native Java
System.out.println("Hello, World!");
```

```
// Java++
println("Hello, World!");
```

# Implementation Approach
The Java++ language is implemented using a two-step process:

Tokenizer:
A tokenizer reads Java++ code from a .jpp file and categorizes the code into token types such as string literals, numeric literals, variables, operators, reserved words, data types, and punctuation.

Interpreter:

Tokens are passed to the interpreter, which uses hashmaps for each token type to map Java++ tokens to their corresponding Java tokens.
Translated Java tokens are assembled into a valid Java code string.
The string of Java tokens is compiled and executed, displaying the output.
IDE Integration:
Java++ is supported by a custom Integrated Development Environment (IDE) built using Java Swing.

The top-half of the IDE displays the original Java++ code.
The bottom-half shows the translated Java output or runtime results.  

# Conclusion
Java++ successfully extends Java by adding intuitive features and syntax improvements that enhance readability, reduce boilerplate code, and make programming more efficient. By simplifying access modifiers, introducing begin and end for code blocks, replacing the this keyword with the class name, and adding built-in utility functions like swap(), Java++ offers a modernized approach to Java development.

With its focus on beginner-friendliness, readability, and compatibility, Java++ bridges the gap between Java’s robustness and the simplicity of languages like Python. As a result, Java++ empowers developers to write cleaner, more concise code, improving both productivity and maintainability.

