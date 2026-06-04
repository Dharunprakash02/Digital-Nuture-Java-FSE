import java.util.Scanner;

/**
 * Objective: Utilize conditional statements.
 * Task: Determine if a number entered by the user is even or odd.
 */
public class EvenOrOddChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Even or Odd Checker ===");
        System.out.print("Enter an integer: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            
            if (number % 2 == 0) {
                System.out.println(number + " is an Even number.");
            } else {
                System.out.println(number + " is an Odd number.");
            }
        } else {
            System.out.println("Error: Please enter a valid integer.");
        }
        
        scanner.close();
    }
}
