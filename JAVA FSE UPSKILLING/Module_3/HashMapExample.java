import java.util.HashMap;
import java.util.Scanner;

/**
 * Objective: Use key-value pairs.
 * Task: Map student IDs to names.
 */
public class HashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> studentMap = new HashMap<>();
        
        System.out.println("=== Student ID to Name Registry (HashMap) ===");
        
        // Add default sample data
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");
        
        System.out.println("Initial registry holds:");
        studentMap.forEach((id, name) -> System.out.println("ID: " + id + " -> Name: " + name));
        System.out.println();
        
        // Allow adding dynamic entries
        while (true) {
            System.out.print("Do you want to add a new student? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("y") && !choice.equals("yes")) {
                break;
            }
            
            System.out.print("Enter Student ID (Integer): ");
            int id;
            try {
                id = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format. Must be an integer.");
                continue;
            }
            
            if (studentMap.containsKey(id)) {
                System.out.println("Warning: ID " + id + " already exists. This will overwrite the student: " + studentMap.get(id));
            }
            
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }
            
            studentMap.put(id, name);
            System.out.println("Successfully added ID " + id + " -> " + name);
        }
        
        // Retrieve and display a name based on entered ID
        System.out.println("\n--- Search Student by ID ---");
        System.out.print("Enter Student ID to query: ");
        try {
            int queryId = Integer.parseInt(scanner.nextLine().trim());
            if (studentMap.containsKey(queryId)) {
                System.out.println("Found! Student ID " + queryId + " corresponds to: " + studentMap.get(queryId));
            } else {
                System.out.println("No student found with ID: " + queryId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid search ID format.");
        }
        
        scanner.close();
    }
}
