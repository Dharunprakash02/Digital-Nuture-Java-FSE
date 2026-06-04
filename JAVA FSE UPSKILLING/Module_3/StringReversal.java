import java.util.Scanner;

/**
 * Objective: Manipulate strings.
 * Task: Reverse a string entered by the user.
 */
public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== String Reversal ===");
        System.out.print("Enter a string to reverse: ");
        String original = scanner.nextLine();
        
        // Method 1: Using StringBuilder
        StringBuilder sb = new StringBuilder(original);
        String reversedSB = sb.reverse().toString();
        
        // Method 2: Using manual loop for demonstration
        char[] chars = original.toCharArray();
        String reversedManual = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reversedManual += chars[i];
        }
        
        System.out.println("Reversed (using StringBuilder): " + reversedSB);
        System.out.println("Reversed (using loop): " + reversedManual);
        
        scanner.close();
    }
}
