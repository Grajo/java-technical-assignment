public class TwoForOnePound implements PricingStrategy {
    
    BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        return BigDecimal.ZERO;
    }
}