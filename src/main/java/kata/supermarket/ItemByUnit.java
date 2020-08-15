package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final Product product;
    private int numOfItems = 1; // 1 by default

    ItemByUnit(final Product product) {
        this.product = product;
    }

    ItemByUnit(final Product product, int numOfItems) {
        this.product = product;
        this.numOfItems = numOfItems;
    }

    public BigDecimal price() {
        return product.pricePerUnit().multiply(BigDecimal.valueOf(getNumOfItems()));
    }

    public BigDecimal applyDiscount() {
        return product.getPricingStrategy().getTotalDiscount(product.pricePerUnit(), getNumOfItems());
    }

    public int getNumOfItems() {
        return this.numOfItems;
    }
}
