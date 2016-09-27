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
 * Created by windows on 9/24/2016.
 */
public class BeautyProvider extends ContentProvider {

    public static final int TIP = 100;
    public static final int TIP_SKINCOLOR = 200;
    public static final int TIP_BODYSHAPE = 300;
    public static final int TIP_HAIRCOLOR = 400;
    public static final int TIP_SKINTYPE = 500;
    public static final int TIP_FACETYPE = 600;

    public static final int DRESSING = 700;
    public static final int DRESSING_SKINCOLOR = 800;
    public static final int DRESSING_BODYSHAPE = 900;
    public static final int DRESSING_HAIRSTYLE = 1000;
    public static final int DRESSING_SKINTYPE = 1100;


    private static final String sHairStyleSelectionWithDressingid = BeautyContract.DressingHairStyleEntry.COLUMN_DRESSINGID + " = ?";
    private static final String sBodyShapeSelectionWithDressingid = BeautyContract.DressingBodyShapeEntry.COLUMN_DRESSINGID + " = ?";
    private static final String sSkinTypeSelectionWithDressingid = BeautyContract.DressingSkinTypeEntry.COLUMN_DRESSINGID + " = ?";
    private static final String sSkinColorSelectionWithDressingid = BeautyContract.DressingSkinColorEntry.COLUMN_DRESSINGID + " = ?";

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private BeautyDBHelper mBeautyDBHelper;

    private static UriMatcher buildUriMatcher() {
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_TIPS, TIP);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_TIP_SKINCOLOR, TIP_SKINCOLOR);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_TIP_BODYSHAPE, TIP_BODYSHAPE);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_TIP_FACETYPE, TIP_FACETYPE);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_TIP_HAIRCOLOR, TIP_HAIRCOLOR);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_TIP_SKINTYPE, TIP_SKINTYPE);

        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_DRESSING, DRESSING);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_DRESSING_SKINCOLOR, DRESSING_SKINCOLOR);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_DRESSING_BODYSHAPE, DRESSING_BODYSHAPE);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_DRESSING_HAIRSTYLE, DRESSING_HAIRSTYLE);
        uriMatcher.addURI(BeautyContract.CONTENT_AUTHORITY, BeautyContract.PATH_DRESSING_SKINTYPE, DRESSING_SKINTYPE);

        return uriMatcher;
    }



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
            case TIP:
                queryCursor = mBeautyDBHelper.getReadableDatabase().query(BeautyContract.TipEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
            case DRESSING:
                queryCursor = mBeautyDBHelper.getReadableDatabase().query(BeautyContract.DressingEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
            case DRESSING_HAIRSTYLE:
                String hairdressingid = BeautyContract.DressingHairStyleEntry.getDressingHairStyleFromParam(uri);
                if (hairdressingid != null) {
                    selection = sHairStyleSelectionWithDressingid;
                    selectionArgs = new String[]{hairdressingid};
                }
                queryCursor = mBeautyDBHelper.getReadableDatabase().query(BeautyContract.DressingHairStyleEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
            case DRESSING_BODYSHAPE:
                String bdshapedressingid = BeautyContract.DressingBodyShapeEntry.getDressingBodyShapeFromParam(uri);
                if (bdshapedressingid != null) {
                    selection = sBodyShapeSelectionWithDressingid;
                    selectionArgs = new String[]{bdshapedressingid};
                }
                queryCursor = mBeautyDBHelper.getReadableDatabase().query(BeautyContract.DressingBodyShapeEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
            case DRESSING_SKINCOLOR:
                String skincolordressingid = BeautyContract.DressingSkinColorEntry.getDressingSkinColorFromParam(uri);
                if (skincolordressingid != null) {
                    selection = sSkinColorSelectionWithDressingid;
                    selectionArgs = new String[]{skincolordressingid};
                }
                queryCursor = mBeautyDBHelper.getReadableDatabase().query(BeautyContract.DressingSkinColorEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
            case DRESSING_SKINTYPE:
                String skintypedressingid = BeautyContract.DressingSkinTypeEntry.getDressingSkinTypeFromParam(uri);
                if (skintypedressingid != null) {
                    selection = sSkinTypeSelectionWithDressingid;
                    selectionArgs = new String[]{skintypedressingid};
                }
                queryCursor = mBeautyDBHelper.getReadableDatabase().query(BeautyContract.DressingSkinTypeEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
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
            case TIP: {
                long _id = db.insert(BeautyContract.TipEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.TipEntry.buildTipUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case TIP_BODYSHAPE: {
                long _id = db.insert(BeautyContract.TipBodyShapeEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.TipBodyShapeEntry.buildBodyShapeUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case TIP_FACETYPE: {
                long _id = db.insert(BeautyContract.TipFaceTypeEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.TipFaceTypeEntry.buildFaceTypeUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case TIP_HAIRCOLOR: {
                long _id = db.insert(BeautyContract.TipHairColorEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.TipHairColorEntry.buildHairColorTipUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case TIP_SKINCOLOR: {
                long _id = db.insert(BeautyContract.TipSkinColorEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.TipSkinColorEntry.buildSkinColorTipUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case TIP_SKINTYPE: {
                long _id = db.insert(BeautyContract.TipSkinTypeEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.TipSkinTypeEntry.buildSkinTypeUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case DRESSING: {
                long _id = db.insert(BeautyContract.DressingEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = BeautyContract.DressingEntry.buildDressingUri(_id);
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
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

    private String getTableName(Uri uri) {
        final int matchUri = sUriMatcher.match(uri);

        switch (matchUri) {
            case TIP:
                return BeautyContract.TipEntry.TABLE_NAME;
            case TIP_BODYSHAPE:
                return BeautyContract.TipBodyShapeEntry.TABLE_NAME;
            case TIP_FACETYPE:
                return BeautyContract.TipFaceTypeEntry.TABLE_NAME;
            case TIP_HAIRCOLOR:
                return BeautyContract.TipHairColorEntry.TABLE_NAME;
            case TIP_SKINCOLOR:
                return BeautyContract.TipSkinColorEntry.TABLE_NAME;
            case TIP_SKINTYPE:
                return BeautyContract.TipSkinTypeEntry.TABLE_NAME;
            case DRESSING:
                return BeautyContract.DressingEntry.TABLE_NAME;
            case DRESSING_BODYSHAPE:
                return BeautyContract.DressingBodyShapeEntry.TABLE_NAME;
            case DRESSING_HAIRSTYLE:
                return BeautyContract.DressingHairStyleEntry.TABLE_NAME;
            case DRESSING_SKINCOLOR:
                return BeautyContract.DressingSkinColorEntry.TABLE_NAME;
            case DRESSING_SKINTYPE:
                return BeautyContract.DressingSkinTypeEntry.TABLE_NAME;
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }
}
