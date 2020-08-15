public class NoApplicableDiscount implements PricingStrategy {
    
    public BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        return BigDecimal.ZERO;
    }
}