package com.greetings;

import com.utils.MathUtils;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== Hello from com.greetings module ===");
        
        int a = 15;
        int b = 27;
        int sum = MathUtils.add(a, b);
        System.out.println("MathUtils.add(" + a + ", " + b + ") = " + sum);
        
        int n = 5;
        long fact = MathUtils.factorial(n);
        System.out.println("MathUtils.factorial(" + n + ") = " + fact);
    }
}
