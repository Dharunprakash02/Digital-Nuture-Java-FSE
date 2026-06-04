import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Objective: Use concurrency utilities.
 * Task: Execute multiple Callable tasks that return results.
 */
class CalculationTask implements Callable<String> {
    private int taskId;
    private int input;

    public CalculationTask(int taskId, int input) {
        this.taskId = taskId;
        this.input = input;
    }

    @Override
    public String call() throws Exception {
        // Simulate computation time
        Thread.sleep(200);
        int result = input * input;
        return "Task " + taskId + " finished. Result (Square of " + input + ") = " + result;
    }
}

public class ExecutorCallable {
    public static void main(String[] args) {
        System.out.println("=== Executor Service and Callable Demo ===");
        
        // 1. Create a Fixed Thread Pool of size 3
        int threadPoolSize = 3;
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        System.out.println("Initialized thread pool with " + threadPoolSize + " threads.");
        
        // 2. Create list of Callable tasks
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(new CalculationTask(1, 5));
        tasks.add(new CalculationTask(2, 8));
        tasks.add(new CalculationTask(3, 12));
        tasks.add(new CalculationTask(4, 15));
        tasks.add(new CalculationTask(5, 20));
        
        // 3. Submit tasks to the executor and collect Future objects
        List<Future<String>> futures = new ArrayList<>();
        System.out.println("Submitting " + tasks.size() + " tasks to the executor...");
        for (Callable<String> task : tasks) {
            Future<String> future = executor.submit(task);
            futures.add(future);
        }
        
        // 4. Retrieve results using Future.get() (this is blocking)
        System.out.println("\nRetrieving results (blocking wait):");
        for (Future<String> future : futures) {
            try {
                // Future.get() blocks until the specific task finishes
                String result = future.get();
                System.out.println("Result received: " + result);
            } catch (InterruptedException e) {
                System.err.println("Main thread was interrupted.");
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.err.println("Task execution failed: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        // 5. Shutdown the ExecutorService cleanly
        System.out.println("\nShutting down executor service...");
        executor.shutdown();
        System.out.println("Executor shutdown complete. Thread pool released.");
    }
}
