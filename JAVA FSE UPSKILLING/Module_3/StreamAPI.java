import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Objective: Process collections using streams.
 * Task: Filter and display even numbers from a list.
 */
public class StreamAPI {
    public static void main(String[] args) {
        System.out.println("=== Stream API Demo ===");
        
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 100);
        System.out.println("Original List: " + numbers);
        
        // Use Stream API to filter even numbers and collect into a new list
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
                                           
        System.out.println("Even Numbers List: " + evenNumbers);
        
        // Display elements directly from the stream using forEach
        System.out.print("Printing even numbers directly: ");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
