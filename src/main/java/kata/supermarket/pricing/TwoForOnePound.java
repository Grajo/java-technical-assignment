package kata.supermarket.pricing;

import java.math.BigDecimal;
import kata.supermarket.pricing.PricingStrategy;

public class TwoForOnePound implements PricingStrategy {

    public TwoForOnePound(){}
    
    public BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        if (numOfItems < 2) {
            return BigDecimal.ZERO;
        }
        
        BigDecimal total = BigDecimal.valueOf( numOfItems/2 ).multiply( price );
        BigDecimal discount = BigDecimal.valueOf( numOfItems/2 );
        return total.subtract(discount);
    }
}