# Language Tutorial
Java++ is very similar to traditional Java, with some slight syntax changes. The major differences between Java++ and Java are noted below:
| Language                          | Java++                            | Java      |
|-----------------------------------|-----------------------------------|-----------------------------------|
|Access Modifiers                   | +, -, #                           | public, private, protected |
| Code Blocks                       | begin, end                        | {, } |
| Print Statements                  | print()/println()                 | System.out.print(), System.out.println() |
| Else Block                        | elif                              | else if |
| Search for Value in Data Structure| x in myArray                      | if (myArray[i] == x) return found; |

# Creating a Java++ Program
Creating a Java++ program is very similar to creating a Java program. The only difference between the two is using the new, shorter syntax of Java++ in place of the older, longer syntax of native Java.
## Creating a Public Class
```Java++
// This is an example class in Java++
+ class Example
begin
  // Creating the main method
  + static void main(String[] args)
  begin
      println("This is how you print to the console in Java++!");
      // Declare some variables to perform arithmetic
      int x = 3;
      int y = 4;
      int z = x * y;
      println(z);
  end
end
```

## Using elif
```Java++
// This is an example class in Java++
+ class Example
begin
  // Creating the main method
  + static void main(String[] args)
  begin
      // Declare some variables, then check if they are equal
      int x = 100;
      int y = 200;
      if (x == y)
      begin
          println("The variables are equal!");
      end
      // Use 'elif' instead of 'else if'
      elif (x > y)
      begin
          println("x is greater than y!");
      end
      else
      begin
          println("y is greater than x!");
      end
  end
end
```
## Using in
```Java++
// This is an example class in Java++
+ class Example
begin
  // Creating the main method
  + static void main(String[] args)
  begin
      // Create an array, search for a value within the array
      int[] myArray = {1, 2, 3, 4, 5};
      int target = 4;
      boolean targetFound = false;
      // Check if target is in the array using 'in' keyword
      if (target in myArray)
      begin
          targetFound = true;
          println("Target has been found in myArray!");
      end
      else
      begin
          println("Target is not in myArray!");
      end
  end
end
```
# Conclusion
We hope this tutorial is enough for programmers to learn Java++. Overall, the language is very similar to traditional Java, however, we've added some changes to Java that we feel improve the language's usability and readability. That's why we called our language Java++ - it's an improvement upon Java!
