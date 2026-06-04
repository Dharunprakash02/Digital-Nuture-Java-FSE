import java.util.Scanner;

/**
 * Objective: Use conditional statements to determine grades.
 * Task: Assign grades based on marks entered by the user.
 */
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Grade Calculator ===");
        System.out.print("Enter student's marks (out of 100): ");
        
        if (scanner.hasNextDouble()) {
            double marks = scanner.nextDouble();
            
            if (marks < 0 || marks > 100) {
                System.out.println("Error: Marks must be between 0 and 100.");
            } else {
                char grade;
                if (marks >= 90) {
                    grade = 'A';
                } else if (marks >= 80) {
                    grade = 'B';
                } else if (marks >= 70) {
                    grade = 'C';
                } else if (marks >= 60) {
                    grade = 'D';
                } else {
                    grade = 'F';
                }
                System.out.println("For marks: " + marks + ", the assigned Grade is: " + grade);
            }
        } else {
            System.out.println("Error: Please enter a valid numerical value.");
        }
        
        scanner.close();
    }
}
