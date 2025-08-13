/*
Title: Product Management System using Arrays in Core Java

Problem Statement:
Write a Java program to implement a Product Management System for a small store.
The system should store products in an array and allow the user to:

Add a new product

View all products

Search for a product by ID

Update product details

Delete a product by ID

Exit the program

✅ Requirements
Store up to 100 products (array-based storage).

A Product has:

Product ID (int)

Product Name (String)

Price (double)

Quantity (int)

Menu-driven program.

Validate inputs where necessary.
*/
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void display() {
        System.out.printf("%-10d %-15s %-10.2f %-10d\n", id, name, price, quantity);
    }
}

class ProductManagementSystem {
    static Product[] products = new Product[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Product Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> searchProduct();
                case 4 -> updateProduct();
                case 5 -> deleteProduct();
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }

    // 1. Add Product
    public static void addProduct() {
        if (count >= products.length) {
            System.out.println("Product list is full!");
            return;
        }
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        products[count++] = new Product(id, name, price, qty);
        System.out.println("Product added successfully!");
    }

    // 2. View All Products
    public static void viewProducts() {
        if (count == 0) {
            System.out.println("No products available!");
            return;
        }
        System.out.printf("%-10s %-15s %-10s %-10s\n", "ID", "Name", "Price", "Quantity");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < count; i++) {
            products[i].display();
        }
    }

    // 3. Search Product
    public static void searchProduct() {
        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (products[i].id == id) {
                System.out.println("Product found:");
                products[i].display();
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // 4. Update Product
    public static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (products[i].id == id) {
                sc.nextLine();
                System.out.print("Enter New Name: ");
                products[i].name = sc.nextLine();
                System.out.print("Enter New Price: ");
                products[i].price = sc.nextDouble();
                System.out.print("Enter New Quantity: ");
                products[i].quantity = sc.nextInt();
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // 5. Delete Product
    public static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (products[i].id == id) {
                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[--count] = null;
                System.out.println("Product deleted successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }
}

/*
🛠 Explanation of Operations
Array as Storage → No database, fixed-size array (Product[100]) stores product objects.

Add Product → Append to array until max capacity.

View Products → Loop & display.

Search Product → Linear search by ID.

Update Product → Find ID, replace fields.

Delete Product → Shift elements left after deletion.

Exit → Ends loop.

📊 Test Cases (All Scenarios)
Test Case #	Input	Expected Output
1	Add Product (ID=101, Name="Laptop", Price=55000, Qty=10)	"Product added successfully!"
2	View Products	Displays: 101 Laptop 55000.00 10
3	Search Product (ID=101)	Shows product details
4	Search Product (ID=999)	"Product not found!"
5	Update Product (ID=101, New Name="Gaming Laptop", Price=60000, Qty=8)	"Product updated successfully!"
6	Delete Product (ID=101)	"Product deleted successfully!"
7	Delete Product (ID=101) after already deleted	"Product not found!"
8	View Products after deleting all	"No products available!"
9	Fill up array with 100 products, then try adding 1 more	"Product list is full!"
10	Add multiple products, search each by ID, then delete in reverse order	Should correctly display found products and remove them without error..
*/