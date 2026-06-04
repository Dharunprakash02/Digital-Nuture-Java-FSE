import java.util.Random;
import java.util.Scanner;

/**
 * Objective: Implement loops and conditional logic.
 * Task: Create a game where the user guesses a randomly generated number.
 */
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int targetNumber = random.nextInt(100) + 1; // 1 to 100
        int userGuess = 0;
        int attempts = 0;
        
        System.out.println("=== Number Guessing Game ===");
        System.out.println("I have generated a random number between 1 and 100.");
        System.out.println("Can you guess what it is?");
        
        // Loop until user guesses the number
        while (userGuess != targetNumber) {
            System.out.print("Enter your guess: ");
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer between 1 and 100.");
                scanner.next(); // clear the invalid token
            }
        }
        
        scanner.close();
    }
}
