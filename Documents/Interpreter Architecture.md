# Interpreter Architecture

# Overview
At a high level, our interpreter is structured to take in the output of the tokenizer, translate the Java++ tokens into Java tokens using hashmaps, store the entire translated Java code into a single string, and pass that single string to the IDE class to be saved, compiled, and ran as a Java file.

# Initializing Hashmaps
Our interpreter class contains a single function called interpret(). This function begins by initializing a series of string hashmaps, one for each token type (numeric literal, access specifier, string literal, operator, variable, reserved word, data type, punctuation, whitespace, and escape sequence). These hashmaps are used to translate Java++ code to Java code. This is achieved by having the keys of the hashmaps be a Java++ token, and having the values of the hashmaps be a Java token. Translation is achieved by reading Java++ tokens one at a time, identifying the current token's type, and using the correct hashmap to extract the translated Java token. These translated Java tokens are appended to a StringBuilder object, and this object is the return value of the interpret() function.  

# Getting Tokenized Input
After initializing the hashmaps, the interpreter needs to get a list of Java++ tokens to interpret. To accomplish this, first the interpreter object creates a JavaPlusPlusTokenizer object. This JavaPlusPlusTokenizer object's readFile() function is called and passed a file path to an example Java++ file. This function returns all Java++ code read from the file into a string variable, and this string variable is passed to the JavaPlusPlusTokenizer object's tokenize() function. The tokenize() function returns a list of Java++ tokens. With the list of Java++ tokens, the translation into Java code can begin.

# Translating to Java Code
A for-each loop is used to iterate through all Java++ tokens returned from the tokenize() function. For each token read from the list, the token is compared against a series of if-statements to check the current token's type. Once the token's type is detemined, the corresponding hashmap is accessed using the current Java++ token as a key to access the translated Java token. This Java token is appended to a StringBuilder object, and once all tokens have been translated, the StringBuilder object is returned to the IDE class so the translated Java code can be saved to a .java file, compiled, and then executed using the JVM.
