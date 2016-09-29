package com.padc.beauty.data.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asus on 9/24/2016.
 */
public class BeautyDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 12;
    public static final String DATABASE_NAME = "beauty.db";

    private static final String SQL_CREATE_BEAUTY_SALON_TABLE ="CREATE TABLE " + BeautyContract.BeautySalonEntry.TABLE_NAME + " (" +
        BeautyContract.BeautySalonEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        BeautyContract.BeautySalonEntry.COLUMN_SALON_NAME + " TEXT NOT NULL, "+
        BeautyContract.BeautySalonEntry.COLUMN_DIRECTION_TO_SALON + " TEXT NOT NULL, "+
        BeautyContract.BeautySalonEntry.COLUMN_FULL_ADDRESS + " TEXT NOT NULL, " +
        BeautyContract.BeautySalonEntry.COLUMN_PHOTO + " TEXT NOT NULL, "+
        BeautyContract.BeautySalonEntry.COLUMN_OPEN + " TEXT NOT NULL, "+

        " UNIQUE (" + BeautyContract.BeautySalonEntry.COLUMN_ID + ") ON CONFLICT IGNORE" +
            " );";

    private static final String SQL_CREATE_SALON_SERVICES_TABLE ="CREATE TABLE " + BeautyContract.SalonServicesEntry.TABLE_NAME + " (" +
            BeautyContract.SalonServicesEntry.COLUMN_SERVICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BeautyContract.SalonServicesEntry.COLUMN_SALON_ID + " INT NOT NULL, "+
            BeautyContract.SalonServicesEntry.COLUMN_SERVICE_TITLE + " TEXT NOT NULL, "+
            BeautyContract.SalonServicesEntry.COLUMN_IMAGE + " TEXT NOT NULL, " +
            BeautyContract.SalonServicesEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, "+

            " UNIQUE (" + BeautyContract.SalonServicesEntry.COLUMN_SERVICE_ID + ") ON CONFLICT IGNORE" +
            " );";

    private static final String SQL_CREATE_FASHION_SHOP_TABLE ="CREATE TABLE " + BeautyContract.FashionshopEntry.TABLE_NAME + " (" +
            BeautyContract.FashionshopEntry.COLUMN_SHOP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BeautyContract.FashionshopEntry.COLUMN_SHOP_NAME + " INT NOT NULL, "+
            BeautyContract.FashionshopEntry.COLUMN_DIRECTION_TO_SHOP + " TEXT NOT NULL, "+
            BeautyContract.FashionshopEntry.COLUMN_ADDRESS + " TEXT NOT NULL, " +
            BeautyContract.FashionshopEntry.COLUMN_PHOTO + " TEXT NOT NULL, "+

            " UNIQUE (" + BeautyContract.FashionshopEntry.COLUMN_SHOP_ID  + ") ON CONFLICT IGNORE" +
            " );";

    public BeautyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_BEAUTY_SALON_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_SALON_SERVICES_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_FASHION_SHOP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BeautyContract.BeautySalonEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BeautyContract.SalonServicesEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BeautyContract.FashionshopEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
