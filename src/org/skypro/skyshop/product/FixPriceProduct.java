package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 35;

        public FixPriceProduct(String productName) {
            super(productName);
        }

        @Override
        public int getProductCost() {
            return FIXED_PRICE;
        }

        @Override
        public String toString() {
            return getProductName() + ": Фиксированная цена " + FIXED_PRICE;
        }

    @Override
    public boolean isSpecial() {
        return true; // Товар с фиксированной ценой  является специальным
    }
}
