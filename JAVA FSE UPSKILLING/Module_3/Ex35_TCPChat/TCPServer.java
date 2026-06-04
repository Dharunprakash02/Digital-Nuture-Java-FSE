package Ex35_TCPChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Objective: Use Java sockets for TCP communication.
 * Task: Implement a simple TCP chat server.
 */
public class TCPServer {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("=== TCP Chat Server ===");
        System.out.println("Starting server on port " + PORT + "...");
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is waiting for a client to connect...");
            
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
            
            // Set up streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            
            // Thread to read messages from the client
            Thread readThread = new Thread(() -> {
                try {
                    String clientMessage;
                    while ((clientMessage = in.readLine()) != null) {
                        System.out.println("\n[Client]: " + clientMessage);
                        System.out.print("[Server] Enter message: ");
                        if (clientMessage.equalsIgnoreCase("bye") || clientMessage.equalsIgnoreCase("exit")) {
                            System.out.println("\nClient requested exit. Disconnecting...");
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("\nConnection with client lost.");
                }
            });
            
            readThread.start();
            
            // Main thread sends messages to client from console
            System.out.print("[Server] Enter message: ");
            String serverMessage;
            while ((serverMessage = keyboard.readLine()) != null) {
                out.println(serverMessage);
                if (serverMessage.equalsIgnoreCase("bye") || serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Server shutting down...");
                    break;
                }
                System.out.print("[Server] Enter message: ");
            }
            
            // Wait for threads to clean up
            readThread.join();
            clientSocket.close();
            System.out.println("Server socket closed.");
            
        } catch (IOException | InterruptedException e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}
