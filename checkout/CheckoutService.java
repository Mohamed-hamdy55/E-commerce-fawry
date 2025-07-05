package checkout;

import cart.Cart;
import customer.Customer;
import product.Product;
import product.IShippableItem;
import shipping.ShippingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutService {
    private final ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        double subtotal = 0;
        List<IShippableItem> itemsToShip = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();

            if (product.getQuantity() < qty) {
                throw new IllegalStateException(product.getName() + " is out of stock");
            }
            if (product.isExpired()) {
                throw new IllegalStateException(product.getName() + " is expired");
            }

            subtotal += product.getPrice() * qty;

            if (product.isShippable()) {
                for (int i = 0; i < qty; i++) {
                    itemsToShip.add((IShippableItem) product);
                }
            }
        }

        double shipping = shippingService.ship(itemsToShip);
        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            throw new IllegalStateException("Insufficient balance");
        }

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }

        customer.deduct(total);

        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            System.out.printf("%dx %s %.0f\\n", entry.getValue(), entry.getKey().getName(), entry.getKey().getPrice());
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shipping);
        System.out.printf("Amount %.0f\n", total);
        System.out.printf("Remaining Balance: %.0f\n", customer.getBalance());

        cart.clear();
    }
}
