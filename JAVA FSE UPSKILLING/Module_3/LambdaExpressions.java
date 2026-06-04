import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Objective: Use functional programming features.
 * Task: Sort a list of strings using a lambda expression.
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        System.out.println("=== Sorting Strings using Lambda Expressions ===");
        
        List<String> programmingLanguages = new ArrayList<>();
        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        programmingLanguages.add("C++");
        programmingLanguages.add("JavaScript");
        programmingLanguages.add("Kotlin");
        programmingLanguages.add("Go");
        
        System.out.println("Original List: " + programmingLanguages);
        
        // 1. Sort alphabetically using standard lambda
        Collections.sort(programmingLanguages, (s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted Alphabetically (ascending): " + programmingLanguages);
        
        // 2. Sort by length using lambda expression
        Collections.sort(programmingLanguages, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("Sorted by length (ascending): " + programmingLanguages);
        
        // 3. Sort alphabetically in reverse using list.sort() and lambda
        programmingLanguages.sort((s1, s2) -> s2.compareTo(s1));
        System.out.println("Sorted Alphabetically (descending): " + programmingLanguages);
    }
}
