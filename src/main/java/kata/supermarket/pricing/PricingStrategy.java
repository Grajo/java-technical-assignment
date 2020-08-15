public interface PricingStrategy {
    
    BigDecimal getTotalDiscount(BigDecimal price, int numOfItems);

}