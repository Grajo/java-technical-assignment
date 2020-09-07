package kata.supermarket.pricing;

import java.math.BigDecimal;
import kata.supermarket.pricing.PricingStrategy;

public class NoApplicableDiscount implements PricingStrategy {
    
    public NoApplicableDiscount() {}

    public BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        System.out.println("NAD accessed");
        return BigDecimal.ZERO;
    }
}