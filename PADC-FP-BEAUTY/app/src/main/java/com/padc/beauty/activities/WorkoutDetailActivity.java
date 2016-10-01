package com.padc.beauty.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.fragments.SpecialtipActivityFragment;
import com.padc.beauty.fragments.WorkoutDetailFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 9/15/2016.
 */
public class WorkoutDetailActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    public static Intent newIntent(Long tipid) {
        Intent intent = new Intent(BeautyApp.getContext(), WorkoutDetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, WorkoutDetailFragment.newInstance())
                    .commit();
        }

    }
}
