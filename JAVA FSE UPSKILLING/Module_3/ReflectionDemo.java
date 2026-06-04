import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Objective: Use Java Reflection API.
 * Task: Load a class and invoke methods dynamically.
 */
class SampleReflectiveClass {
    private String name = "Reflected Instance";

    public void greet(String message) {
        System.out.println("SampleReflectiveClass [" + name + "] says: " + message);
    }

    public int addNumbers(int a, int b) {
        return a + b;
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Reflection API Demo ===");
        
        try {
            // 1. Load the class dynamically using Class.forName()
            // Note: The class must be package-qualified if in a package. Here it is in the default package.
            Class<?> clazz = Class.forName("SampleReflectiveClass");
            System.out.println("Successfully loaded class: " + clazz.getName());
            
            // 2. Instantiate the class dynamically
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            System.out.println("Instantiated class dynamically using default constructor.");
            
            // 3. Print the declared methods and their parameter details
            System.out.println("\n--- Declared Methods ---");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("Method Name: " + method.getName() + " | Return Type: " + method.getReturnType().getSimpleName());
                Parameter[] params = method.getParameters();
                if (params.length > 0) {
                    System.out.print(" | Parameters: ");
                    for (int i = 0; i < params.length; i++) {
                        System.out.print(params[i].getType().getSimpleName() + " " + params[i].getName());
                        if (i < params.length - 1) System.out.print(", ");
                    }
                } else {
                    System.out.print(" | Parameters: None");
                }
                System.out.println();
            }
            
            // 4. Invoke methods dynamically using invoke()
            System.out.println("\n--- Invoking methods dynamically ---");
            
            // Invoke greet(String)
            Method greetMethod = clazz.getDeclaredMethod("greet", String.class);
            System.out.println("Invoking 'greet' with parameter 'Hello from Reflection!'...");
            greetMethod.invoke(instance, "Hello from Reflection!");
            
            // Invoke addNumbers(int, int)
            Method addMethod = clazz.getDeclaredMethod("addNumbers", int.class, int.class);
            System.out.println("Invoking 'addNumbers' with parameters 40 and 2...");
            Object sumResult = addMethod.invoke(instance, 40, 2);
            System.out.println("Invocation Result: " + sumResult);
            
        } catch (Exception e) {
            System.err.println("Reflection error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
