package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables; // Массив всех элементов для поиска
    private int itemCount; // Количество добавленных элементов

    public SearchEngine(int size) {
        searchables = new Searchable[size];
        itemCount = 0;
    }

    public void add(Searchable item) {
        if (itemCount < searchables.length) {
            searchables[itemCount++] = item;
        } else {
            System.out.println("Невозможно добавить элемент: массив заполнен.");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[resultCount++] = searchable;
                if (resultCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}
