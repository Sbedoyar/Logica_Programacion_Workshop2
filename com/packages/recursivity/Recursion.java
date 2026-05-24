package com.packages.recursivity;

import java.util.Stack;

public class Recursion
{
    public Recursion()
    {
        
    }

    public static int factorial(int n)
    {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int sumSquare(int n)
    {
        if (n == 1) {
            return 1;
        } else {
            return n * n + sumSquare(n - 1);
        }
    }

    public static void displayNaturalNumbersDesc(int n)
    {
        if (n > 0) {
            System.out.println(n);
            displayNaturalNumbersDesc(n - 1);
        }
    }
    public static void displayNaturalNumbersAsc(int n, int i)
    {
        if (i <= n) {
            System.out.println(i);
            displayNaturalNumbersAsc(n, i + 1);
        }
    }

    public static void FibonacciIterative(int n)
    {
        int t1, t2, t3;
        t1 = 0;
        t2 = 1;
        System.out.println(t1 + "\n" + t2);
        for (int i = 3; i <= n; i++) {
            t3 = t1 + t2;
            System.out.println(t3);
            t1 = t2;
            t2 = t3; 
        }
    }

    public static int FibonacciRecursive(int n)
    {
        if (n > 1) {
            return FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2);
        } else {
            return n;
        }
    }


}