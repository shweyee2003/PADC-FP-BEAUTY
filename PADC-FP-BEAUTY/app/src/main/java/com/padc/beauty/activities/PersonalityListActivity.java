package com.padc.beauty.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.padc.beauty.BeautyApp;

/**
 * Created by windows on 9/30/2016.
 */
public class PersonalityListActivity extends AppCompatActivity {
    public static Intent newIntent() {
        Intent intent = new Intent(BeautyApp.getContext(), PersonalityListActivity.class);
        return intent;
    }
}
