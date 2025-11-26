import java.util.Scanner;

public class Main {

    static String username = "amg";
    static String password = "1234";



    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            if (login()) {
                homePage();
            }
        }
    }

    public static boolean login() {
        clearConsole();
        System.out.println("                                                                                        AMG");
        System.out.println("+------------------------------------------------------------------------------------------+");
        System.out.println("|                                     LOGIN PAGE                                           |");
        System.out.println("+------------------------------------------------------------------------------------------+");


        while (true) {
            System.out.print("\tUser Name : ");
            String u = input.nextLine();

            if (u.equals(username)) {
                break;
            } else {
                System.out.println("Invalid username. Try again.\n");
            }
        }


        while (true){
            System.out.print("\tPassword  : ");
            String p = input.nextLine();

            if (p.equals(password)) {
                System.out.println("\nLogin successful!\n");
                return true;
            } else {
                System.out.println("Incorrect password. Try again.\n");
                // password repeat karanna, username repeat karanna epa
            }
        }
    }

    public static void homePage() {
        clearConsole();
        while (true) {
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                                   HOME PAGE                                              |");
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.println("[1] Change Credentials                           [2] Supplier Management");
            System.out.println("[3] Stock Management                             [4] Logout");
            System.out.println("[5] Exit");
            System.out.println();
            System.out.print("Choose option: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    credentialManage();
                    break;

                case "2":
                    supplierManagementMenu();
                    break;

                case "3":
                    stockManagementMenu();
                    break;

                case "4":
                    clearConsole();
                    login(); // logout
                    clearConsole();
                    break;

                case "5":
                    clearConsole();
                    System.exit(0);
                default:
                    clearConsole();
                    break;

            }
        }
    }

    public static void credentialManage() {
        clearConsole();

        System.out.println("+------------------------------------------------------------------------------------------+");
        System.out.println("|                               CREDENTIAL MANAGE                                          |");
        System.out.println("+------------------------------------------------------------------------------------------+");
        System.out.println();

        // Username eka harida balanawa
        while (true) {
            System.out.print("Enter current username: ");
            String u = input.nextLine();

            if (u.equals(username)) {
                break;
            }
            System.out.println("Invalid username. Please try again.\n");
        }
        System.out.println("Hey " + username);
        System.out.println();

        // password eka harida balanawa
        while (true) {
            System.out.print("Enter current password: ");
            String p = input.nextLine();
            if (p.equals(password)) {
                break;
            }
            System.out.println("Incorrect password. Please try again.\n");
        }

        System.out.print("Enter new password: ");
        String newPass = input.nextLine();

        password = newPass;
        System.out.println("\nPassword changed successfully!");

        System.out.print("Do you want to go home page (Y/N):");
        String again = input.nextLine().toUpperCase().trim();
        if (again.equals("Y")) {
            clearConsole();
            homePage();
        }
        if (again.equals("N")) {
            clearConsole();
            credentialManage();
        }
    }

    public static void supplierManagementMenu() {
        clearConsole();
        while (true) {
            System.out.println();
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                               SUPPLIER MANAGEMENT                                        |");
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("[1] Add Supplier                      [2] Update Supplier");
            System.out.println("[3] Delete Supplier                   [4] View Suppliers");
            System.out.println("[5] Search Supplier                   [6] Back to Home");
            System.out.println();

            System.out.print("Choose option: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    addSupplier();
                    break;

                case "2":
                    updateSupplier();
                    break;

                case "3":
                    deleteSupplier();
                    break;

                case "4":
                    viewSuppliers();
                    break;

                case "5":
                    searchSupplier();
                    break;

                case "6":
                    clearConsole();
                    homePage();

                default:
                    clearConsole();
                    break;
            }
        }
    }

   // ------------------------------- [1] Add Supplier --------------------------------------------------

    static String[] supplierIds = new String[100];
    static String[] supplierNames = new String[100];
    static int supplierCount = 0;


    // Suplier ID ekak danatamath thiyenawada kiyala check karanawa
    public static int findSupplierIndexById(String id) {
        for (int i = 0; i < supplierCount; i++) {
            if (supplierIds[i].equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void addSupplier() {
        clearConsole();
        while (true) {
            System.out.println();
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                                  ADD SUPPLIER                                            |");
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println();



            String id;

            while (true) {
                System.out.print("Enter Supplier ID: ");
                id = input.nextLine().trim();

                if (findSupplierIndexById(id) != -1) {
                    System.out.println("Invalid! Supplier ID already exists. Please try another.\n");
                } else {
                    break;
                }
            }


            System.out.print("Enter Supplier Name: ");
            String name = input.nextLine();

            supplierIds[supplierCount] = id;
            supplierNames[supplierCount] = name;
            supplierCount++;

            System.out.println("\nSupplier added successfully!");

            System.out.print("Add another supplier? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();

            if (again.equals("Y")) {
                clearConsole();
                addSupplier();
                return;
            }
            if (again.equals("N")) {
                clearConsole();
                return;
            }
        }
    }

    public static void updateSupplier() {
        clearConsole();
        System.out.println("+------------------------------------------------------------------------------------------+");
        System.out.println("|                                 UPDATE SUPPLIER                                          |");
        System.out.println("+------------------------------------------------------------------------------------------+");


        while (true) {

            System.out.print("\nEnter Supplier ID to update: ");
            String id = input.nextLine();

            int index = findSupplierIndexById(id);
            if (index == -1) {
                System.out.println("\nSupplier not found.");
                System.out.print("Do You Want to update another supplier? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    System.out.println("________________________________________________________\n");
                    continue;
                }
                if (again.equals("N")) {
                    clearConsole();
                    supplierManagementMenu();
                    return;
                }
            }

            System.out.print("Enter new Supplier Name: ");
            String newName = input.nextLine();

            supplierNames[index] = newName;

            System.out.println();
            System.out.println("Enter the new  Supplier Name: " + newName);
            System.out.println();

            System.out.println("Supplier updated successfully!");
            System.out.print("Do You Want to update another supplier? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();

            if (again.equals("Y")) {
                clearConsole();
                updateSupplier();
                return;
            }
            if (again.equals("N")) {
                clearConsole();
                supplierManagementMenu();
                return;
            }
        }

    }


    public static void deleteSupplier() {
        clearConsole();
        System.out.println("+------------------------------------------------------------------------------------------+");
        System.out.println("|                                 DELETE SUPPLIER                                          |");
        System.out.println("+------------------------------------------------------------------------------------------+");


        //-------------------------------
        while (true) {
            System.out.print("\nEnter Supplier ID to delete: ");
            String id = input.nextLine();

            int index = findSupplierIndexById(id);
            if (index == -1) {
                System.out.println("\nSupplier not found.");
                System.out.print("Do You Want to delete another supplier? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    System.out.println("________________________________________________________\n");
                    continue;
                }
                if (again.equals("N")) {
                    clearConsole();
                    supplierManagementMenu();
                    return;
                }
            }

            // Shift karanawa arrays left karala
            for (int i = index; i < supplierCount - 1; i++) {
                supplierIds[i] = supplierIds[i + 1];
                supplierNames[i] = supplierNames[i + 1];
            }
            supplierCount--;

            System.out.println("\nSupplier deleted successfully!");
            System.out.print("Do You Want to delete another supplier? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();
            if (again.equals("Y")) {
                clearConsole();
                deleteSupplier();
                return;
            }
            if (again.equals("N")) {
                clearConsole();
                supplierManagementMenu();
                return;
            }
        }
    }


    public static void viewSuppliers() {
        clearConsole();
        while (true) {
            System.out.println();
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                                VIEW SUPPLIERS                                            |");
            System.out.println("+------------------------------------------------------------------------------------------+");

            if (supplierCount == 0) {
                System.out.println("No suppliers added yet.");
                System.out.print("Do You Want to go supplier management menu? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    clearConsole();
                    supplierManagementMenu();
                    return;
                }
                if (again.equals("N")) {
                    clearConsole();
                    continue;
                }

            }

            System.out.println();


            System.out.println("+-------------------------+-------------------------+");
            System.out.println("|   Supplier ID           |   Supplier Name         |");
            System.out.println("+-------------------------+-------------------------+");

            // print suppliers
            for (int i = 0; i < supplierCount; i++) {
                String id = supplierIds[i];
                String name = supplierNames[i];

                // length eka while use karala fix kara
                while (id.length() < 21) {
                    id += " ";
                }
                while (name.length() < 20) {
                    name += " ";
                }
                System.out.println("|    " + id + "|     " + name + "|");
            }
            System.out.println("+-------------------------+-------------------------+");

            System.out.print("\nDo You Want to go supplier management menu? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();
            if (again.equals("Y")) {
                clearConsole();
                supplierManagementMenu();
                return;
            }
            if (again.equals("N")) {
                clearConsole();
                viewSuppliers();
            }
        }

    }



    public static void searchSupplier() {
        clearConsole();
        System.out.println("+------------------------------------------------------------------------------------------+");
        System.out.println("|                                 SEARCH SUPPLIER                                          |");
        System.out.println("+------------------------------------------------------------------------------------------+");

        while (true) {
            System.out.print("\nEnter Supplier ID to search: ");
            String id = input.nextLine();

            int index = findSupplierIndexById(id);
            if (index == -1) {
                System.out.println("\nSupplier not found.");
                System.out.print("Do You Want to search another supplier? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    System.out.println("________________________________________________________\n");
                    continue;
                }
                if (again.equals("N")) {
                    System.out.println("Exiting the Supplier Management Menu.");
                    supplierManagementMenu();
                }
            }

            System.out.println();
            System.out.println("Supplier ID   : " + supplierIds[index]);
            System.out.println("Supplier Name : " + supplierNames[index]);
            System.out.println();

            System.out.print("Do You Want to search another? (Y/N) : ");
            String again = input.nextLine().toUpperCase().trim();
            if (again.equals("Y")) {
                searchSupplier();
            }
            if (again.equals("N")) {
                System.out.println("Exiting the Supplier Management Menu.");
                supplierManagementMenu();
            }
        }

    }




//---------------------------------- STOCK MANAGE ----------------------------------------------------




    // Stock items data
    static String[] itemSid = new String[100];
    static String[] itemCodes = new String[100];
    static String[] itemNames = new String[100];
    static double[] itemPrices = new double[100];
    static String[] itemDescription = new String[100];
    static int[] itemQty = new int[100];
    static int itemCount = 0;


    public static void stockManagementMenu() {
        clearConsole();
        while (true) {
            System.out.println();
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                                 STOCK MANAGEMENT                                         |");
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.println("[1] Manage Item Categories             [2] Add Item");
            System.out.println("[3] Get Item Supplier Wise             [4] View Items");
            System.out.println("[5] Rank Items per Unit Price          [6] Back to Home");
            System.out.println();

            System.out.print("Choose option: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    manageItemCategory();
                    break;

                case "2":
                    addItem();
                    break;

                case "3":
                    getItemSupplierWise();
                    break;

                case "4":
                    viewItems();
                    break;

                case "5":
                    rankItemsPerUnitPrice();
                    break;

                case "6":
                    clearConsole();
                    homePage();
                    break;

                default:
                    clearConsole();
                    break;
            }
        }
    }

    static String[] categoryCodes = new String[100];
    static String[] categoryNames = new String[100];
    static int categoryCount = 0;

    // --------------[1]--------------------------------------------------------------------
    public static void manageItemCategory() {
        clearConsole();
        while (true) {
            System.out.println();
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                               MANAGE ITEM CATEGORY                                       |");
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.println("[1] Add New Category                       [2] Delete Item Category");
            System.out.println("[3] Update Item Catagory                   [4] Stock Management");
            System.out.println();

            System.out.print("Choose option: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    addNewCategory();
                    break;

                case "2":
                    deleteCategory();
                    break;

                case "3":
                    updateCategory();
                    break;

                case "4":
                    clearConsole();
                    stockManagementMenu();
                    break;

                default:
                    clearConsole();
                    break;
            }
        }

    }

    public static int findCategoryIndexByCode(String code) {
        for (int i = 0; i < categoryCount; i++) {
            if (categoryCodes[i].equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public static void addNewCategory() {
        clearConsole();
        while (true) {
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                                 ADD NEW CATEGORY                                         |");
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println();

            String code;

            while (true) {
                System.out.print("Enter Category Code: ");
                code = input.nextLine().trim();

                if (findCategoryIndexByCode(code) != -1) {
                    System.out.println("Category code already exists. Try another.\n");
                } else {
                    break;
                }
            }

            System.out.print("Enter new item Category : ");
            String name = input.nextLine().trim();

            categoryCodes[categoryCount] = code;
            categoryNames[categoryCount] = name;
            categoryCount++;

            System.out.print("\nCategory added successfully!");
            System.out.print(" Do You Want to add another? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();
            if (again.equals("Y")) {
                clearConsole();
                addNewCategory();
                return;
            }
            if (again.equals("N")) {
                System.out.println("Exiting the Item Category Management Menu.");
                clearConsole();
                return;
            }
        }
    }


    public static void deleteCategory() {
        clearConsole();

        System.out.println("+------------------------------------------------------------------------------------------+");
        System.out.println("|                                DELETE ITEM CATEGORY                                      |");
        System.out.println("+------------------------------------------------------------------------------------------+");

        while (true) {
            System.out.print("\nEnter Category Code to delete: ");
            String code = input.nextLine();

            int index = findCategoryIndexByCode(code);
            if (index == -1) {
                System.out.println("\nCategory not found.");

                System.out.print("Do You Want to delete another Category? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    System.out.println("________________________________________________________\n");
                    continue;
                }
                if (again.equals("N")) {
                    System.out.println("Exiting the Category Manage Menu.");
                    manageItemCategory();
                }
            }

            // Shift arrays to delete
            for (int i = index; i < categoryCount - 1; i++) {
                categoryCodes[i] = categoryCodes[i + 1];
                categoryNames[i] = categoryNames[i + 1];
            }
            categoryCount--;

            System.out.println("\nCategory deleted successfully!");
            System.out.print("Do You Want to delete another Category? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();
            if (again.equals("Y")) {
                deleteCategory();
            }
            if (again.equals("N")) {
                System.out.println("Exiting the Category Manage Menu.");
                manageItemCategory();
            }
        }
    }

    public static void updateCategory() {
        clearConsole();
        System.out.println("+------------------------------------------------------------------------------------------+");
        System.out.println("|                                UPDATE ITEM CATEGORY                                      |");
        System.out.println("+------------------------------------------------------------------------------------------+");

        while (true) {
            System.out.print("Enter Category Code to update: ");
            String code = input.nextLine();

            int index = findCategoryIndexByCode(code);
            if (index == -1) {
                System.out.println("\nCategory not found.");
                System.out.print("Do You Want to update another Category? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    System.out.println("________________________________________________________\n");
                    continue;
                }
                if (again.equals("N")) {
                    System.out.println("Exiting the Category Manage Menu.");
                    manageItemCategory();
                }
            }

            System.out.print("\nEnter new Category Name: ");
            String newName = input.nextLine();

            categoryNames[index] = newName;

            System.out.println();
            System.out.println("Enter the new  Category Name: " + newName);
            System.out.println();

            System.out.println("Category updated successfully!");
            System.out.print("Do You Want to update another Category? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();

            if (again.equals("Y")) {
                updateCategory();
            }
            if (again.equals("N")) {
                System.out.println("Exiting the Category Manage Menu.");
                manageItemCategory();
            }
        }
    }





//----------[2]------------------------------------------------------------------------

    public static int findItemIndexByCode(String code) {
        for (int i = 0; i < itemCount; i++) {
            if (itemCodes[i].equals(code)) {
                return i;
            }
        }
        return -1;
    }


    public static void addItem() {
        clearConsole();
        while (true) {
            System.out.println();
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                                     ADD ITEM                                             |");
            System.out.println("+------------------------------------------------------------------------------------------+");


            if (supplierCount == 0) {
                System.out.println("OOPS! it sem that you don't have any suppliers in the system.");
                System.out.print("Do yo want to add a new supplier? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    addSupplier();
                    return;
                }
                if (again.equals("N")) {
                    System.out.println("Exiting the Category Management Menu.");
                    stockManagementMenu();
                    return;
                }
            }
//----------------
            String code;
            while (true) {
                System.out.print("Enter Item Code: ");
                code = input.nextLine().trim();

                if (findItemIndexByCode(code) != -1) {
                    System.out.println("Item code already exists. Try another.\n");
                } else {
                    break;
                }
            }



            System.out.println("\nSelect Supplier for this Item:");
            System.out.println ("+--------------------+-----------------------+-------------------------------+");
            System.out.println ("|          #         |       SUPPLIER ID     |        SUPPLIER NAME          |");
            System.out.println ("+--------------------+-----------------------+-------------------------------+");
            for (int i = 0; i < supplierCount; i++) {
                System.out.printf("| %-18d | %-21s | %-29s |\n",  (i + 1) , supplierIds[i], supplierNames[i]);
            }
            System.out.println("+---------------------+-----------------------+-------------------------------+");




            if (categoryCount == 0){
                System.out.println("OOPS! it sem that you don't have any Categorys in the system.");
                System.out.print("Do yo want to add a new Category? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    clearConsole();
                    addNewCategory();
                    return;
                }
                if (again.equals("N")) {
                    System.out.println("Exiting the Category Management Menu.");
                    clearConsole();
                    stockManagementMenu();
                    return;
                }
            }

            int supplierIndex;
            while (true) {
                System.out.print("\nEnter Supplier Number > ");
                try {
                    supplierIndex = Integer.parseInt(input.nextLine().trim()) - 1;
                    if (supplierIndex < 0 || supplierIndex >= supplierCount) {
                        System.out.println("Invalid supplier number. Try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            System.out.println("\n\nItem Categories : ");
            System.out.println ("+-------+------------------------------+");
            System.out.println ("|   #   |   CATEGORY NAME              |");
            System.out.println ("+-------+------------------------------+");

            for (int i = 0; i < categoryCount; i++) {
                System.out.printf("| %-5d | %-28s |\n",  (i + 1) , categoryNames[i]);
            }
            System.out.println("+-------+------------------------------+");





            int categoryIndex;
            while (true) {
                System.out.print("\nEnter Item Category Number > ");
                try {
                    categoryIndex = Integer.parseInt(input.nextLine().trim()) - 1;
                    if (categoryIndex < 0 || categoryIndex >= categoryCount) {
                        System.out.println("Invalid category number. Try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            System.out.print("\n\nDescription : ");
            String description = input.next();
            System.out.println();

            System.out.print("Unit Price  : ");
            double price = input.nextDouble();
            System.out.println();

            System.out.print("Qty on hand : ");
            int qty = input.nextInt();


            input.nextLine();


            // Save
            itemSid[itemCount] = supplierIds[supplierIndex];
            itemCodes[itemCount] = code;
            itemDescription[itemCount] = description;
            itemPrices[itemCount] = price;
            itemQty[itemCount] = qty;
            itemNames[itemCount] = categoryNames[categoryIndex];

            itemCount++;

            System.out.println("\nItem added successfully!");
            System.out.print("Do You Want to add another Item? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();
            if (again.equals("Y")) {
                clearConsole();
                addItem();
                return;
            }
            if (again.equals("N")) {
                clearConsole();
                stockManagementMenu();
                return;
            }
        }
    }


    public static void viewItems() {
        clearConsole();
        while (true) {
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                                    VIEW ITEMS                                            |");
            System.out.println("+------------------------------------------------------------------------------------------+");


            if (itemCount == 0) {
                System.out.println("\nNo items added yet.");
                System.out.print("Do You Want to go stock management menu? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    clearConsole();
                    stockManagementMenu();
                    return;
                }
                if (again.equals("N")) {
                    clearConsole();
                    continue;
                }
            }

            System.out.println();

            for(int i = 0; i <categoryCount ; i++) {
                String category = categoryNames[i];

                System.out.println("\nCategory: " + category);

                System.out.println("+---------+-------------+------------------+-------------+----------+");
                System.out.println("|    SID  |      CODE   |       DESC       |     PRICE   |    QTY   |");
                System.out.println("+---------+-------------+------------------+-------------+----------+");

                boolean found = false;

                for(int j = 0; j < itemCount; j++) {
                    if (itemNames[j].equals(category)) {
                        found = true;
                        System.out.printf("| %-7s | %-11s | %-16s | %-11s | %-8s |\n", itemSid[j], itemCodes[j], itemDescription[j], itemPrices[j], itemQty[j]);

                    }
                }

                if (!found) {
                    System.out.println("|          No items available in this category.                     |");
                }
                System.out.println("+---------+-------------+------------------+-------------+----------+");
            }
            System.out.println();


            System.out.print("Do You Want to view another category? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();
            if (again.equals("Y")) {
                clearConsole();
                continue;
            }
            if (again.equals("N")) {
                clearConsole();
                stockManagementMenu();
                return;
            }

        }
    }





    public static void getItemSupplierWise() {
        clearConsole();
        while (true) {
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                             VIEW ITEMS - SUPPLIER WISE                                   |");
            System.out.println("+------------------------------------------------------------------------------------------+");

            if (supplierCount == 0) {
                System.out.println("No suppliers available.");
                System.out.print("Do You Want to view another supplier? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    clearConsole();
                    continue;
                }
                if (again.equals("N")) {
                    clearConsole();
                    stockManagementMenu();
                    return;
                }
            }


            System.out.println("\nSelect Supplier");
            System.out.println("+-------+---------------------+---------------------------+");
            System.out.println("|  No.  |     SUPPLIER ID     |      SUPPLIER NAME        |");
            System.out.println("+-------+---------------------+---------------------------+");

            for (int i = 0; i < supplierCount; i++) {
                System.out.printf("| %-5d | %-19s | %-25s |\n", i + 1, supplierIds[i], supplierNames[i]);
            }
            System.out.println("+-------+---------------------+---------------------------+");

            System.out.print("\nEnter Supplier Number: ");
            int supplierIndex = input.nextInt() - 1;
            input.nextLine();

            if (supplierIndex < 0 || supplierIndex >= supplierCount) {
                System.out.println("Invalid supplier number. Try again.\n");
                continue;
            }

            String selectedSupplierId = supplierIds[supplierIndex];
            String selectedSupplierName = supplierNames[supplierIndex];

            System.out.println("\nItems for Supplier: " + selectedSupplierName + " (ID: " + selectedSupplierId + ")");
            System.out.println("+-----------------+----------------------+------------------------+---------------+------------------+");
            System.out.println("|  ITEM CODE      |   DESCRIPTION        |     UNIT PRICE         |     QTY       |   CATEGORY       |");
            System.out.println("+-----------------+----------------------+------------------------+---------------+------------------+");


            boolean found = false;

            for (int i = 0; i < itemCount; i++) {
                if (itemSid[i].equals(selectedSupplierId)) {
                    found = true;
                    System.out.printf("| %-15s | %-20s | %-22.2f | %-13d | %-16s |\n",
                            itemCodes[i], itemDescription[i], itemPrices[i], itemQty[i], itemNames[i]);
                }
            }

            if (!found) {
                System.out.println("|                                No items found for this supplier.                                   |");
            }

            System.out.println("+-----------------+----------------------+------------------------+---------------+------------------+");



            System.out.print("\nDo you want to view another supplier? (Y/N): ");
            String again = input.nextLine().trim().toUpperCase();

            if (again.equals("Y")) {
                clearConsole();
                getItemSupplierWise();
                return;
            }
            if (again.equals("N")) {
                clearConsole();
                stockManagementMenu();
                return;
            }
        }
    }










    public static void rankItemsPerUnitPrice() {
        clearConsole();

        while (true) {
            System.out.println("+------------------------------------------------------------------------------------------+");
            System.out.println("|                          RANKED ITEMS PER UNIT PRICE                                     |");
            System.out.println("+------------------------------------------------------------------------------------------+");

            if (itemCount == 0) {
                System.out.println("No items to rank.");
                System.out.print("Do You Want to rank another item? (Y/N): ");
                String again = input.nextLine().toUpperCase().trim();
                if (again.equals("Y")) {
                    clearConsole();
                    continue;
                }
                if (again.equals("N")) {
                    clearConsole();
                    stockManagementMenu();
                    return;
                }
            }

            // tempary array tikak hadagannawa sort karanna
            String[] sidCopy = new String[itemCount];//try
            String[] codesCopy = new String[itemCount];
            String[] desCopy = new String[itemCount];//try
            double[] pricesCopy = new double[itemCount];
            int[] qtyCopy = new int[itemCount];//try
            String[] namesCopy = new String[itemCount];

            for (int i = 0; i < itemCount; i++) {
                sidCopy[i] = itemSid[i];//try
                codesCopy[i] = itemCodes[i];
                desCopy[i] = itemDescription[i];//try
                pricesCopy[i] = itemPrices[i];
                qtyCopy[i] = itemQty[i];//try
                namesCopy[i] = categoryNames[i];

            }


            for (int i = 0; i < itemCount - 1; i++) {
                for (int j = 0; j < itemCount - i - 1; j++) {
                    if (pricesCopy[j] < pricesCopy[j + 1]) {
                        // swap prices

                        double tempPrice = pricesCopy[j];
                        pricesCopy[j] = pricesCopy[j + 1];
                        pricesCopy[j + 1] = tempPrice;

                        // swap codes
                        String tempCode = codesCopy[j];
                        codesCopy[j] = codesCopy[j + 1];
                        codesCopy[j + 1] = tempCode;

                        // swap sid
                        String tmpSid = sidCopy[j];
                        sidCopy[j] = sidCopy[j + 1];
                        sidCopy[j + 1] = tmpSid;

                        // swap description
                        String tmpDesc = desCopy[j];
                        desCopy[j] = desCopy[j + 1];
                        desCopy[j + 1] = tmpDesc;

                        // swap qty
                        int tmpQty = qtyCopy[j];
                        qtyCopy[j] = qtyCopy[j + 1];
                        qtyCopy[j + 1] = tmpQty;

                        // swap category names
                        String tempName = namesCopy[j];
                        namesCopy[j] = namesCopy[j + 1];
                        namesCopy[j + 1] = tempName;
                    }
                }
            }

            System.out.println("\n--- Items Ranked by Unit Price ---");
            System.out.println("+------------+----------+-----------------+-------------+---------+----------------------+");
            System.out.println("|     SID    |   CODE   |   DESCIPTION    |    PRICE    |   QTY   |    CATEGORY_NAME     |");
            System.out.println("+------------+----------+-----------------+-------------+---------+----------------------+");
            for (int i = 0; i < itemCount; i++) {
                System.out.printf("| %-10s | %-8s | %-15s | %11.2f | %7d | %-20s |\n", sidCopy[i], codesCopy[i], desCopy[i], pricesCopy[i], qtyCopy[i], namesCopy[i]);
            }
            System.out.println("+------------+----------+-----------------+-------------+---------+----------------------+");

            System.out.print("\nDo you want to go stock manage page? (Y/N): ");
            String again = input.nextLine().toUpperCase().trim();

            if (again.equals("Y")) {
                clearConsole();
                stockManagementMenu();
            }
            if (again.equals("N")) {
                clearConsole();
                rankItemsPerUnitPrice();
            }
        }

    }



    // Console Clear ------------------------------------------------
    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
