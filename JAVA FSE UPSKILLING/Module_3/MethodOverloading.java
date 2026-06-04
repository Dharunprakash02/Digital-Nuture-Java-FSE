/**
 * Objective: Understand method overloading in Java.
 * Task: Create multiple methods with the same name but different parameters.
 */
public class MethodOverloading {

    // Overloaded method 1: Accepts two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Overloaded method 2: Accepts two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Overloaded method 3: Accepts three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("=== Method Overloading Demo ===");
        
        // Call first method
        int sumInts = add(10, 20);
        System.out.println("Sum of two integers (10 + 20): " + sumInts);
        
        // Call second method
        double sumDoubles = add(10.5, 20.3);
        System.out.println("Sum of two doubles (10.5 + 20.3): " + sumDoubles);
        
        // Call third method
        int sumThreeInts = add(5, 10, 15);
        System.out.println("Sum of three integers (5 + 10 + 15): " + sumThreeInts);
    }
}
