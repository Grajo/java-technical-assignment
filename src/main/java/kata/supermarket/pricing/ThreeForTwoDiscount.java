public class ThreeForTwoDiscount implements PricingStrategy {
    
    public BigDecimal getTotalDiscount(BigDecimal price, int numOfItems) {
        if (numOfItems < 3) {
            return BigDecimal.ZERO;
        }

        return BigDecimal.valueOf( numOfItems/3 ).multiply( price );
    }
}