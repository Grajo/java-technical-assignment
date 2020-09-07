package kata.supermarket;

import java.math.BigDecimal;
import kata.supermarket.pricing.PricingStrategy;
import kata.supermarket.pricing.NoApplicableDiscount;

public class WeighedProduct extends NewAbstractProduct {

    private final BigDecimal pricePerKilo;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        super.setPricingStrategy(new NoApplicableDiscount());
        this.pricePerKilo = pricePerKilo;
    }

    public WeighedProduct(final BigDecimal pricePerKilo, PricingStrategy pricingStrategy) {
        super.setPricingStrategy(pricingStrategy);
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
