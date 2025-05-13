package Ecommerce;

public class Product {
    public String name;
    public double price;
    public int productId;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
