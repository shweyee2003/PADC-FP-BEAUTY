package com.padc.beauty.data.persistence;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by Asus on 9/24/2016.
 */
public class BeautyProvider extends ContentProvider {
    public static final int BEAUTY = 100;
    public static final int SALON_SERVICES = 200;
    public static final int FASHIONSHOP = 300;

    private static final String sBeautyIdSelection = BeautyContract.BeautySalonEntry.COLUMN_ID + " = ?";
    private static final String sAttractionSelectionWithTitle = BeautyContract.BeautySalonEntry.COLUMN_ID + " = ?";

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private BeautyDBHelper mBeautyDBHelper;
    @Override
    public boolean onCreate() {
        mBeautyDBHelper = new BeautyDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor queryCursor;

        int matchUri = sUriMatcher.match(uri);
        switch (matchUri) {
            case BEAUTY:
//                String attractionTitle = BeautyContract.BeautySalonEntry.getTitleFromParam(uri);
//                if (!TextUtils.isEmpty(attractionTitle)) {
//                    selection = sAttractionSelectionWithTitle;
//                    selectionArgs = new String[]{attractionTitle};
//                }
                queryCursor = mBeautyDBHelper.getReadableDatabase().query(BeautyContract.BeautySalonEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
            case SALON_SERVICES:
//                String title = BeautyContract.SalonServicesEntry.getTitleFromParam(uri);
//                if (title != null) {
//                    selection = sAttractionSelectionWithTitle;
//                    selectionArgs = new String[]{title};
//                }
                queryCursor = mBeautyDBHelper.getReadableDatabase().query(BeautyContract.SalonServicesEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        sortOrder);
                break;
            case FASHIONSHOP:
                queryCursor = mBeautyDBHelper.getReadableDatabase().query(BeautyContract.FashionshopEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        Context context = getContext();
        if (context != null) {
            queryCursor.setNotificationUri(context.getContentResolver(), uri);
        }

        return queryCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final SQLiteDatabase db = mBeautyDBHelper.getWritableDatabase();
        final int matchUri = sUriMatcher.match(uri);
        Uri insertedUri;

        switch (matchUri) {
            case BEAUTY: {
                long _id = db.insert(BeautyContract.BeautySalonEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.BeautySalonEntry.buildBeautySalonUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case SALON_SERVICES: {
                long _id = db.insert(BeautyContract.SalonServicesEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.SalonServicesEntry.buildBeautySalonUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case FASHIONSHOP: {
                long _id = db.insert(BeautyContract.FashionshopEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.FashionshopEntry.buildFashionshopUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return insertedUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mBeautyDBHelper.getWritableDatabase();
        int rowDeleted;
        String tableName = getTableName(uri);

        rowDeleted = db.delete(tableName, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowDeleted > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues,String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mBeautyDBHelper.getWritableDatabase();
        int rowUpdated;
        String tableName = getTableName(uri);

        rowUpdated = db.update(tableName, contentValues, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowUpdated > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowUpdated;
    }
    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        final SQLiteDatabase db = mBeautyDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int insertedCount = 0;

        try {
            db.beginTransaction();
            for (ContentValues cv : values) {
                long _id = db.insert(tableName, null, cv);
                if (_id > 0) {
                    insertedCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }

        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return insertedCount;
    }
    private static UriMatcher buildUriMatcher() {
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_BEAUTY_SALON, BEAUTY);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_SALON_SERVICES, SALON_SERVICES);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_FASHION_SHOP, FASHIONSHOP);

        return uriMatcher;
    }

    private String getTableName(Uri uri) {
        final int matchUri = sUriMatcher.match(uri);

        switch (matchUri) {
            case BEAUTY:
                return BeautyContract.BeautySalonEntry.TABLE_NAME;
            case SALON_SERVICES:
                return BeautyContract.SalonServicesEntry.TABLE_NAME;
            case FASHIONSHOP:
                return BeautyContract.FashionshopEntry.TABLE_NAME;
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }
}
