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

    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new IllegalArgumentException("Поисковая строка не может быть пустой или null");
        }
        // максимальное количество вхождений строки
        Searchable mostRelevant = null;
        // максимальное количество вхождений строки на текущий момент
        int maxOccurrences = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm().toLowerCase();
                String lowerSearch = search.toLowerCase();

                // Считаем количество вхождений строки search в searchTerm
                int occurrences = 0;
                int index = 0;
                int substringIndex = searchTerm.indexOf(lowerSearch, index);

                while (substringIndex != -1) {
                    occurrences++;
                    index = substringIndex + lowerSearch.length();
                    substringIndex = searchTerm.indexOf(lowerSearch, index);
                }

                // Сравниваем текущие вхождения с максимальными
                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    mostRelevant = searchable;
                }
            }
        }
        if (mostRelevant == null) {
            throw new BestResultNotFound("Для запроса \"" + search + "\" не найдено подходящего результата.");
        }
        return mostRelevant;
    }

    public class BestResultNotFound extends Exception {
        public BestResultNotFound() {
            super();
        }

        public BestResultNotFound(String message) {
            super(message);
        }
    }

}
