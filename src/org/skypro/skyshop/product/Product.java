package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String productName;


    public Product(String productName) {
        if ((productName == null)|| (productName.isBlank())){
            throw new IllegalArgumentException("Поле имя продукта не может быть пустым");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductCost();

    public String toString() {
        return getProductName() + ": " + getProductCost();
    }

    public boolean isSpecial() {
        return false; // По умолчанию товар не  специальный
    }

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "Продукт";
    }

    @Override
    public String getName() {
        return productName;
    }
}
