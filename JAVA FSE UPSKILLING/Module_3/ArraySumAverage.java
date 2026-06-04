import java.util.Scanner;

/**
 * Objective: Work with arrays and perform calculations.
 * Task: Calculate the sum and average of elements in an array.
 */
public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Array Sum and Average ===");
        System.out.print("Enter the number of elements: ");
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            if (n <= 0) {
                System.out.println("Error: Size of array must be greater than zero.");
            } else {
                double[] array = new double[n];
                System.out.println("Enter " + n + " elements:");
                for (int i = 0; i < n; i++) {
                    System.out.print("Element " + (i + 1) + ": ");
                    if (scanner.hasNextDouble()) {
                        array[i] = scanner.nextDouble();
                    } else {
                        System.out.println("Invalid input. Assigning 0.0 to element " + (i + 1));
                        scanner.next(); // clear token
                        array[i] = 0.0;
                    }
                }
                
                // Calculate sum
                double sum = 0;
                for (double num : array) {
                    sum += num;
                }
                
                // Calculate average
                double average = sum / n;
                
                System.out.println("\n--- Results ---");
                System.out.println("Sum of elements: " + sum);
                System.out.println("Average of elements: " + average);
            }
        } else {
            System.out.println("Error: Size must be a valid integer.");
        }
        
        scanner.close();
    }
}
