package uncle_d_golf_pro_shop.services;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * InventoryServer listens for client connections and forwards commands
 * to ParserService. It sends JSON responses back to the client.
 */
public class InventoryServer {

    private final ParserService parser;

    /**
     * Creates a new InventoryServer that uses the provided ParserService.
     *
     * @param parser the parser that deals with client commands
     */
    public InventoryServer(ParserService parser) {
        this.parser = parser;
    }

    /**
     * This starts the server on the port given and waits for the single client to connect
     * then, reads the commands in a loop and returns the JSON response to the client.
     *
     * @param port the port number the server should operate on.
     *
     */
    public void start(int port) {
        System.out.println("Starting server on port " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ServerWorker worker = new ServerWorker(clientSocket, parser);
                Thread workerThread = new Thread(worker);
                workerThread.start();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server stopped.");
    }
}
