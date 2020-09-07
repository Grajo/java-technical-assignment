package kata.supermarket.pricing;
import java.math.BigDecimal;

public class HalfPriceForWeightProductDiscount implements PricingStrategy {
    

    public HalfPriceForWeightProductDiscount() {}

    public BigDecimal getTotalDiscount(BigDecimal price, int numOfKilos) {
        System.out.println("HPF accessed");
        return  BigDecimal.valueOf( numOfKilos ).multiply( price ).divide(new BigDecimal("2"));
    }
}