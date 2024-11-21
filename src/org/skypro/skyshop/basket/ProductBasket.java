package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int productCount;

    public ProductBasket() {
        products = new Product[5];
        productCount = 0;
    }

    //Добавление продуктов в корзину
    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        } else {
            System.out.println("Невозможно добавить продукт: корзина заполнена.");
        }
    }

    //Расчёт стоимости корзины
    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getProductCost();
            }
        }
        return total;
    }

    public void getBasketContent() {
        if (productCount == 0) {
            System.out.println("Корзина пуста");
        }
        int specialProductCount = 0;
        if (productCount != 0) {
            System.out.println("Список товаров:");
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                    if (product.isSpecial()) {
                        specialProductCount++;
                    }
                }
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialProductCount);
        }
    }

    //Проверка наличия продукта в корзине
    public boolean getProductCheck(String productName) {
        for (Product product : products) {
            if (product != null && product.getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        productCount = 0;
    }

}


