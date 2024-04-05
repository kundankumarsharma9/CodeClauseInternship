import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Product class to hold product details
class Product {
    String id;
    String name;
    double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " - " + name + " $" + price;
    }
}

// ShoppingCart class to manage the shopping cart
class ShoppingCart {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.name + " has been added to the cart.");
    }

    public void removeProduct(String productId) {
        products.removeIf(product -> product.id.equals(productId));
        System.out.println("Product has been removed from the cart.");
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }

    public void checkout() {
        System.out.println("Checkout - Total: $" + calculateTotal());
        // Payment and order confirmation logic can be added here
        System.out.println("Thank you for your purchase!");
    }
}

// Main class to run the console application
public class ECommerceSystem {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        // Sample products
        products.add(new Product("P1", "Product 1", 10.00));
        products.add(new Product("P2", "Product 2", 15.50));
        products.add(new Product("P3", "Product 3", 20.75));

        boolean running = true;
        while (running) {
            System.out.println("Available products:");
            for (Product product : products) {
                System.out.println(product);
            }

            System.out.println("Options: 1) Add to Cart 2) Remove from Cart 3) Checkout 4) Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter product ID to add to cart: ");
                    String addId = scanner.next();
                    products.stream().filter(product -> product.id.equals(addId))
                            .findFirst().ifPresent(cart::addProduct);
                    break;
                case 2:
                    System.out.print("Enter product ID to remove from cart: ");
                    String removeId = scanner.next();
                    cart.removeProduct(removeId);
                    break;
                case 3:
                    cart.checkout();
                    running = false; // Exiting after checkout
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }
}
