import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Objective: Read data from a file.
 * Task: Read and display the contents of output.txt.
 */
public class FileReading {
    public static void main(String[] args) {
        String filename = "output.txt";
        System.out.println("=== Reading " + filename + " ===");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error: Could not read file. Make sure output.txt exists by running FileWriting first.");
            System.err.println("Details: " + e.getMessage());
        }
    }
}
