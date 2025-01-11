package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables; // Массив всех элементов для поиска


    public SearchEngine(int size) {
        searchables = new HashSet<>(size);
    }

    public void add(Searchable item) {
        searchables.add(item);
    }

    public Set<Searchable> search(String query) {
        return searchables.stream()
                .filter(searchable -> searchable != null &&
                        searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
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



