package kata.supermarket;

import kata.supermarket.pricing.PricingStrategy;

public abstract class NewAbstractProduct {
    
    private PricingStrategy pricingStrategy;

    public PricingStrategy getPricingStrategy() {
        return this.pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}