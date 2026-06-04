package com.utils;

public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
