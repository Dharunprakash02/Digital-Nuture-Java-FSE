import java.util.Scanner;

/**
 * Objective: Combine string manipulation and conditional logic.
 * Task: Check if a string is a palindrome.
 * Instructions:
 * - Remove any non-alphanumeric characters and convert to lowercase.
 * - Check if the string reads the same forwards and backwards.
 */
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String original = scanner.nextLine();
        
        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = original.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if reads the same forwards and backwards
        boolean isPalindrome = true;
        int len = cleaned.length();
        for (int i = 0; i < len / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(len - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        
        System.out.println("Cleaned text: \"" + cleaned + "\"");
        if (cleaned.isEmpty()) {
            System.out.println("No alphanumeric characters were entered.");
        } else if (isPalindrome) {
            System.out.println("Result: \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + original + "\" is NOT a Palindrome.");
        }
        
        scanner.close();
    }
}
