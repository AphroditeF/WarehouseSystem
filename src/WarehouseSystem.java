import java.io.*;
import java.util.*;

public class WarehouseSystem {
    private static List<Product> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    private static Product find_product_by_id(int id) {
        for (Product p : inventory) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }


    public static void add_product() {
        System.out.print("Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (find_product_by_id(id) != null) {
            System.out.println("Product already exists!");
            return;
        }

        System.out.print("Product name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        inventory.add(new Product(id, name, price, quantity));
        System.out.println("Product added!");
    }

    public static void remove_product() {
        System.out.print("Product ID to remove: ");
        int id = scanner.nextInt();

        Product p = find_product_by_id(id);
        if (p == null) {
            System.out.println("Product not found!");
            return;
        }

        inventory.remove(p);
        System.out.println("Product removed.");
    }

    public static void display_inventory() {
        System.out.println("\n--- INVENTORY ---");
        for (Product p : inventory)
            System.out.println(p);
        System.out.println("-----------------\n");
    }

    public static void search_product() {
        scanner.nextLine();
        System.out.print("Search by name: ");
        String term = scanner.nextLine().toLowerCase();

        for (Product p : inventory)
            if (p.getName().toLowerCase().contains(term))
                System.out.println(p);
    }

    public static void update_product() {
        System.out.print("Product ID to update: ");
        int id = scanner.nextInt();

        Product p = find_product_by_id(id);
        if (p == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("New price: ");
        double newPrice = scanner.nextDouble();

        System.out.print("New quantity: ");
        int newQuantity = scanner.nextInt();

        p.setPrice(newPrice);
        p.setQuantity(newQuantity);

        System.out.println("Product updated.");
    }

    public static void calculate_total_value() {
        double total = 0;
        for (Product p : inventory)
            total += p.getPrice() * p.getQuantity();

        System.out.println("Total inventory value: " + total + "€");
    }

    public static void save_to_file() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("inventory.txt"))) {
            for (Product p : inventory)
                writer.println(p.getId() + ";" + p.getName() + ";" + p.getPrice() + ";" + p.getQuantity());

            System.out.println("Saved to file!");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static void load_from_file() {
        try (BufferedReader br = new BufferedReader(new FileReader("inventory.txt"))) {
            inventory.clear();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);

                inventory.add(new Product(id, name, price, quantity));
            }

            System.out.println("Loaded from file!");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public static void sort_products_by_name() {
        List<String> myList = new ArrayList<>();

        for (Product p : inventory)
            myList.add(p.getName().toLowerCase());

        myList = myList.stream().sorted().toList();

        System.out.println("Products sorted by name!");
        for (String i : myList)
            System.out.println(i);

    }


}