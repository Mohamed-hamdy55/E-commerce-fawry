package shipping;

import java.util.List;

import product.IShippableItem;

public class ShippingService {
    public double ship(List<IShippableItem> items) {
        if (items.isEmpty()) return 0.0;

        final int shipingPrice = 30;

        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (IShippableItem item : items) {
            System.out.printf("- %s %.1fkg\n", item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
        double shippingFee = totalWeight * shipingPrice;
        System.out.println("Shipping fee: " + shippingFee);
        return shippingFee;
    }
}
