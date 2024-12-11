package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products;
    private int productCount;
    public ProductBasket() {
        products = new ArrayList<>();
        productCount = 0;
    }

    //Добавление продуктов в корзину
    public void addProduct(Product product) {
        products.add(product);
    }

    //Расчёт стоимости корзины
    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            total += product.getProductCost();
        }
        return total;
    }

    public void getBasketContent() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Список товаров:");
            int specialProductCount = 0;
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
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }
//метод для удаления продуктов по имени
    public List<Product> removeProductName(String productName) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equalsIgnoreCase(productName)) {
                iterator.remove();
                removedProducts.add(product);
            }
        }
        return removedProducts;
    }
}

