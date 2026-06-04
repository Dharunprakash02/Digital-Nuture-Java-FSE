/**
 * Objective: Explore how Java evaluates expressions.
 * Task: Evaluate and display the result of complex expressions.
 */
public class OperatorPrecedence {
    public static void main(String[] args) {
        System.out.println("=== Operator Precedence in Java ===");
        
        // Expression 1
        int result1 = 10 + 5 * 2;
        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Result: " + result1);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+).");
        System.out.println("             So, 5 * 2 = 10 is evaluated first, then 10 + 10 = 20.");
        
        System.out.println();
        
        // Expression 2
        int result2 = (10 + 5) * 2;
        System.out.println("Expression: (10 + 5) * 2");
        System.out.println("Result: " + result2);
        System.out.println("Explanation: Parentheses () override default precedence.");
        System.out.println("             So, 10 + 5 = 15 is evaluated first, then 15 * 2 = 30.");
        
        System.out.println();
        
        // Expression 3
        int result3 = 10 - 3 + 2;
        System.out.println("Expression: 10 - 3 + 2");
        System.out.println("Result: " + result3);
        System.out.println("Explanation: Addition (+) and subtraction (-) have the same precedence.");
        System.out.println("             They are evaluated left-to-right (associativity).");
        System.out.println("             So, 10 - 3 = 7 is evaluated first, then 7 + 2 = 9.");
        
        System.out.println();
        
        // Expression 4
        int result4 = 10 + 20 / 5 - 2 * 3;
        System.out.println("Expression: 10 + 20 / 5 - 2 * 3");
        System.out.println("Result: " + result4);
        System.out.println("Explanation: Division (/) and Multiplication (*) are evaluated left-to-right first:");
        System.out.println("             20 / 5 = 4  and  2 * 3 = 6.");
        System.out.println("             The expression becomes: 10 + 4 - 6.");
        System.out.println("             Addition and subtraction are then evaluated left-to-right:");
        System.out.println("             10 + 4 = 14, then 14 - 6 = 8.");
    }
}
