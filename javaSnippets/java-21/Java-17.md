# Sample quesions


1. Java Sealed Classes
Question: What will be the output of the following Java 17 code?

sealed interface Vehicle permits Car, Bike {}

final class Car implements Vehicle {}

final class Bike implements Vehicle {}

<pre>
public class Test {
    public static void main(String[] args) {
        Vehicle v = new Car();
        System.out.println(v instanceof Vehicle);
    }
}
A) true
B) false
C) Compilation error
D) Runtime error
</pre>
Answer: ✅ A) true
Explanation: instanceof works correctly with sealed classes. The Car class is a permitted subclass of Vehicle, so the check evaluates to true.

2. Records
Question:
Which statement is true about Java Records in Java 17?

A) A record cannot have constructors.
B) A record cannot extend another class.
C) A record must implement at least one interface.
D) A record can be abstract.

Answer: ✅ B) A record cannot extend another class.
Explanation: Records are implicitly final and cannot extend another class (but they can implement interfaces). They do have constructors, and they cannot be abstract.

3. Pattern Matching for instanceof
Question:
What will be the output of this Java 17 code?

<pre>
public class Test {
    public static void main(String[] args) {
        Object obj = "OCP Java 17";
        if (obj instanceof String s) {
            System.out.println(s.length());
        }
    }
}
A) Compilation error
B) Runtime error
C) 12
D) 0
</pre>
Answer: ✅ C) 12
Explanation: The instanceof operator now supports pattern matching (introduced in Java 16 and finalized in Java 17). The variable s is automatically cast to String inside the if block.

4. Switch Expression Enhancements
Question:
What will be the output of this Java 17 switch statement?

<pre>
public class Test {
    public static void main(String[] args) {
        int num = 2;
        String result = switch (num) {
            case 1 -> "One";
            case 2, 3 -> "Two or Three";
            default -> "Other";
        };
        System.out.println(result);
    }
}
A) "One"
B) "Two or Three"
C) "Other"
D) Compilation error
</pre>
Answer: ✅ B) "Two or Three"
Explanation: Java 17 supports switch expressions with multiple labels (case 2, 3). The arrow -> syntax is used instead of break.

5. Text Blocks
Question:
What will be the output of this Java 17 code?

<pre>
public class Test {
    public static void main(String[] args) {
        String json = """
                {
                   "name": "OCP",
                   "version": 17
                }
                """;
        System.out.println(json);
    }
}
A) Compilation error
B) Runtime error
C) Prints JSON with new lines
D) Prints JSON on a single line
</pre>
Answer: ✅ C) Prints JSON with new lines
Explanation: Text blocks preserve line breaks and indentation. The triple-quote (""") syntax is used to define a multi-line string.

6. Compact Number Formatting (java.text.NumberFormat)
Question:
What will be the output of the following Java 17 code?

<pre>
import java.text.NumberFormat;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(formatter.format(1200));
    }
}
A) 1,200
B) 1.2K
C) 1K
D) Compilation error
</pre>
Answer: ✅ B) 1.2K
Explanation: Java 17 supports Compact Number Formatting using NumberFormat.getCompactNumberInstance(). The output depends on the locale and style (SHORT = 1.2K).

7. Java Records and Compact Constructors
Question:
Which of the following correctly defines a record with a compact constructor?

<pre>
record Employee(String name, int id) {
    // Choose the correct constructor
}
A)

java
Copy
Edit
public Employee {
    if (id < 0) throw new IllegalArgumentException("ID must be positive");
}
B)

java
Copy
Edit
public Employee(String name, int id) {
    if (id < 0) throw new IllegalArgumentException("ID must be positive");
    this.name = name;
    this.id = id;
}
C)

java
Copy
Edit
public Employee(int id) {
    this.name = "Unknown";
    this.id = id;
}
D) Compilation error

Answer: ✅ A) Compact Constructor
Explanation: A compact constructor (public Employee {}) does not explicitly reassign fields. Java automatically assigns them, and you only add validation logic.
</pre>

8. Sealed Classes and Exhaustiveness
Question:
Given the following Java 17 sealed class hierarchy:

<pre>
sealed interface Animal permits Dog, Cat {}

final class Dog implements Animal {}

final class Cat implements Animal {}

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        switch (a) {
            case Dog d -> System.out.println("Dog");
            case Cat c -> System.out.println("Cat");
        }
    }
}
What happens at runtime?

A) Prints "Dog"
B) Prints "Cat"
C) Compilation error
D) Runtime error
</pre>
Answer: ✅ C) Compilation error
Explanation: In Java 17, switch expressions with sealed types require handling all permitted subclasses or providing a default case. Since Animal is a sealed interface, the compiler enforces exhaustiveness.

9. Enhanced Pseudo-Random Number Generation
Question:
Which class was introduced in Java 17 to provide stream-based random numbers?

A) java.util.Random
B) java.security.SecureRandom
C) java.util.random.RandomGenerator
D) java.util.concurrent.ThreadLocalRandom

Answer: ✅ C) java.util.random.RandomGenerator
Explanation: Java 17 introduced RandomGenerator, a more flexible API for better random number generation, supporting multiple implementations like SplittableRandom, Xoroshiro128PlusPlus, etc.

Final Thoughts
These OCP 17 questions cover: ✅ Sealed Classes
✅ Pattern Matching for instanceof
✅ Switch Expressions
✅ Text Blocks
✅ Records & Compact Constructors
✅ Random Number API Enhancements
✅ Compact Number Formatting