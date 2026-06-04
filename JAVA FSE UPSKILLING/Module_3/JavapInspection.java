import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Objective: Explore compiled .class files.
 * Task: Compile a Java class and inspect its bytecode using javap.
 */
public class JavapInspection {

    // Simple method that will be compiled and inspected
    public int calculateSum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Using javap to Inspect Bytecode ===");
        System.out.println("Step 1: Write a Java class (like this JavapInspection.java).");
        System.out.println("Step 2: Compile the class using: javac JavapInspection.java");
        System.out.println("Step 3: Run javap to inspect compiled bytecode: javap -c JavapInspection");
        System.out.println("\n--- Programmatic Execution of 'javap -c' ---");
        
        try {
            // Run javap command using ProcessBuilder
            // Assuming this class is already compiled in the current directory
            ProcessBuilder pb = new ProcessBuilder("javap", "-c", "JavapInspection");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.out.println("\n[Note] Could not execute javap dynamically (perhaps compile is missing).");
                System.out.println("Please run manually:");
                System.out.println("  1) javac JavapInspection.java");
                System.out.println("  2) javap -c JavapInspection");
            }
            
        } catch (Exception e) {
            System.out.println("\n[Note] Could not run javap programmatically: " + e.getMessage());
            System.out.println("Compile and run manually to view bytecode.");
        }
    }
}
