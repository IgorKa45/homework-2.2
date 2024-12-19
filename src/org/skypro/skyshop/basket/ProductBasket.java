package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> products;
    private int productCount;

    public ProductBasket() {
        products = new HashMap<>();
        productCount = 0;
    }

    //Добавление продуктов в корзину
    public void addProduct(Product product) {
        String productName = product.getProductName();
        products.putIfAbsent(productName, new ArrayList<>());
        products.get(productName).add(product);
    }

    //Расчёт стоимости корзины
    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getProductCost();
            }
        }

        return total;
    }

    public void getBasketContent() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Список товаров:");
            int specialProductCount = 0;
            for (List<Product> productList: products.values()) {
                for (Product product : productList) {
                    if (product != null) {
                        System.out.println(product);
                        if (product.isSpecial()) {
                            specialProductCount++;
                        }
                    }
                }
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialProductCount);
        }
    }

    //Проверка наличия продукта в корзине
    public boolean getProductCheck(String productName) {
        return products.containsKey(productName);
    }

    public void clearBasket() {
        products.clear();
    }

    //метод для удаления продуктов по имени
    public List<Product> removeProductName(String productName) {
        List<Product> removedProducts = products.remove(productName);
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }
}

