import java.util.Scanner;

/**
 * Objective: Apply nested conditional logic.
 * Task: Check if a given year is a leap year.
 * Instructions:
 * - A year is a leap year if it's divisible by 4 but not by 100, unless it's also divisible by 400.
 */
public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Leap Year Checker ===");
        System.out.print("Enter a year: ");
        if (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            boolean isLeap = false;
            
            // Nested conditional logic as requested
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeap = true;
                    } else {
                        isLeap = false;
                    }
                } else {
                    isLeap = true;
                }
            } else {
                isLeap = false;
            }
            
            if (isLeap) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is NOT a leap year.");
            }
        } else {
            System.out.println("Error: Please enter a valid year integer.");
        }
        
        scanner.close();
    }
}
