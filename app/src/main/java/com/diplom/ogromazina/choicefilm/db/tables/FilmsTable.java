package com.diplom.ogromazina.choicefilm.db.tables;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by OGromazina on 6/6/2018.
 */

public class FilmsTable implements BaseColumns {
    public static final String AUTHORITY = "com.choicefilm.database";
    public static final String TABLE_NAME = "films";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

    public static final String  FILM_ID = "id_film";
    public static final String  NAME = "name";
    public static final String  YEAR = "year";
    public static final String  RATING = "rating";
    public static final String  REVIEWS = "reviews";
    public static final String  DURATION = "duration";
    public static final String  COUNTRY_ID = "id_country";
}
