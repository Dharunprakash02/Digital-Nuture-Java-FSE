package Ex35_TCPChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Objective: Use Java sockets for TCP communication.
 * Task: Implement a simple TCP chat client.
 */
public class TCPClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("=== TCP Chat Client ===");
        System.out.println("Connecting to server at " + SERVER_IP + ":" + PORT + "...");
        
        try (Socket socket = new Socket(SERVER_IP, PORT)) {
            System.out.println("Connected to the chat server!");
            
            // Set up streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            
            // Thread to read messages from the server
            Thread readThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println("\n[Server]: " + serverMessage);
                        System.out.print("[Client] Enter message: ");
                        if (serverMessage.equalsIgnoreCase("bye") || serverMessage.equalsIgnoreCase("exit")) {
                            System.out.println("\nServer closed connection. Exiting...");
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("\nDisconnected from server.");
                }
            });
            
            readThread.start();
            
            // Main thread sends messages to server from console
            System.out.print("[Client] Enter message: ");
            String clientMessage;
            while ((clientMessage = keyboard.readLine()) != null) {
                out.println(clientMessage);
                if (clientMessage.equalsIgnoreCase("bye") || clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Closing client connection...");
                    break;
                }
                System.out.print("[Client] Enter message: ");
            }
            
            // Wait for threads to clean up
            readThread.join();
            System.out.println("Client socket closed.");
            
        } catch (IOException | InterruptedException e) {
            System.err.println("Client exception: " + e.getMessage());
        }
    }
}
