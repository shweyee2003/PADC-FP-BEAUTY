package com.padc.beauty.data.persistence;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.padc.beauty.BeautyApp;

/**
 * Created by Asus on 9/24/2016.
 */
public class BeautyContract {
    public static final String CONTENT_AUTHORITY = BeautyApp.class.getPackage().getName();
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_BEAUTY_SALON = "beautysalon";
    public static final String PATH_FASHION_SHOP = "fashionshop";
    public static final String PATH_SALON_SERVICES = "salon_services";

    public static final class BeautySalonEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_BEAUTY_SALON).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BEAUTY_SALON;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BEAUTY_SALON;

        public static final String TABLE_NAME = "beautysalon";

        public static final String COLUMN_ID = "saloon_id";
        public static final String COLUMN_SALON_NAME = "saloon_name";
        public static final String COLUMN_DIRECTION_TO_SALON = "direction_to_saloon";
        public static final String COLUMN_FULL_ADDRESS = "full_address";
        public static final String COLUMN_PHOTO = "photos";
        public static final String COLUMN_OPEN = "open_daily";

        public static Uri buildBeautySalonUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildBeautySalonUriWithId(long salon_id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions?title="Yangon"
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_ID, String.valueOf(salon_id))
                    .build();
        }

        public static String getTitleFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_ID);
        }
    }

    public static final class SalonServicesEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SALON_SERVICES).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SALON_SERVICES;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SALON_SERVICES;

        public static final String TABLE_NAME = "salon_services";

        public static final String COLUMN_SERVICE_ID = "service_id";
        public static final String COLUMN_SALON_ID = "saloon_id";
        public static final String COLUMN_SERVICE_TITLE = "service_title";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_DESCRIPTION = "description";

        public static Uri buildBeautySalonUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
        public static String getTitleFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_SERVICE_ID);
        }
    }

    public static final class FashionshopEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_FASHION_SHOP).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FASHION_SHOP;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FASHION_SHOP;

        public static final String TABLE_NAME = "fashionshop";

        public static final String COLUMN_SHOP_ID = "shop_id";
        public static final String COLUMN_SHOP_NAME = "shop_name";
        public static final String COLUMN_DIRECTION_TO_SHOP = "direction_to_shop";
        public static final String COLUMN_ADDRESS = "full_address";
        public static final String COLUMN_PHOTO = "photos";

        public static Uri buildFashionshopUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
        public static String getTitleFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_SHOP_ID);
        }
    }
}
