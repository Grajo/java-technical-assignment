public interface ProductInterface {
    
    private final PricingStrategy pricingStrategy;

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }
}