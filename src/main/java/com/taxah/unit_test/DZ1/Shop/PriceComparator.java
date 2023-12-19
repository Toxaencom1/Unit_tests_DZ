package com.taxah.unit_test.DZ1.Shop;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getCost() - o2.getCost();
    }
}
