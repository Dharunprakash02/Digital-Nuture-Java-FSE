import java.util.Scanner;

/**
 * Objective: Implement loops.
 * Task: Print the multiplication table for a number up to 10.
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Multiplication Table ===");
        System.out.print("Enter a number: ");
        if (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            
            System.out.println("Multiplication table for " + number + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
        } else {
            System.out.println("Error: Please enter a valid number.");
        }
        
        scanner.close();
    }
}
