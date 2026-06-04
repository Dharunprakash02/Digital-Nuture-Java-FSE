import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Objective: Use lightweight threads for scalable concurrency.
 * Task: Launch 100,000 virtual threads that each print a message (or increment a counter).
 * Instructions:
 * - Use Thread.startVirtualThread(() -> { ... }).
 * - Measure performance versus traditional threads.
 */
public class VirtualThreadsDemo {
    private static final int THREAD_COUNT = 100_000;

    public static void main(String[] args) {
        System.out.println("=== Virtual Threads Performance Benchmark (Java 21) ===");
        
        // 1. Run Benchmark using Virtual Threads
        System.out.println("Launching " + THREAD_COUNT + " Virtual Threads...");
        AtomicInteger virtualCounter = new AtomicInteger(0);
        List<Thread> virtualThreads = new ArrayList<>(THREAD_COUNT);
        
        Instant startVirtual = Instant.now();
        
        for (int i = 0; i < THREAD_COUNT; i++) {
            // Start virtual thread
            Thread vThread = Thread.startVirtualThread(() -> {
                virtualCounter.incrementAndGet();
            });
            virtualThreads.add(vThread);
        }
        
        // Wait for all virtual threads to finish
        for (Thread t : virtualThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        Instant endVirtual = Instant.now();
        Duration durationVirtual = Duration.between(startVirtual, endVirtual);
        System.out.println("Virtual Threads: Completed in " + durationVirtual.toMillis() + " ms.");
        System.out.println("Counter value: " + virtualCounter.get());
        
        System.out.println();
        
        // 2. Run Benchmark using Platform (Traditional) Threads
        // We will try to launch a smaller count (e.g., 2,000) of traditional threads, 
        // because creating 100,000 OS-backed threads would crash/exhaust OS thread resources.
        int platformThreadLimit = 2_000;
        System.out.println("Launching " + platformThreadLimit + " Traditional Platform Threads (Limited to avoid OS Crash)...");
        AtomicInteger platformCounter = new AtomicInteger(0);
        List<Thread> platformThreads = new ArrayList<>(platformThreadLimit);
        
        Instant startPlatform = Instant.now();
        
        try {
            for (int i = 0; i < platformThreadLimit; i++) {
                Thread pThread = new Thread(() -> {
                    platformCounter.incrementAndGet();
                });
                pThread.start();
                platformThreads.add(pThread);
            }
            
            for (Thread t : platformThreads) {
                t.join();
            }
        } catch (OutOfMemoryError oome) {
            System.err.println("OS thread resource exhausted during traditional threads launch!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Instant endPlatform = Instant.now();
        Duration durationPlatform = Duration.between(startPlatform, endPlatform);
        System.out.println("Platform Threads (" + platformThreadLimit + "): Completed in " + durationPlatform.toMillis() + " ms.");
        System.out.println("Counter value: " + platformCounter.get());
        
        System.out.println("\n--- Summary of Performance ---");
        System.out.println("Virtual threads are managed by the Java Virtual Machine (JVM) rather than mapped 1:1 to OS threads.");
        System.out.println("They are extremely lightweight, enabling millions of active threads to run on a single JVM.");
        System.out.printf("Virtual Thread rate: %.2f threads/ms.%n", (double) THREAD_COUNT / durationVirtual.toMillis());
        System.out.printf("Platform Thread rate: %.2f threads/ms.%n", (double) platformThreadLimit / durationPlatform.toMillis());
    }
}
