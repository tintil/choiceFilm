package com.diplom.ogromazina.choicefilm.db.tables;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by OGromazina on 6/6/2018.
 */

public class GenreInFilm implements BaseColumns {
    public static final String AUTHORITY = "com.choicefilm.database";
    public static final String TABLE_NAME = "genreInFilm";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

    public static final String  FILM_ID = "id_film";
    public static final String  GENRE_ID = "id_genre";
}
