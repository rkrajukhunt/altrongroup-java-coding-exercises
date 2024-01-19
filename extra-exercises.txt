# Open Book Assignment

This open book (or open web) assignment includes a series of Java-related exercises. For each exercise, provide links to any articles used for guidance and add small comments on your approach. Reviewers will use these comments as a guide to assess your submission.

## Exercise 1: Total Even Numbers in an Array

**Task:** Given an array of ints, write a Java method to total all the values that are even numbers.

**Approach:**
I will implement a Java method that iterates through the array and accumulates the sum of even numbers. I might use the modulus operator `%` to check if a number is even.

---

## Exercise 2: Volatile vs. Transient Variables

**Task:** What is the difference between a volatile and a transient variable? And when to use them?

**Approach:**
I will provide a clear explanation of the differences between volatile and transient variables, considering their use cases. I might refer to reliable sources like the Java documentation and relevant articles to support my explanation.

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

**Approach:**
I will analyze the provided Java program and explain the output. Additionally, I will address whether the answer changes if we replace sleep(1000); with b.wait(); and provide reasons for any changes or lack thereof.