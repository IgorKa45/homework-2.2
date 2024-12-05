package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title; // Название статьи
        this.content = content; // Текст статьи
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + content; // Искать можно по названию и тексту
    }

    @Override
    public String getContentType() {
        return "Статья";
    }

    @Override
    public String getName() {
        return title;
    }


}
