/**
 * Objective: Use interfaces in Java.
 * Task: Define an interface Playable with a method play().
 * Instructions:
 * - Implement the interface in classes Guitar and Piano.
 * - Each class should provide its own implementation of play().
 * - Instantiate the classes and call the method.
 */
interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Strumming the guitar: G - C - D chords playing!");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the piano: Symphonic classical melody playing!");
    }
}

public class InterfaceImplementation {
    public static void main(String[] args) {
        System.out.println("=== Interface Implementation ===");
        
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        
        System.out.print("Guitar performance: ");
        guitar.play();
        
        System.out.print("Piano performance: ");
        piano.play();
    }
}
