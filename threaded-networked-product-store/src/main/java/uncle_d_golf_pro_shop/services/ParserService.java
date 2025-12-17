package uncle_d_golf_pro_shop.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import uncle_d_golf_pro_shop.models.SalableProduct;
import java.time.LocalDate;

/**
 * This handles the text commands the client sends to the correct inventory.
 * This operation in InventoryManager converts the JSON so they can be sent back to client.
 */

public class ParserService {

    private final IInventoryManager manager;
    private final ObjectMapper mapper;

    /**
     *This creates a ParserService which uses the inventory manager.
     *
     * @param manager inventory manager that does product operations
     */

    public ParserService(IInventoryManager manager) {
        this.manager = manager;
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.findAndRegisterModules();
    }

    /**
     * Approves a command that the client sends and returns back in the JSON format.
     *
     * @param command full text command sent by the Client.
     * @return returns a JSON string which is result of the command.
     */

    public String handle(String command) {
        try {
            String[] parts = command.split(" ");
            String verb = parts[0].toUpperCase();

            switch (verb) {

                case "ALL":
                    return json(manager.getAllProducts());

                case "GET":
                    return json(manager.getProductById(Integer.parseInt(parts[1])));

                case "FIND":
                    return json(manager.searchProductsByName(parts[1]));

                case "DELETE":
                    boolean removed = manager.removeProduct(Integer.parseInt(parts[1]));
                    return removed ? jsonMessage("Removed") : jsonError("Not found");
                case "SORT":
                    return json(manager.sortByPriceAscending());


                case "SORTDESC":
                    return json(manager.sortByPriceDescending());


                case "ADD":
                    return handleAdd(parts);

                default:
                    return jsonError("Unknown command");
            }

        } catch (Exception e) {
            return jsonError("Invalid command format");
        }
    }

    private String handleAdd(String[] parts) {
        try {
            if (parts.length < 6) {
                return jsonError("Invalid ADD parameters");
            }

            int id = Integer.parseInt(parts[1]);
            String name = parts[2];

            String priceText = parts[parts.length - 1];
            String dateText = parts[parts.length - 2];

            LocalDate date = LocalDate.parse(dateText);
            double price = Double.parseDouble(priceText);

            StringBuilder descBuilder = new StringBuilder();
            for (int i = 3; i < parts.length - 2; i++) {
                descBuilder.append(parts[i]).append(" ");
            }
            String description = descBuilder.toString().trim();

            SalableProduct product = new SalableProduct(id, name, description, date, price);

            boolean added = manager.addProduct(product);
            return added ? jsonMessage("Product added") : jsonError("ID exists");

        } catch (Exception e) {
            return jsonError("Invalid ADD parameters");
        }
    }

    private String json(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return jsonError("JSON error");
        }
    }

    private String jsonError(String message) {
        return "{\"error\":\"" + message + "\"}";
    }

    private String jsonMessage(String message) {
        return "{\"message\":\"" + message + "\"}";
    }
}
