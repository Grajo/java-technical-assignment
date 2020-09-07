package kata.supermarket;

import java.math.BigDecimal;
import kata.supermarket.pricing.HalfPriceForWeightProductDiscount;
import java.lang.*;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal applyDiscount() {
        System.out.println("discount functionality, Ps:"+product.getPricingStrategy()+", FractionalPart: " + this.weightInKilos.remainder(BigDecimal.ONE));
        
        if (product.getPricingStrategy() instanceof HalfPriceForWeightProductDiscount) {
            if (this.weightInKilos.remainder(BigDecimal.ONE).toString() != "0") {
                return product.getPricingStrategy().getTotalDefaultDiscountForWeightedProducts(product.pricePerKilo(), this.weightInKilos );
            }
            
            return product.getPricingStrategy().getTotalDiscount(product.pricePerKilo(), this.weightInKilos.intValue() );
        }

        return BigDecimal.ZERO;
        
    }
}
