import Ecommerce.*;

public class Main{
    public static void main(String[] args) {
        Product product = new Product(111, "Laptop", 1200.00);
        Customer customer = new Customer(1, "sarvesh");

        Order order = new Order(product, customer, 2);
        order.placeOrder();
    }
}
