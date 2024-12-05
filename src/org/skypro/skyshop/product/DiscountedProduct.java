package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basedCost;
    private int discountPercent;

    public DiscountedProduct(String productName, int basedCost, int discountPercent) {
        super(productName); // Конструктор суперкласса
        if ((discountPercent < 0) || (discountPercent > 100)) {
            throw new IllegalArgumentException("Поле скидка может принимать значения в диапазоне от 0 до 100");
        }
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
