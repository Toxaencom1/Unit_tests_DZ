package com.taxah.unit_test.DZ1.Shop;


import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop() {
        this.products = new ArrayList<>();
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов

    /**
     * Sorts the products in the shop by price in ascending order.
     *
     * @return A list of products sorted by price.
     */
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        return products.stream().sorted(new PriceComparator()).toList();
    }

    // Метод должен вернуть самый дорогой продукт

    /**
     * Retrieves the most expensive product in the shop.
     *
     * @return The most expensive product in the shop, or null if the shop is empty.
     */
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        return products.stream().max(new PriceComparator()).orElse(null);
    }
}
