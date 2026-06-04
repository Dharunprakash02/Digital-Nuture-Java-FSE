import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Objective: Make HTTP requests from Java.
 * Task: Fetch data from a public API (e.g., GitHub).
 * Instructions:
 * - Use HttpClient and HttpRequest.
 * - Print the response status and body.
 */
public class HTTPClientDemo {
    public static void main(String[] args) {
        System.out.println("=== HTTP Client API Demo (Java 11+) ===");
        
        // Define public API URL (GitHub octocat profile info)
        String apiUri = "https://api.github.com/users/octocat";
        System.out.println("Sending GET request to: " + apiUri);
        
        // 1. Create HttpClient instance
        HttpClient client = HttpClient.newHttpClient();
        
        // 2. Build HTTP request with User-Agent header (required by GitHub API)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUri))
                .header("User-Agent", "Java11-HttpClient")
                .header("Accept", "application/json")
                .GET()
                .build();
                
        // 3. Send request and print response details
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("\n--- Response Summary ---");
            System.out.println("HTTP Status Code: " + response.statusCode());
            System.out.println("Response Headers: " + response.headers().map());
            System.out.println("\nResponse Body:");
            System.out.println(response.body());
            
        } catch (IOException | InterruptedException e) {
            System.err.println("HTTP request failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
