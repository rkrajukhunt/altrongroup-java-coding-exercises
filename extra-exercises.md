# Open Book Assignment

This open book (or open web) assignment includes a series of Java-related exercises. For each exercise, provide links to any articles used for guidance and add small comments on your approach. Reviewers will use these comments as a guide to assess your submission.

## Exercise 1: Total Even Numbers in an Array

**Task:** Given an array of ints, write a Java method to total all the values that are even numbers.

**Java Method:**
```java
public class EvenNumberTotal {
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int totalEven = totalEvenNumbers(numbers);
        System.out.println("Total of even numbers: " + totalEven);
    }

    public static int totalEvenNumbers(int[] array) {
        int total = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                total += num;
            }
        }
        return total;
    }
}
```

**Output:**
- Assuming the given array is {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, the output of the program would be: Total of even numbers: 30

**Explanation**
- The totalEvenNumbers method iterates through each element in the array.
- For each element, it checks if the number is even (divisible by 2).
- If the number is even, it adds the number to the total.
- The final total is printed in the main method.

---

## Exercise 2: Volatile vs. Transient Variables

**Task:** What is the difference between a volatile and a transient variable? And when to use them?

**Difference between `volatile` and `transient` Variables**
- **`volatile` Variable:**
  - **Definition:**
      - A `volatile` variable in Java is a type of variable that is marked with the `volatile` keyword.
      - It ensures that multiple threads observe changes to the variable made by other threads.
  - **Use Case:**
      - Typically used when multiple threads are involved, and one thread modifies the value of a variable, and other threads need to be notified about the change.
  - **Example:**
    ```java
    public class SharedResource {
        private volatile boolean flag = false;

        public void setFlagTrue() {
            flag = true;
        }

        public boolean isFlagSet() {
            return flag;
        }
- **`transient` Variable:**
  -   **Definition:**
      -   A `transient` variable in Java is a variable that is marked with the `transient` keyword.
      -   It indicates that the variable should not be serialized during object serialization.
  -   **Use Case:**
      -   Used when there are variables in a class that should not be included in the object's serialized form (e.g., sensitive information or data that can be reconstructed).
  - **Example:**
    ```java
    import java.io.Serializable;

    public class Person implements Serializable {
    private String name;
    private transient String sensitiveInfo;

    // Constructors, getters, setters...

    // Methods...
    
    // In this example, the sensitiveInfo variable is marked as transient to exclude it from the serialized form of the Person object.

**When to Use:**
  -   Use `volatile` when you want changes made by one thread to be visible to other threads.
  -   Use `transient` when you have data in a class that should not be serialized, typically for security or optimization reasons.

---
## Exercise 3: Thread Exercise

**Task:** Analyze and explain the output of the given Java program involving threads.

```java
public class ThreadExercise extends Thread {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b) {
            try{
                System.out.println("Waiting for b to complete...");
                sleep(1000);
            }catch(InterruptedException e){}

            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;
    @Override
    public void run() {
        synchronized(this){
            for(int i=0; i<=100 ; i++) {
                total = i;
            }
            notify();
        }
    }
}
```

**Explanation:**
- An instance of ThreadB is created and started in the main method.
- In the main method, the main thread enters a synchronized block on the object b. The main thread then prints "Waiting for b to complete..." and sleeps for 1000 milliseconds.
- While the main thread is sleeping, ThreadB executes its run method. Inside the run method, ThreadB enters a synchronized block on itself (this) and runs a loop, setting the total variable to the current loop index.
- After the loop in ThreadB completes, it calls notify() to notify any threads waiting on the same object (this).
- Back in the main method, after the main thread wakes up from sleep, it prints "Total is: " + b.total. This may not be the correct total because the loop in ThreadB may not have finished executing when the main thread prints the total.

**Possible Output:**
- The output of the program is non-deterministic. The main thread may print the total before ThreadB completes its loop, resulting in an incomplete or incorrect total.
- Regarding sleep(1000) vs b.wait():
  - If you replace sleep(1000) with b.wait(), it would cause a java.lang.IllegalMonitorStateException because the main thread is not the owner of the object's monitor (b), and you cannot call wait() on an object without holding its monitor using synchronized.