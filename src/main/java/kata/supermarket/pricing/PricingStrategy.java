package kata.supermarket.pricing;

import java.math.BigDecimal;

public interface PricingStrategy {
    
    BigDecimal getTotalDiscount(BigDecimal price, int numOfItems);

}