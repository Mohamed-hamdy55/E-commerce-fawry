package cart;

import product.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private final Map<Product, Integer> items = new LinkedHashMap<>();

    public void add(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough quantity available for " + product.getName());
        }
        items.merge(product, quantity, Integer::sum);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
