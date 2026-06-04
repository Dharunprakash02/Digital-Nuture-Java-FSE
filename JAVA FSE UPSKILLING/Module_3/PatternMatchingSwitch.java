/**
 * Objective: Simplify conditional logic with pattern matching in enhanced switch expressions (Java 21).
 * Task: Determine the type of an object and respond accordingly.
 */
public class PatternMatchingSwitch {

    // Method using Java 21 pattern matching for switch
    public static void identifyType(Object obj) {
        String result = switch (obj) {
            case Integer i -> "Integer value: " + i + " (squared: " + (i * i) + ")";
            case String s  -> "String value: \"" + s + "\" (length: " + s.length() + ")";
            case Double d  -> "Double value: " + d + " (half: " + (d / 2) + ")";
            case Boolean b -> "Boolean value: " + b + " (inverted: " + (!b) + ")";
            case null      -> "Null object reference";
            default        -> "Other type: " + obj.getClass().getSimpleName() + " -> " + obj;
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("=== Pattern Matching for switch (Java 21) ===");
        
        identifyType(123);
        identifyType("Hello Java 21");
        identifyType(3.14159);
        identifyType(true);
        identifyType(null);
        identifyType(new java.util.Date());
    }
}
