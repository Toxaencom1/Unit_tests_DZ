package com.taxah.unit_test.DZ1.Shop;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * The ShopTest class contains tests to verify the functionality of the Shop class.
 * It includes tests for the correct storage of products, the accuracy of the getMostExpensiveProduct method,
 * and the correctness of the sortProductsByPrice method.
 */
public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
   (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        Shop shop = new Shop();
        List<Product> shopProducts = shop.getProducts();
        shopProducts.add(new Product("Bread", 150));
        shopProducts.add(new Product("Butter", 550));
        shopProducts.add(new Product("Salt", 350));

        try {

// 1. Write tests to verify that the shop stores the correct list of products
// (correct number of products, correct contents of the cart).

            assertThat(shopProducts)
                    .hasOnlyElementsOfType(Product.class)
                    .withFailMessage("The contents of the product cart are not valid")
                    .isNotEmpty()
                    .hasSizeGreaterThanOrEqualTo(1);

// 2. Write tests to check the correctness of the getMostExpensiveProduct method.

            Product maxPriceProduct = shopProducts.stream().max(new PriceComparator()).orElse(null);
            assertThat(shop.getMostExpensiveProduct())
                    .isNotNull()
                    .withFailMessage("The getMostExpensiveProduct method is fail")
                    .isEqualTo(maxPriceProduct);

// 3. Write tests to check the correctness of the sortProductsByPrice method (check the correctness of sorting).

            assertThat(shopProducts).isNotEmpty();
            shopProducts = shop.sortProductsByPrice();
            for (int i = 0; i < shopProducts.size() - 1; i++) {
                assertThat(shopProducts.get(i).getCost())
                        .withFailMessage("The sortProductsByPrice method is fail")
                        .isLessThan(shopProducts.get(i + 1).getCost());
            }
            System.out.println("All is ok");

        } catch (AssertionError e) {
            System.err.print("Something wrong: ");
            e.printStackTrace();
        }
    }
}
