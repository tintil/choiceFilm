package com.diplom.ogromazina.choicefilm.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.diplom.ogromazina.choicefilm.db.tables.ActorInFilmTable;
import com.diplom.ogromazina.choicefilm.db.tables.CastTable;
import com.diplom.ogromazina.choicefilm.db.tables.CountryTable;
import com.diplom.ogromazina.choicefilm.db.tables.FilmsTable;
import com.diplom.ogromazina.choicefilm.db.tables.GenreInFilm;
import com.diplom.ogromazina.choicefilm.db.tables.GenreTable;

/**
 * Created by OGromazina on 6/6/2018.
 */

public class FilmContentProvider extends ContentProvider {

    private static final String DATABASE_NAME = "kvn.db";

    public static final int USERTABLE = 0;
    public static final int USER_BY_ID = 1;
    public static final int TEAMTABLE = 2;
    public static final int TEAM_BY_ID = 3;
    public static final int LEAGUETABLE = 4;
    public static final int LEAGUE_BY_ID = 5;
    public static final int EVENTTABLE = 6;
    public static final int EVENT_BY_ID = 7;
    public static final int ORGANIZERSTABLE = 8;
    public static final int USER_BY_LEAGUE_ID = 9;
    public static final int JURYTABLE = 10;
    public static final int USER_BY_GAME_ID = 11;
    public static final int TEAMMEMBERSTABLE = 12;
    public static final int USER_BY_TEAM_ID = 13;
    public static final int TEAMINGAMETABLE = 14;
    public static final int TEAM_BY_GAME_ID = 15;


    private static final UriMatcher sUriMatcher;
    static{
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(UsersTable.AUTHORITY, UsersTable.TABLE_NAME, USERTABLE);
        sUriMatcher.addURI(UsersTable.AUTHORITY, UsersTable.TABLE_NAME + "/#", USER_BY_ID);
        sUriMatcher.addURI(EventTable.AUTHORITY, EventTable.TABLE_NAME, EVENTTABLE);
        sUriMatcher.addURI(EventTable.AUTHORITY, EventTable.TABLE_NAME + "/#", EVENT_BY_ID);
        sUriMatcher.addURI(LeaguesTable.AUTHORITY, LeaguesTable.TABLE_NAME, LEAGUETABLE);
        sUriMatcher.addURI(LeaguesTable.AUTHORITY, LeaguesTable.TABLE_NAME + "/#", LEAGUE_BY_ID);
        sUriMatcher.addURI(TeamsTable.AUTHORITY, TeamsTable.TABLE_NAME, TEAMTABLE);
        sUriMatcher.addURI(TeamsTable.AUTHORITY, TeamsTable.TABLE_NAME + "/#", TEAM_BY_ID);
        sUriMatcher.addURI(OrganizersTable.AUTHORITY, OrganizersTable.TABLE_NAME, ORGANIZERSTABLE);
        sUriMatcher.addURI(UsersTable.AUTHORITY, UsersTable.TABLE_NAME + "/league/#", USER_BY_LEAGUE_ID);
        sUriMatcher.addURI(JuryTable.AUTHORITY, JuryTable.TABLE_NAME, JURYTABLE);
        sUriMatcher.addURI(UsersTable.AUTHORITY, UsersTable.TABLE_NAME + "/game/#", USER_BY_GAME_ID);
        sUriMatcher.addURI(TeamMembersTable.AUTHORITY, TeamMembersTable.TABLE_NAME, TEAMMEMBERSTABLE);
        sUriMatcher.addURI(UsersTable.AUTHORITY, UsersTable.TABLE_NAME + "/team/#", USER_BY_TEAM_ID);
        sUriMatcher.addURI(TeamsInGameTable.AUTHORITY, TeamsInGameTable.TABLE_NAME, TEAMINGAMETABLE);
        sUriMatcher.addURI(TeamsTable.AUTHORITY, TeamsTable.TABLE_NAME+ "/game/#", TEAM_BY_GAME_ID);
    }

    private static class DataBaseHelper extends SQLiteOpenHelper {
        public static int VERSION = 1;

        public static final String createFilmsTable = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER, %s INTEGER);",
                FilmsTable.TABLE_NAME, FilmsTable._ID,  FilmsTable.NAME, FilmsTable.YEAR, FilmsTable.RATING, FilmsTable.REVIEWS, FilmsTable.DURATION, FilmsTable.COUNTRY_ID);
        public static final String createCountryTable = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT)",
                CountryTable.TABLE_NAME, CountryTable._ID, CountryTable.NAME);
        public static final String createGenreTable = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT)",
                GenreTable.TABLE_NAME, GenreTable._ID,  GenreTable.NAME);
        public static final String createCastTable = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT)",
                CastTable.TABLE_NAME, CastTable._ID, CastTable.NAME, CastTable.SURNAME);
        public static final String createActorInFilmTable = String.format("CREATE TABLE %s (%s INTEGER, %s INTEGER)",
                ActorInFilmTable.TABLE_NAME, ActorInFilmTable.FILM_ID, ActorInFilmTable.ACTOR_ID);
        public static final String createGenreInFilmTable = String.format("CREATE TABLE %s (%s INTEGER, %s INTEGER)",
                GenreInFilm.TABLE_NAME, GenreInFilm.FILM_ID, GenreInFilm.GENRE_ID);

        public DataBaseHelper(Context context) {

            super(context, DATABASE_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(createFilmsTable);
            db.execSQL(createCountryTable);
            db.execSQL(createGenreTable);
            db.execSQL(createCastTable);
            db.execSQL(createActorInFilmTable);
            db.execSQL(createGenreInFilmTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
    private DataBaseHelper helper;

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
