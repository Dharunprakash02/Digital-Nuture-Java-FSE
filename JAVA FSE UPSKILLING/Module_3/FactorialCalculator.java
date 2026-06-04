import java.util.Scanner;

/**
 * Objective: Use loops to perform repetitive calculations.
 * Task: Calculate the factorial of a number entered by the user.
 */
public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Factorial Calculator ===");
        System.out.print("Enter a non-negative integer: ");
        
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            
            if (num < 0) {
                System.out.println("Error: Factorial is not defined for negative numbers.");
            } else {
                long factorial = 1;
                for (int i = 1; i <= num; i++) {
                    factorial *= i;
                }
                System.out.println("The factorial of " + num + " (written as " + num + "!) is: " + factorial);
            }
        } else {
            System.out.println("Error: Please enter a valid non-negative integer.");
        }
        
        scanner.close();
    }
}
