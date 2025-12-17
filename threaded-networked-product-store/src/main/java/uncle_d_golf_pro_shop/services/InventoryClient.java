package uncle_d_golf_pro_shop.services;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * InventoryClient connects to the inventory server which grants users ability to send commands.
 * The client prints out the server's JSON response for every single command entered.
 * to send text commands. The client prints out the server's JSON response
 */
public class InventoryClient {

    /**
     * Starting point for the client program. Connects to server, reads the users commands.
     * sends them back to the server which displays the JSON response.
     * the JSON response is then returned by the server.
     *
     * @param args command-line arguments.
     */

    public static void main(String[] args) {
        String host = "localhost";
        int port = 5050;

        try (Socket socket = new Socket(host, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to inventory server.");

            String command;

            while (true) {
                System.out.print("Enter command (ALL, GET <id>, FIND <name>, DELETE <id>, QUIT): ");
                command = scanner.nextLine().trim();

                writer.println(command);

                    if (command.equalsIgnoreCase("QUIT")) {
                    System.out.println("Goodbye!");
                    break;
                }

                String response = reader.readLine();

                    if (response == null) {
                    System.out.println("Server closed the connection.");
                    break;
                }

                System.out.println("SERVER RESPONSE: " + response);
            }

        }

        catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
