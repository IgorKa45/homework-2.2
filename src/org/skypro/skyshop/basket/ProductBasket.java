package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

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
        return products.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getProductCost)
                .sum();
    }
    // Метод для подсчета количества специальных продуктов
    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void getBasketContent() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Список товаров:");
            products.values().stream()
                    .flatMap(List::stream) 
                    .forEach(System.out::println);
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + getSpecialCount());
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

