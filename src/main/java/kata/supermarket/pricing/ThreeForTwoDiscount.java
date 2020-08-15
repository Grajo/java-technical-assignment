public class ThreeForTwoDiscount implements PricingStrategy {
    
    public BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        return BigDecimal.ZERO;
    }
}