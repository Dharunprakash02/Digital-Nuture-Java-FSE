import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Objective: Use JDBC transactions.
 * Task: Simulate a money transfer between two accounts.
 */
public class TransactionJDBC {
    private static final String DB_URL = "jdbc:sqlite:test.db";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite JDBC Driver not found", e);
        }
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            // Create accounts table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                                    "account_id INTEGER PRIMARY KEY, " +
                                    "owner_name TEXT NOT NULL, " +
                                    "balance REAL CHECK(balance >= 0)" + // balance cannot go negative
                                    ");";
            stmt.execute(createTableSQL);
            
            // Clear and Seed initial balances
            stmt.executeUpdate("DELETE FROM accounts;");
            stmt.executeUpdate("INSERT INTO accounts (account_id, owner_name, balance) VALUES (1, 'Alice', 1000.0);");
            stmt.executeUpdate("INSERT INTO accounts (account_id, owner_name, balance) VALUES (2, 'Bob', 500.0);");
            System.out.println("Accounts table initialized and seeded: Alice (id:1) has $1000, Bob (id:2) has $500.");
            
        } catch (SQLException e) {
            System.err.println("Database initialization failed: " + e.getMessage());
        }
    }

    public static void printBalances() {
        String sql = "SELECT account_id, owner_name, balance FROM accounts;";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("--- Current Account Balances ---");
            while (rs.next()) {
                System.out.printf("Acc ID: %d | Owner: %-8s | Balance: $%.2f%n",
                                  rs.getInt("account_id"),
                                  rs.getString("owner_name"),
                                  rs.getDouble("balance"));
            }
            System.out.println("---------------------------------");
            
        } catch (SQLException e) {
            System.err.println("Querying balances failed: " + e.getMessage());
        }
    }

    // Money transfer transaction method
    public static void transferMoney(int fromAcc, int toAcc, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?;";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?;";
        
        Connection conn = null;
        PreparedStatement debitStmt = null;
        PreparedStatement creditStmt = null;
        
        try {
            conn = getConnection();
            
            // Disable auto-commit to begin the transaction
            conn.setAutoCommit(false);
            
            // 1. Perform Debit operation
            debitStmt = conn.prepareStatement(debitSQL);
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAcc);
            int debitedRows = debitStmt.executeUpdate();
            
            // 2. Perform Credit operation
            creditStmt = conn.prepareStatement(creditSQL);
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAcc);
            int creditedRows = creditStmt.executeUpdate();
            
            // Verify if both updates affected exactly one row
            if (debitedRows == 1 && creditedRows == 1) {
                // Commit changes if both succeeded
                conn.commit();
                System.out.printf("Transaction Succeeded: Transferred $%.2f from Account %d to Account %d.%n", amount, fromAcc, toAcc);
            } else {
                // Force a rollback if either account does not exist
                throw new SQLException("Invalid account(s) targeted. Transaction aborted.");
            }
            
        } catch (SQLException e) {
            System.err.println("Transaction Failed! Reason: " + e.getMessage());
            if (conn != null) {
                try {
                    System.out.println("Rolling back transaction changes...");
                    conn.rollback();
                } catch (SQLException ex) {
                    System.err.println("Error performing rollback: " + ex.getMessage());
                }
            }
        } finally {
            // Clean up resources and restore default auto-commit behavior
            try {
                if (debitStmt != null) debitStmt.close();
                if (creditStmt != null) creditStmt.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== JDBC Transaction Handling Demo ===");
        
        // Setup initial accounts and balances
        initializeDatabase();
        printBalances();
        
        // Case 1: Valid Transfer
        System.out.println("\n--- Attempting Valid Transfer: $200 from Alice (1) to Bob (2) ---");
        transferMoney(1, 2, 200.0);
        printBalances();
        
        // Case 2: Invalid Transfer (Triggering Rollback due to Balance Check Constraint)
        // Alice has $800 left, transferring $1200 is invalid since balance cannot go negative (due to CHECK constraint in SQLite)
        System.out.println("\n--- Attempting Invalid Transfer (Insufficient Balance): $1200 from Alice (1) to Bob (2) ---");
        transferMoney(1, 2, 1200.0);
        printBalances();
        
        // Case 3: Invalid Transfer (Targeting non-existent account)
        System.out.println("\n--- Attempting Invalid Transfer (Non-existent Account): $100 from Bob (2) to Account (999) ---");
        transferMoney(2, 999, 100.0);
        printBalances();
    }
}
