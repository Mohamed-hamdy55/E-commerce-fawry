package product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpirableShippableProduct extends Product implements IShippableItem {
    private double weight;
    private LocalDate expireDate;

    public ExpirableShippableProduct(String name, double price, int quantity, double weight, String expireDate) {
        super(name, price, quantity);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.expireDate = LocalDate.parse(expireDate, formatter);
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expireDate);
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }
}
