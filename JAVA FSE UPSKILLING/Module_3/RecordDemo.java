import java.util.List;

/**
 * Objective: Use the record keyword for immutable data structures (Java 16+).
 * Task: Create a record to represent a Person with name and age.
 */
record Person(String name, int age) {
    // Record automatic features:
    // - Private final fields for name and age
    // - Getter methods: name() and age()
    // - Constructor matching the signature
    // - toString(), equals(), hashCode() auto-generation
}

public class RecordDemo {
    public static void main(String[] args) {
        System.out.println("=== Records in Java (16+) ===");
        
        // 1. Create instances and print them (testing toString auto-generation)
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 17);
        Person p3 = new Person("Charlie", 32);
        Person p4 = new Person("Diana", 15);
        
        System.out.println("Person 1 Details: " + p1);
        System.out.println("Person 2 Details: " + p2);
        
        // 2. Use records in a List
        List<Person> group = List.of(p1, p2, p3, p4);
        
        // 3. Filter based on age >= 18 using Streams
        System.out.println("\n--- Adults (Age >= 18) ---");
        List<Person> adults = group.stream()
                                   .filter(person -> person.age() >= 18) // record getter is age()
                                   .toList(); // Java 16+ Stream.toList()
                                   
        adults.forEach(System.out::println);
    }
}
