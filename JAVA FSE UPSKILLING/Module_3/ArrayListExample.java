import java.util.ArrayList;
import java.util.Scanner;

/**
 * Objective: Use dynamic arrays.
 * Task: Manage a list of student names.
 */
public class ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        
        System.out.println("=== Student List Manager (ArrayList) ===");
        
        String input = "";
        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            if (!input.isEmpty()) {
                students.add(input);
                System.out.println("Added: " + input);
            } else {
                System.out.println("Name cannot be empty.");
            }
        }
        
        System.out.println("\n--- All Students Entered (" + students.size() + ") ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
        
        scanner.close();
    }
}
