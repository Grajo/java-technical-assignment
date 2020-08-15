public class TwoForOneDiscount implements PricingStrategy {
    
    BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        return BigDecimal.ZERO;
    }
}