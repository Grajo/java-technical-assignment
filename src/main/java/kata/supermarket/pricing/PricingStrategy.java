package kata.supermarket.pricing;

import java.math.BigDecimal;

public interface PricingStrategy {
    
    BigDecimal getTotalDiscount(BigDecimal price, int numOfItems);

    default BigDecimal getTotalDefaultDiscountForWeightedProducts(BigDecimal price, BigDecimal numOfKilos ){
        return numOfKilos.multiply( price ).divide(new BigDecimal("2"));
    }


}