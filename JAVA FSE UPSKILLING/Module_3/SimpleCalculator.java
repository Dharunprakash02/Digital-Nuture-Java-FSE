import java.util.Scanner;

/**
 * Objective: Practice arithmetic operations and user input.
 * Task: Develop a calculator that performs addition, subtraction, multiplication, and division.
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Simple Calculator ===");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        System.out.print("Choose an operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);
        
        double result = 0;
        boolean valid = true;
        
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    valid = false;
                }
                break;
            default:
                System.out.println("Error: Invalid operation chosen.");
                valid = false;
                break;
        }
        
        if (valid) {
            System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + result);
        }
        
        scanner.close();
    }
}
