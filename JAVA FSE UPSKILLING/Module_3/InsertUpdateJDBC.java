import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Objective: Perform insert/update SQL queries from Java.
 * Task: Add and modify student data using JDBC.
 */
class StudentDAO {
    private static final String DB_URL = "jdbc:sqlite:test.db";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Insert student record
    public boolean insertStudent(String name, int age, String grade) {
        String insertSQL = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?);";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
            
        } catch (SQLException e) {
            System.err.println("Error inserting student: " + e.getMessage());
            return false;
        }
    }

    // Update student details (specifically grade and age by name)
    public boolean updateStudentGrade(String name, String newGrade) {
        String updateSQL = "UPDATE students SET grade = ? WHERE name = ?;";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            
            pstmt.setString(1, newGrade);
            pstmt.setString(2, name);
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
            return false;
        }
    }

    // Print all students
    public void printAllStudents() {
        String querySQL = "SELECT id, name, age, grade FROM students;";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(querySQL)) {
            
            System.out.printf("%-5s | %-12s | %-5s | %-5s%n", "ID", "Name", "Age", "Grade");
            System.out.println("-------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                System.out.printf("%-5d | %-12s | %-5d | %-5s%n", id, name, age, grade);
            }
        } catch (SQLException e) {
            System.err.println("Error querying database: " + e.getMessage());
        }
    }
}

public class InsertUpdateJDBC {
    public static void main(String[] args) {
        System.out.println("=== Insert and Update Operations in JDBC ===");
        
        StudentDAO dao = new StudentDAO();
        
        // Print current students
        System.out.println("\n--- Current DB State ---");
        dao.printAllStudents();
        
        // Insert new student
        System.out.println("\nInserting new student 'Daniel'...");
        boolean isInserted = dao.insertStudent("Daniel", 23, "B");
        if (isInserted) {
            System.out.println("Daniel was inserted successfully.");
        }
        
        // Print students after insert
        System.out.println("\n--- State after Insertion ---");
        dao.printAllStudents();
        
        // Update student
        System.out.println("\nUpdating Alice's grade to 'A+'...");
        boolean isUpdated = dao.updateStudentGrade("Alice", "A+");
        if (isUpdated) {
            System.out.println("Alice's grade updated successfully.");
        } else {
            System.out.println("No matching student found to update.");
        }
        
        // Print students after update
        System.out.println("\n--- State after Update ---");
        dao.printAllStudents();
    }
}
