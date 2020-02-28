/*
 * @author Guillermo Castaneda Echegaray
 * @version 1.0
 * @course CEN 3024C-27021
 * @instructor Dr. Lisa Macon
 * Assignment Description
 * Part I.
 * Implement the Fibonacci function in both a recursive and
 * iterative fashion. What’s the runtime efficiency of each?
 * Turn in a chart of the results, with time on the Y axis, and
 * input on the X axis, Please use nanosecond.
 * long startTime = System.nanoTime();
 * Part II.
 * Create documentation for your program.  Use the best
 * practices that you have learned in this module.
 */

package com.gce;

public class FibonacciImplementation {

    static int iterations;

    static long startTime;
    static long endTime;
    static FibonacciFunctions fibonacci = new FibonacciFunctions();

    public static void main(String[] args1) {
        for (int i = 0; i <= 35; i++) {
            executeRecursive(i);
            executeIterative(i);
        }
    }

    private static void executeIterative(int n) {
        // System.out.print("Iterative version to " + n + ": ");
        startTime = System.nanoTime();
        fibonacci.iterative(n);
        endTime = System.nanoTime();
        displayExecutionTime("Iteration", startTime, endTime);
    }

    private static void executeRecursive(int n) {
        // System.out.print("Recursive version to " + n + ": ");
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            fibonacci.recursive(i);
            // System.out.print(fibonacci.recursive(i) + " ");
        }
        endTime = System.nanoTime();
        displayExecutionTime("Recursion", startTime, endTime);
    }

    private static void displayExecutionTime(String methodType, long startTime, long endTime) {
        System.out.println(methodType + " with " + iterations + " iterations => execution time: " + (endTime - startTime) + " nanosecs.");
    }
}