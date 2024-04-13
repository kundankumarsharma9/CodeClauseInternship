/* e E-commerce Shopping Cart that implemented secure payment processing,
user authentication, and product recommendation using Java, OOP principles */

import java.util.ArrayList;
import java.util.List;

// Product class representing individual products in the store
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and setters for product properties
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// User class representing registered users of the system
class User {
    private String username;
    private String password;
    // Other user details like name, email, etc. can be added here

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to authenticate user
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

// Shopping cart class representing the cart where users can add/remove products
class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    // Method to add product to cart
    public void addProduct(Product product) {
        items.add(product);
    }

    // Method to remove product from cart
    public void removeProduct(Product product) {
        items.remove(product);
    }

    // Method to calculate total price of items in the cart
    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

// PaymentProcessor class handling secure payment processing
class PaymentProcessor {
    public boolean processPayment(double amount, String cardNumber, String expiryDate, int cvv) {
        // Implementation of secure payment processing logic
        return true; // Placeholder for success
    }
}

// ProductRecommendation class providing recommendations based on user's shopping history
class ProductRecommendation {
    public List<Product> recommendProducts(User user) {
        // Implementation of product recommendation logic based on user's history
        return new ArrayList<>(); // Placeholder for recommendations
    }
}

// Main class demonstrating usage of the e-commerce system
public class Main {
    public static void main(String[] args) {
        // Sample usage of the e-commerce system
        Product laptop = new Product(1, "Laptop", 999.99);
        Product phone = new Product(2, "Smartphone", 599.99);

        User user = new User("username", "password");
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(laptop);
        cart.addProduct(phone);

        double totalPrice = cart.calculateTotal();

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        boolean paymentStatus = paymentProcessor.processPayment(totalPrice, "1234 5678 9012 3456", "12/25", 123);

        if (paymentStatus) {
            System.out.println("Payment successful!");
            // Provide product recommendations to the user
            ProductRecommendation productRecommendation = new ProductRecommendation();
            List<Product> recommendations = productRecommendation.recommendProducts(user);
            System.out.println("Recommended products: " + recommendations);
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}
