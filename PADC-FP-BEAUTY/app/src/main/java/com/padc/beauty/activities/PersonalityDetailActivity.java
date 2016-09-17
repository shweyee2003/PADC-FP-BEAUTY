package com.padc.beauty.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.padc.beauty.BeautyApp;

/**
 * Created by windows on 9/17/2016.
 */
public class PersonalityDetailActivity extends AppCompatActivity {
    public static Intent newIntent() {
        Intent intent = new Intent(BeautyApp.getContext(), PersonalityDetailActivity.class);
        return intent;
    }
}
