/**
 * Objective: Understand classes and objects.
 * Task: Create a Car class with attributes and methods.
 */
class Car {
    // Attributes
    private String make;
    private String model;
    private int year;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Car Details: " + year + " " + make + " " + model);
    }

    // Getters and Setters
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}

public class CarDemo {
    public static void main(String[] args) {
        System.out.println("=== Class and Object Creation ===");
        
        // Instantiating Car objects
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Tesla", "Model S", 2023);
        
        // Calling displayDetails method
        car1.displayDetails();
        car2.displayDetails();
    }
}
