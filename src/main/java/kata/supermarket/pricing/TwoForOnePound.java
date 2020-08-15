public class TwoForOnePound implements PricingStrategy {
    
    BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        if (numOfItems < 2) {
            return BigDecimal.ZERO;
        }
        
        return BigDecimal.valueOf( numOfItems/2 );
    }
}