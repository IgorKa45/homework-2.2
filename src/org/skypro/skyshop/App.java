package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {

        System.out.println("Некорреектное имя: null");
        try {
            SimpleProduct product7 = new SimpleProduct(null, 394);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
        System.out.println("Некорректная цена");
        try {
            SimpleProduct product8 = new SimpleProduct("Клей2", -25);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
        System.out.println("Некорректный процент");
        try {
            DiscountedProduct product9 = new DiscountedProduct("Клей3", 45, 116);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        // Создаём объект SearchEngine с вместимостью 10 элементов
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


        // Демонстрация метода findMostRelevant
        System.out.println("\nПоиск наиболее релевантных запросов:");
        try {
            // Успешный поиск
            String query1 = "ручка";
            System.out.println("\nИщем наиболее подходящий элемент для запроса: " + query1);
            Searchable result1 = searchEngine.findMostRelevant(query1);
            System.out.println("Наиболее подходящий элемент:");
            System.out.println(result1);
        } catch (SearchEngine.BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            // Поиск, который вызовет исключение
            String query2 = "error";
            System.out.println("\nИщем наиболее подходящий элемент для запроса: " + query2);
            Searchable result2 = searchEngine.findMostRelevant(query2);
            System.out.println("Наиболее подходящий элемент:");
            System.out.println(result2);
        } catch (SearchEngine.BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();
        // Выполняем поиск и выводим результаты
        System.out.println("Поиск по запросу 'Ручка':");
        Map<String, Searchable> results1 = searchEngine.search("Ручка");
        for (Map.Entry<String, Searchable> entry : results1.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("\nПоиск по запросу 'ластик':");
        Map<String, Searchable> results2 = searchEngine.search("ластик");
        for (Map.Entry<String, Searchable> entry : results2.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("\nПоиск по запросу 'AAAAAA':");
        Map<String, Searchable> results3 = searchEngine.search("AAAAAA");
        for (Map.Entry<String, Searchable> entry : results3.entrySet()) {
            System.out.println(entry.getValue());
        }

        ProductBasket basket = new ProductBasket();
        FixPriceProduct product1 = new FixPriceProduct("Ручка");
        DiscountedProduct product2 = new DiscountedProduct("Клей", 120, 25);
        SimpleProduct product3 = new SimpleProduct("Корректор для текста", 218);
        DiscountedProduct product4 = new DiscountedProduct("Степлер", 346, 15);
        FixPriceProduct product5 = new FixPriceProduct("Скобы для степлера");
        SimpleProduct product6 = new SimpleProduct("Ластик", 221);

        System.out.println("\nПустая корзина:");
        basket.getBasketContent();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        System.out.println("\nКорзина с товарами:");
        basket.getBasketContent();


        System.out.println("\nПоиск товара, который есть в корзине:");
        System.out.println(basket.getProductCheck("Клей"));

        System.out.println("\nПоиск товара, которого нет в корзине:");
        System.out.println(basket.getProductCheck("Ластик"));

        // Удаление существующего продукта и содержимое после его удаления
        System.out.println("\nУдаление продукта 'Клей':");
        List<Product> removedProducts = basket.removeProductName("Клей");
        System.out.println("Удаленные продукты:");
        for (Product product : removedProducts) {
            System.out.println(product);
        }
        System.out.println();
        basket.getBasketContent();

        // Удаление несуществующего продукта и проверка корзины
        System.out.println("\nУдаление несуществующего продукта 'Ластик':");
        List<Product> removedProducts2 = basket.removeProductName("Ластик");
        if (removedProducts2.isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println("\nСодержимое корзины после удаления несуществующего продукта:");
        basket.getBasketContent();

        System.out.println("\nОчистка корзины:");
        basket.clearBasket();

        System.out.println("\nПечать содержимого пустой корзины:");
        basket.getBasketContent();

        System.out.println("\nПолучение стоимости пустой корзины:");
        System.out.println(basket.getTotalPrice());

        System.out.println("\nПоиск товара по имени в пустой корзине:");
        System.out.println(basket.getProductCheck("Клей"));

    }
}
