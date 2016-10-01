package com.padc.beauty.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import com.padc.beauty.BeautyApp;

/**
 * Created by Asus on 10/1/2016.
 */
public class HealthRelatedDetailActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>  {

    public static Intent newIntent(long tipId, String photo) {
        Intent intent = new Intent(BeautyApp.getContext(), HealthRelatedDetailActivity.class);
        return intent;
    }
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
