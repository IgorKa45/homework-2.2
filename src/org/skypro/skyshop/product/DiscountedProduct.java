package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basedCost;
    private int discountPercent;

    public DiscountedProduct(String productName, int basedCost, int discountPercent) {
        super(productName); // Конструктор суперкласса
        this.basedCost = basedCost;
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public int getProductCost() {
        return basedCost * discountPercent / 100;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductCost() + "(" + getDiscountPercent() + "%" + ")";
    }

    @Override
    public boolean isSpecial() {
        return true; // Товар по скидке  является специальным
    }
}
