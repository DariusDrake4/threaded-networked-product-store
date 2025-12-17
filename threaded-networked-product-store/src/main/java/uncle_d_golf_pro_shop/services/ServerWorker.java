package uncle_d_golf_pro_shop.services;

import java.io.*;
import java.net.Socket;

public class ServerWorker implements Runnable {

    private final Socket clientSocket;
    private final ParserService parser;
    private final String rosterName = "DARIUS_DRAKE";

    public ServerWorker(Socket clientSocket, ParserService parser) {
        this.clientSocket = clientSocket;
        this.parser = parser;
    }

    @Override
    public void run() {
        System.out.println(rosterName + " | Client connected on thread: "
                + Thread.currentThread().getName());

        try (
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer =
                        new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String command;

            while ((command = reader.readLine()) != null) {

                System.out.println(rosterName + " | Received from client: " + command);

                if (command.equalsIgnoreCase("QUIT")) {
                    writer.println("{\"message\":\"Goodbye\"}");
                    break;
                }

                String response = parser.handle(command);
                writer.println(response);
            }

        } catch (IOException e) {
            System.out.println(rosterName + " | Error in ServerWorker: " + e.getMessage());
        }

        System.out.println(rosterName + " | Client disconnected.");
    }
}
