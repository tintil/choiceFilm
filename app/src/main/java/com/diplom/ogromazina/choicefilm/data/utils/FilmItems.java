package com.diplom.ogromazina.choicefilm.data.utils;

/**
 * Created by OGromazina on 4/22/2018.
 */

public enum FilmItems {
    genre(0, "Жанр"),
    timeOfFilms(1, "Длительность"),
    reviews(2, "Отзывы"),
    rating(3, "Рейтинг"),
    newness(4, "Новизна"),
    popular(5, "Популярность"),
    actors(6, "Актёрский состав");

    private final int index;
    private final String name;

    FilmItems(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int index() {
        return index;
    }

    String[] filmsItem = {"Жанр", "Длительность", "Отзывы", "Рейтинг", "Новизна", "Популярность", "Актёрский состав"};
}
