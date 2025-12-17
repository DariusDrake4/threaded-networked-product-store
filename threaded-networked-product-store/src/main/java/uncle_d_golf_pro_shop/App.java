//package uncle_d_golf_pro_shop;
//
//import uncle_d_golf_pro_shop.services.StoreFront;
//import uncle_d_golf_pro_shop.actions.StoreManagerActions;
//import uncle_d_golf_pro_shop.actions.CustomerActions;
//import java.util.Scanner;
//
//public class App {
//
//    public static void main(String[] args) {
//        StoreFront storeFront = new StoreFront();
//
//        // ======== BEGIN MILESTONE 4 TEST ========
//        System.out.println("\n--- Testing JSON Save/Load ---");
//
//        // Save current inventory to JSON file
//        storeFront.saveInventoryToFile("Data/inventory.json");
//
//        // Clear inventory to prove load works
//        storeFront.getInventoryManager().getInventory().clear();
//        System.out.println("Inventory cleared. Current size: "
//                + storeFront.getInventoryManager().getInventory().size());
//
//        // Load inventory back from JSON file
//        storeFront.loadInventoryFromFile("Data/inventory.json");
//
//        // Verify results in console
//        System.out.println("Reloaded inventory size: "
//                + storeFront.getInventoryManager().getInventory().size());
//        System.out.println("--- Inventory Items ---");
//        for (var product : storeFront.getInventoryManager().getInventory()) {
//            System.out.println(product);
//        }
//        System.out.println("--- End of Test ---\n");
//        // ======== END MILESTONE 4 TEST ========
//
//        // ======== ORIGINAL APPLICATION MENU ========
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Welcome to Uncle D Golf Pro Shop!");
//        System.out.println("1. Manager Menu");
//        System.out.println("2. Customer Menu");
//        System.out.println("3. Exit");
//        System.out.print("Enter your choice: ");
//
//        int choice = scanner.nextInt();
//
//        if (choice == 1) {
//            StoreManagerActions managerActions = new StoreManagerActions(storeFront);
//            managerActions.menu();
//        } else if (choice == 2) {
//            CustomerActions customerActions = new CustomerActions(storeFront);
//            customerActions.menu();
//        } else {
//            System.out.println("Goodbye!");
//        }
//
//        scanner.close();
//    }
//}
