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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FibonacciImplementation {

    // Set the number of iterations or passes
    static int iterations = 35;
    static int runtimes = 20;

    // Variables for calculating the execution times of Fibonacci methods
    static long startTime;
    static long endTime;

    // Instantiates the FibonacciFunctions
    static FibonacciFunctions fibonacci = new FibonacciFunctions();

    // Instantiates the arrays where the executin times will be stored
    static long[] recursive = new long[iterations];
    static long[] iterative = new long[iterations];

    /**
     * Main method. Will call the recursive and iterative methods
     * for as many passes as the value set for iterations
     * After making the calculations will export the results to
     * a CSV file
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        for (int n = 1; n <= runtimes; n++) {
            for (int i = 0; i < iterations - 1; i++) {
                iterative[i] = executeIterative(i);
                recursive[i] = executeRecursive(i);
            }

            System.out.println("Recursive results");
            System.out.println(Arrays.toString(recursive));

            System.out.println("Iterative results");
            System.out.println(Arrays.toString(iterative));

            exportResults(recursive, iterative, n);
        }
    }

    /**
     * Calls the iterative method to calculate de Fibonacci sequence
     *
     * @param n
     */
    private static long executeIterative(int n) {
        startTime = System.nanoTime();
        fibonacci.iterative(n);
        endTime = System.nanoTime();

        return endTime - startTime;
    }

    /**
     * Calls the recursive method to calculate the Fibonacci sequence
     *
     * @param n
     */
    private static long executeRecursive(int n) {
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            fibonacci.recursive(i);
        }
        endTime = System.nanoTime();

        return endTime - startTime;
    }

    /**
     * Outputs the results of time calculations to a CSV file for graphing
     *
     * @param recursive
     * @param iterative
     * @param n
     * @throws IOException
     */
    private static void exportResults(long[] recursive, long[] iterative, int n) throws IOException {
        String recursivefilename = "Fibonacci Results-Recursive-" + n + ".csv";
        String iterativefilename = "Fibonacci Results-Iterative-" + n + ".csv";

        BufferedWriter recursiveResults = new BufferedWriter(new FileWriter(recursivefilename));
        BufferedWriter iterativeResults = new BufferedWriter(new FileWriter(iterativefilename));

        StringBuilder sbR = new StringBuilder();
        StringBuilder sbI = new StringBuilder();

        for (long element : recursive) {
            sbR.append(element);
            sbR.append(",");
        }

        for (long element : iterative) {
            sbI.append(element);
            sbI.append(",");
        }

        recursiveResults.write(sbR.toString());
        recursiveResults.close();

        System.out.println();
        System.out.println(recursivefilename + " was saved.");

        iterativeResults.write(sbI.toString());
        iterativeResults.close();

        System.out.println(iterativefilename + " was saved.");
    }
}