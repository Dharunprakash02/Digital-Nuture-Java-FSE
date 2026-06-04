import java.util.Scanner;

/**
 * Objective: Handle exceptions gracefully.
 * Task: Handle division by zero using try-catch.
 */
public class TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Try-Catch division Example ===");
        System.out.print("Enter first integer (numerator): ");
        if (scanner.hasNextInt()) {
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second integer (denominator): ");
            if (scanner.hasNextInt()) {
                int num2 = scanner.nextInt();
                
                try {
                    int result = num1 / num2;
                    System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                } catch (ArithmeticException e) {
                    System.err.println("Exception caught: " + e.getMessage());
                    System.err.println("Error: Division by zero is mathematically undefined.");
                }
            } else {
                System.out.println("Error: Denominator must be a valid integer.");
            }
        } else {
            System.out.println("Error: Numerator must be a valid integer.");
        }
        
        scanner.close();
    }
}
