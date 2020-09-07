package kata.supermarket;

import java.math.BigDecimal;

import kata.supermarket.pricing.PricingStrategy;
import kata.supermarket.pricing.NoApplicableDiscount;


public class Product extends NewAbstractProduct {

    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit) {
        super.setPricingStrategy(new NoApplicableDiscount());
        // this.pricingStrategy = new NoApplicableDiscount();
        this.pricePerUnit = pricePerUnit;
    }

    public Product(final BigDecimal pricePerUnit, PricingStrategy pricingStrategy) {
        super.setPricingStrategy(pricingStrategy);
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

}
