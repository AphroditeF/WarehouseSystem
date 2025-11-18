import java.io.*;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

void main() {
        int choice;
        Scanner scanner=new Scanner(System.in);

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Προσθήκη προϊόντος");
            System.out.println("2. Αφαίρεση προϊόντος");
            System.out.println("3. Εμφάνιση αποθήκης");
            System.out.println("4. Αναζήτηση προϊόντος");
            System.out.println("5. Ενημέρωση προϊόντος");
            System.out.println("6. Συνολική αξία αποθήκης");
            System.out.println("7. Αποθήκευση σε αρχείο");
            System.out.println("8. Φόρτωση από αρχείο");
            System.out.println("9. Ταξινόμηση προϊόντων (όνομα)");
            System.out.println("0. Έξοδος");
            System.out.print("Επιλογή: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: WarehouseSystem.add_product(); break;
                case 2: WarehouseSystem.remove_product(); break;
                case 3: WarehouseSystem.display_inventory(); break;
                case 4: WarehouseSystem.search_product(); break;
                case 5: WarehouseSystem.update_product(); break;
                case 6: WarehouseSystem.calculate_total_value(); break;
                case 7: WarehouseSystem.save_to_file(); break;
                case 8: WarehouseSystem.load_from_file(); break;
                case 9: WarehouseSystem.sort_products_by_name(); break;
                case 0: System.out.println("Αντίο!"); break;
                default: System.out.println("Λάθος επιλογή!"); break;
            }

        } while (choice != 0);
    }




