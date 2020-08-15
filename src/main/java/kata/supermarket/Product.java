package kata.supermarket;

import java.math.BigDecimal;

public class Product implements ProductInterface {

    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        super.pricingStrategy = new NoApplicableDiscount();
    }

    public Product(final BigDecimal pricePerUnit, final PricingStrategy pricingStrategy) {
        this.pricePerUnit = pricePerUnit;
        super.pricingStrategy = pricingStrategy;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    public Item multipleOf(int numOfItems) {
        return new ItemByUnit(this, numOfItems);
    }
}
