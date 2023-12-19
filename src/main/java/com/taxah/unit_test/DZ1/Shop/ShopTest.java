package com.taxah.unit_test.DZ1.Shop;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
        shopProducts.add(new Product("Bread",150));
        shopProducts.add(new Product("Butter",550));
        shopProducts.add(new Product("Salt",350));

//   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).

        assertThat(shopProducts)
                .hasOnlyElementsOfType(Product.class)
                .withFailMessage("The contents of the product cart are not valid")
                .isNotEmpty()
                .hasSizeGreaterThan(0);

//   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.

        shopProducts = shop.sortProductsByPrice();
        assertThat(shop.getMostExpensiveProduct()).isNotNull();
        Product maxPriceProduct = shopProducts.stream().max(new PriceComparator()).orElse(null);
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(maxPriceProduct);

//   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
        assertThat(shopProducts).isNotEmpty();
        shopProducts = shop.sortProductsByPrice();
        for (int i = 0; i < shopProducts.size()-1; i++) {
            assertThat(shopProducts.get(i).getCost()).isLessThan(shopProducts.get(i+1).getCost());
        }
        System.out.println("All is ok");
    }
}
