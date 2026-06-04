/**
 * Objective: Reverse engineer compiled Java bytecode.
 * Task: Decompile a compiled class file.
 * 
 * Instructions to run manual decompilation:
 * 1. Compile the file: 
 *    javac DecompileClass.java
 * 
 * 2. This creates two class files:
 *    - DecompileClass.class (the main driver)
 *    - TargetProgram.class (the class to be decompiled)
 * 
 * 3. Decompile using a tool. Recommended command line tools:
 *    - CFR: java -jar cfr.jar TargetProgram.class
 *    - Procyon: procyon-decompiler TargetProgram.class
 *    Or drag-and-drop TargetProgram.class into GUI decompilers like JD-GUI or Bytecode Viewer.
 */
class TargetProgram {
    private String secretKey = "JAVA_FSE_UPSKILLING_2026";
    private int val = 100;

    public void processData(int input) {
        if (input > val) {
            System.out.println("Input is greater than 100. Key is: " + secretKey);
        } else {
            System.out.println("Processing standard request.");
        }
    }
}

public class DecompileClass {
    public static void main(String[] args) {
        System.out.println("=== Decompile Class File Demonstration ===");
        System.out.println("We have defined a target class 'TargetProgram' containing private fields and conditional logic.");
        System.out.println("Once compiled, the private fields and structural control flow are saved as bytecode in 'TargetProgram.class'.");
        
        System.out.println("\n--- Step-by-Step Decompilation Instructions ---");
        System.out.println("1. Run compilation to generate class files:");
        System.out.println("   > javac DecompileClass.java");
        System.out.println("\n2. Use a Java Decompiler to reconstruct source code from 'TargetProgram.class':");
        System.out.println("   - Tool A (JD-GUI): Launch JD-GUI and open TargetProgram.class.");
        System.out.println("   - Tool B (CFR decompiler): Run command:");
        System.out.println("     > java -jar cfr.jar TargetProgram.class");
        System.out.println("   - Tool C (IntelliJ IDEA): Simply drag TargetProgram.class into IntelliJ; it will auto-decompile.");
        
        System.out.println("\n--- What to Observe in the Decompiled Code ---");
        System.out.println("1. Reconstructed variables names, private keywords, and method signatures.");
        System.out.println("2. Compilation changes: compiler optimisations like String concatenation (+ operator) converted to StringBuilder,");
        System.out.println("   and implicit constructors added automatically by javac.");
    }
}
