import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Objective: Write data to a file.
 * Task: Write user input to a text file named output.txt.
 */
public class FileWriting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== File Writing Exercise ===");
        System.out.print("Enter a line of text to write to output.txt: ");
        String text = scanner.nextLine();
        
        String filename = "output.txt";
        
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(text);
            System.out.println("Success: Successfully wrote data to " + filename);
        } catch (IOException e) {
            System.err.println("Error: An error occurred while writing to the file.");
            e.printStackTrace();
        }
        
        scanner.close();
    }
}
