import java.util.Scanner;

/**
 * Objective: Implement recursion.
 * Task: Calculate the nth Fibonacci number using recursion.
 */
public class RecursiveFibonacci {
    
    // Recursive method to find the nth Fibonacci number
    // Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
    // n = 1 -> 0
    // n = 2 -> 1
    // n = 3 -> 1
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Recursive Fibonacci ===");
        System.out.print("Enter a positive integer n (for nth Fibonacci term, 0-indexed): ");
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            if (n < 0) {
                System.out.println("Error: Please enter a non-negative integer.");
            } else {
                int result = fibonacci(n);
                System.out.println("Fibonacci term at index " + n + " is: " + result);
            }
        } else {
            System.out.println("Error: Please enter a valid integer.");
        }
        
        scanner.close();
    }
}
