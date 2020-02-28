package com.gce;

public class FibonacciFunctions {
    int iterative(int n) {
        int previousNumber = 0;
        int nextNumber = 1;

        for (int i = 1; i <= n; i++) {
            // System.out.print(previousNumber + " ");
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }
        return 0;
    }

    int recursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recursive(n - 2) + recursive(n - 1);
        }
    }
}
