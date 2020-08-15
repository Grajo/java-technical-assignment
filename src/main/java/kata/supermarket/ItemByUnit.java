package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final Product product;
    private final int numOfItems = 1; // 1 by default

    ItemByUnit(final Product product) {
        this.product = product;
    }

    ItemByUnit(final Product product, int numOfItems) {
        this.product = product;
        this.numOfItems = numOfItems;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    public BigDecimal applyDiscount() {
        return product.getPricingStrategy().getTotalDiscount(product.pricePerUnit(), this.numOfItems);
    }
}
