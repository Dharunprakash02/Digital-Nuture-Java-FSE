/**
 * Objective: Practice type casting between different data types.
 * Task: Convert a double to an int and vice versa.
 */
public class TypeCastingExample {
    public static void main(String[] args) {
        System.out.println("=== Type Casting Example ===");
        
        // 1. Narrowing Casting (Manual Casting): double to int
        double doubleValue = 9.78;
        int intValue = (int) doubleValue; // Explicit casting
        
        System.out.println("Original double value: " + doubleValue);
        System.out.println("Casted to int value (fractional part truncated): " + intValue);
        
        System.out.println();
        
        // 2. Widening Casting (Automatic Casting): int to double
        int anotherIntValue = 100;
        double anotherDoubleValue = anotherIntValue; // Implicit casting
        
        System.out.println("Original int value: " + anotherIntValue);
        System.out.println("Casted to double value: " + anotherDoubleValue);
    }
}
