/**
 * Objective: Implement multithreading.
 * Task: Create and run two threads that print messages.
 */
class MessagePrinter implements Runnable {
    private String message;
    private int count;

    public MessagePrinter(String message, int count) {
        this.message = message;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + message + " (Iteration " + i + ")");
            try {
                // Sleep briefly to show execution interleaving
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        System.out.println("=== Thread Creation & Multithreading ===");
        
        // Creating Runnable tasks
        Runnable task1 = new MessagePrinter("Hello from Task 1!", 5);
        Runnable task2 = new MessagePrinter("Bonjour from Task 2!", 5);
        
        // Creating Thread objects
        Thread thread1 = new Thread(task1, "PrinterThread-1");
        Thread thread2 = new Thread(task2, "PrinterThread-2");
        
        // Starting threads
        System.out.println("Starting threads now...");
        thread1.start();
        thread2.start();
        
        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
        }
        
        System.out.println("All threads have finished execution.");
    }
}
