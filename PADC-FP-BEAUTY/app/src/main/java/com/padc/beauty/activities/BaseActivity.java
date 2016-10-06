package com.padc.beauty.activities;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;

import com.padc.beauty.R;

/**
 * Created by Asus on 10/2/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected void sendViaShareIntent(String msg) {
        startActivity(Intent.createChooser(ShareCompat.IntentBuilder.from(BaseActivity.this)
                .setType("text/plain")
                .setText(msg)
                .getIntent(), getString(R.string.action_share)));
    }
}
