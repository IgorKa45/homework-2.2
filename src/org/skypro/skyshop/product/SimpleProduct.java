package org.skypro.skyshop.product;

// Класс SimpleProduct, наследующий Product
public class SimpleProduct extends Product {
    private int productCost;

    public SimpleProduct(String productName, int productCost) {
        super(productName); // Конструктор суперкласса
        this.productCost = productCost;
    }

    @Override
    public int getProductCost() {
        return productCost;
    }
}