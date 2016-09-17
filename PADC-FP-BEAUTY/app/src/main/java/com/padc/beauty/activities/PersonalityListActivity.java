package com.padc.beauty.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.padc.beauty.fragments.PersonalityListFragment;

/**
 * Created by windows on 9/17/2016.
 */
public class PersonalityListActivity extends AppCompatActivity implements PersonalityListFragment.ControllerPersonalityItem {
    @Override
    public void onTapEvent() {
        Intent intent=PersonalityDetailActivity.newIntent();
        startActivity(intent);
    }
}
