/**
 * Objective: Implement inheritance.
 * Task: Create a base class Animal and a subclass Dog.
 * Instructions:
 * - Animal class should have a method makeSound().
 * - Dog class should override makeSound() to print "Bark".
 * - Instantiate both classes and call their methods.
 */
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        System.out.println("=== Inheritance Example ===");
        
        // Instantiate Animal (base class)
        Animal genericAnimal = new Animal();
        System.out.print("Animal sound: ");
        genericAnimal.makeSound();
        
        // Instantiate Dog (subclass)
        Dog myDog = new Dog();
        System.out.print("Dog sound: ");
        myDog.makeSound();
        
        // Demonstrate Polymorphism
        Animal polymorphicDog = new Dog();
        System.out.print("Polymorphic Dog sound: ");
        polymorphicDog.makeSound();
    }
}
