package kata.supermarket.pricing;

import java.math.BigDecimal;
import kata.supermarket.pricing.PricingStrategy;

public class TwoForOneDiscount implements PricingStrategy {
    
    public TwoForOneDiscount() {}

    public BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        if (numOfItems < 2) {
            return BigDecimal.ZERO;
        }

        return BigDecimal.valueOf( numOfItems/2 ).multiply( price );
    }
}