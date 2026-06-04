import java.util.Scanner;

/**
 * Objective: Create and use custom exceptions.
 * Task: Define a custom exception InvalidAgeException.
 * Instructions:
 * - Throw InvalidAgeException if the user's age is less than 18.
 * - Catch the exception and display a message.
 */
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Access Denied: You must be at least 18 years old. Entered age: " + age);
        } else {
            System.out.println("Access Granted: Welcome!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Custom Exception Demo ===");
        System.out.print("Please enter your age: ");
        
        if (scanner.hasNextInt()) {
            int age = scanner.nextInt();
            
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Custom Exception caught: " + e.getMessage());
            }
        } else {
            System.out.println("Error: Please enter a valid age as an integer.");
        }
        
        scanner.close();
    }
}
