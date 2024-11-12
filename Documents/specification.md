# Introduction
Java++ is a superset of the Java programming language. It is designed to improve Java's readability and ease of use. Java++ includes features for arithmetic operations, conditional statement, loops, and function definitions.  

# Design Goals
The goal of Java++ is to improve upon the Java programming language by simplifying syntax and adding built-in features.

# Lexical Structure
    statement ::= variable_declaration  
	    | assignment_statement  
	    | if_statement  
	    | for_statement  
	    | while_statement  
	    | function_statement
    variable_declaration ::= “def” “public | private| protected” identifier “=” expression “;”  
    
    assignment_statement ::= identifier “=” expression ";”  
    
    if_statement ::= “if” expression “{“ statement* “}”  
	    [“elif” “{“ statement* “}”]  
	    [“else” “{“ statement* “}”]  
     
    for_statement ::= “for” “(“ expression ”;” expression “;” expression ";”  “)”  “{“ statement* “}”  
    
    while_statement ::= “while” “(“ expression “)” “{“ statement* “}” 
    
    function_statement ::= “public | private | protected” identifier “(“ parameter* “)” “{“ statement* “}”  
    
    parameter ::= [identifier (“,” identifier)*]  
    
    identifier ::= [a-zA-Z0-9]+  
    
    number_literal ::= [0-9]+ 

Identifiers: Must start with a letter or acceptable symbol. Identifiers may not start with a number. After the first character, an identifier can contain any combination of alphanumeric symbols.  
Literals: Numeric literals will only include a sequence of numbers. String literals must be enclosed in double quotes, and character literals must be enclosed in single quotes.  
Delimiters: Statements in this language will end with a semicolon.  
Comments: Inline comments can be made by using two forward slashes, and multi-line comments can be made using a forward slash followed by an asterisk and ending with an asterisk followed by a forward slash.  

# Reserved Words
if, elif, else, for, while, return, func, def, is, in
# Data Types
int, char, String, bool, float, double,
# Arithmetic Operations
+, -, *, /, =, %
# Comparative Operators
<, <=, >, >=, is
# Selection Sequences
if, elif, else
# Looping Sequences
For loop, while loop
# Functions
Functions will be defined using the word ‘func’ followed by the function’s name and parameters. After this, the body of the function can be defined.
