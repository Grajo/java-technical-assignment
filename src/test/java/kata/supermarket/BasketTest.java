package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import kata.supermarket.pricing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight(),
                twoForOneDiscount(),
                multipleItemsWithSomeTwoForOneDiscount(),
                threeForTwoDiscount(),
                multipleItemsWithSomeThreeForTwoDiscount(),
                multipleItemWithDifferentApplicableDiscounts(),
                halfPriceWeightDiscount()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49")).oneOf();
    }

    private static Item aPackOfDigestives() {
        return new Product(new BigDecimal("1.55")).oneOf();
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }


    /**Added new methods to test the discount functionality */

    private static Item multiplePackOfTomatoes(PricingStrategy discount, int numOfPacks) {
        return new Product(new BigDecimal(".55"), discount).multipleOf(numOfPacks);
    }
    
    //2x1 test
    private static Arguments twoForOneDiscount() {
        return Arguments.of("2x1 Discount ", "1.10",
                Arrays.asList( multiplePackOfTomatoes(new TwoForOneDiscount(), 3) ));
    }

    private static Arguments multipleItemsWithSomeTwoForOneDiscount() {
        return Arguments.of("2x1 Discount ", "3.14",
                Arrays.asList(multiplePackOfTomatoes(new TwoForOneDiscount(), 3), aPackOfDigestives(), aPintOfMilk() ));
    }

    //3x2 test
    private static Arguments threeForTwoDiscount() {
        return Arguments.of("3x2 Discount ", "1.10",
                Arrays.asList( multiplePackOfTomatoes(new ThreeForTwoDiscount(), 3) ));
    }

    private static Arguments multipleItemsWithSomeThreeForTwoDiscount() {
        return Arguments.of("3x2 Discount ", "3.14",
                Arrays.asList( multiplePackOfTomatoes(new ThreeForTwoDiscount(), 3), aPackOfDigestives(), aPintOfMilk() ));
    }

    private static Item multiplePackOfBeans(PricingStrategy discount, int numOfPacks) {
        return new Product(new BigDecimal(".25"), discount).multipleOf(numOfPacks);
    }

    //basket that has items with multiple discounts 
    private static Arguments multipleItemWithDifferentApplicableDiscounts() {
        return Arguments.of("3x2 Discount on tomatoes, 2x1 Discount on beans", "1.35",
                Arrays.asList( multiplePackOfTomatoes(new ThreeForTwoDiscount(), 3), multiplePackOfBeans(new TwoForOneDiscount(), 2) ));
    }

    private static WeighedProduct aKiloOfCarrots(PricingStrategy discount) {
        return new WeighedProduct(new BigDecimal("1.00"), discount);
    }

    private static Item aKOfCarrots(PricingStrategy discount) {
        return aKiloOfCarrots(discount).weighing(new BigDecimal("1"));
    }

    private static Arguments halfPriceWeightDiscount() {
        return Arguments.of("half price discount when buying 1 kilo","0.50",
                Arrays.asList(aKOfCarrots(new HalfPriceForWeightProductDiscount())));

    }
}