import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Objective: Connect Java with a relational database.
 * Task: Connect to a local MySQL/SQLite database and retrieve data.
 */
public class BasicJDBCConnection {
    private static final String DB_URL = "jdbc:sqlite:test.db";

    public static void main(String[] args) {
        System.out.println("=== Basic JDBC Connection Demo ===");
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // 1. Load the SQLite JDBC driver (optional in modern JDBC but good practice)
            Class.forName("org.sqlite.JDBC");
            
            // 2. Establish Connection
            System.out.println("Connecting to database at " + DB_URL + "...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connection established successfully.");
            
            // 3. Create statement and table
            stmt = conn.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    "name TEXT NOT NULL, " +
                                    "age INTEGER, " +
                                    "grade TEXT" +
                                    ");";
            stmt.execute(createTableSQL);
            System.out.println("Verified/Created 'students' table.");
            
            // Clear existing and seed data if empty
            rs = stmt.executeQuery("SELECT count(*) FROM students;");
            if (rs.next() && rs.getInt(1) == 0) {
                System.out.println("Seeding initial student records...");
                stmt.executeUpdate("INSERT INTO students (name, age, grade) VALUES ('Alice', 20, 'A');");
                stmt.executeUpdate("INSERT INTO students (name, age, grade) VALUES ('Bob', 22, 'B');");
                stmt.executeUpdate("INSERT INTO students (name, age, grade) VALUES ('Charlie', 21, 'A');");
            }
            rs.close(); // close before re-using Statement
            
            // 4. Query and print results
            System.out.println("\nRetrieving student details:");
            String querySQL = "SELECT id, name, age, grade FROM students;";
            rs = stmt.executeQuery(querySQL);
            
            System.out.printf("%-5s | %-12s | %-5s | %-5s%n", "ID", "Name", "Age", "Grade");
            System.out.println("-------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                System.out.printf("%-5d | %-12s | %-5d | %-5s%n", id, name, age, grade);
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error: JDBC Driver not found in Classpath. Ensure sqlite-jdbc-*.jar is loaded.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 5. Clean up resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("Database resources released.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
