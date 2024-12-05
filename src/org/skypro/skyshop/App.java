package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        // Создаём объект SearchEngine
        SearchEngine searchEngine = new SearchEngine(10);

        // Добавляем товары
        searchEngine.add(new FixPriceProduct("Ручка"));
        searchEngine.add(new DiscountedProduct("Клей", 120, 25));
        searchEngine.add(new SimpleProduct("Корректор для текста", 218));
        searchEngine.add(new DiscountedProduct("Степлер", 346, 15));
        searchEngine.add(new FixPriceProduct("Скобы для степлера"));
        searchEngine.add(new SimpleProduct("Ластик", 221));

        // Добавляем статьи
        searchEngine.add(new Article("Как выбрать канцтовары", "В статье описаны критерии выбора ручек, ластиков и степлеров."));
        searchEngine.add(new Article("Советы по экономии", "Научитесь выбирать товары со скидкой."));
        searchEngine.add(new Article("История канцелярских принадлежностей", "Ручки и ластики имеют длинную и увлекательную историю."));

        // Выполняем поиск и выводим результаты
        System.out.println("Поиск по запросу 'Ручка':");
        System.out.println(Arrays.toString(searchEngine.search("Ручка")));

        System.out.println("\nПоиск по запросу 'ластик':");
        System.out.println(Arrays.toString(searchEngine.search("ластик")));

        System.out.println("\nПоиск по запросу 'AAAAA':");
        System.out.println(Arrays.toString(searchEngine.search("AAAAA")));

        System.out.println();
        ProductBasket basket = new ProductBasket();
        FixPriceProduct product1 = new FixPriceProduct("Ручка");
        DiscountedProduct product2 = new DiscountedProduct("Клей", 120, 25);
        SimpleProduct product3 = new SimpleProduct("Корректор для текста", 218);
        DiscountedProduct product4 = new DiscountedProduct("Степлер", 346, 15);
        FixPriceProduct product5 = new FixPriceProduct("Скобы для степлера");
        SimpleProduct product6 = new SimpleProduct("Ластик", 221);

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
