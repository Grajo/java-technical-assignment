package kata.supermarket.pricing;

import java.math.BigDecimal;
import kata.supermarket.pricing.PricingStrategy;

public class ThreeForTwoDiscount implements PricingStrategy {
    
    public ThreeForTwoDiscount() {}

    public BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        if (numOfItems < 3) {
            return BigDecimal.ZERO;
        }

        return BigDecimal.valueOf( numOfItems/3 ).multiply( price );
    }
}