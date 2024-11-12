package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product product1 = new Product("Ручка", 34);
        Product product2 = new Product("Клей", 120);
        Product product3 = new Product("Корректор для текста", 218);
        Product product4 = new Product("Степлер", 346);
        Product product5 = new Product("Скобы для степлера", 67);
        Product product6 = new Product("Ластик", 221);

        System.out.println("Пустая корзина:");
        basket.getBasketContent();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        System.out.println();
        System.out.println("Корзина с товарами");
        basket.getBasketContent();

        System.out.println();
        System.out.println("Переполненная корзина:");
        basket.addProduct(product6);

        System.out.println();
        System.out.println("Поиск товара, который есть в корзине:");
        System.out.println(basket.getProductCheck("Клей"));

        System.out.println();
        System.out.println("Поиск товара, которого нет в корзине:");
        System.out.println(basket.getProductCheck("Ластик"));

        System.out.println();
        System.out.println("Очистка корзины:");
        basket.clearBasket();

        System.out.println();
        System.out.println("Печать содержимого пустой корзины:");
        basket.getBasketContent();

        System.out.println();
        System.out.println("Получение стоимости пустой корзины:");
        System.out.println(basket.getTotalPrice());

        System.out.println();
        System.out.println("Поиск товара по имени в пустой корзине:");
        System.out.println(basket.getProductCheck("Клей"));

    }
}