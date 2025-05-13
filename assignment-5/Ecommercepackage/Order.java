package Ecommerce;

public class Order {
    public Product product;
    public Customer customer;
    public int quantity;

    public Order(Product product, Customer customer, int quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public void placeOrder() {
        System.out.println("\nPlacing Order...");
        customer.displayCustomer();
        product.displayDetails();
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: $" + calculateTotal());
    }

    public double calculateTotal() {
        return product.getPrice() * quantity;
    }
}
