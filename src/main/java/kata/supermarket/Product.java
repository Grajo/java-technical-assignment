package kata.supermarket;

import java.math.BigDecimal;

import kata.supermarket.pricing.PricingStrategy;
import kata.supermarket.pricing.NoApplicableDiscount;


public class Product {

    private final BigDecimal pricePerUnit;
    private PricingStrategy pricingStrategy;

    public Product(final BigDecimal pricePerUnit) {
        this.pricingStrategy = new NoApplicableDiscount();
        this.pricePerUnit = pricePerUnit;
    }

    public Product(final BigDecimal pricePerUnit, PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
        this.pricePerUnit = pricePerUnit;
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

    public PricingStrategy getPricingStrategy() {
        return this.pricingStrategy;
    }
}
