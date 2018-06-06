package com.diplom.ogromazina.choicefilm.db.tables;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by OGromazina on 6/6/2018.
 */

public class GenreTable implements BaseColumns {
    public static final String AUTHORITY = "com.choicefilm.database";
    public static final String TABLE_NAME = "genre";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

    public static final String  GENRE_ID = "id_genre";
    public static final String  NAME = "name";
}
