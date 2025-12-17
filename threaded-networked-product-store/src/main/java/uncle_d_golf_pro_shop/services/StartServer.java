package uncle_d_golf_pro_shop.services;

/**
 * Begins the inventory Server and initializes the InventoryManager as well as the ParserService.
 * This class holds the main method that is used to run the server application.
 */
public class StartServer {

    /**
     * This is the starting point for the inventory server.
     * Creates the manager and parser as well as starts the port 5050
     *
     * @param args command-line arguments.
     *
     */
    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        ParserService parser = new ParserService(manager);

        InventoryServer server = new InventoryServer(parser);
        server.start(5050);


        System.out.println("Threaded server is running...");
    }
}
