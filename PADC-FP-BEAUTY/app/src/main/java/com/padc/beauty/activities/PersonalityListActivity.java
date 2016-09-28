package com.padc.beauty.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.fragments.PersonalityListFragment;

/**
 * Created by windows on 9/28/2016.
 */
public class PersonalityListActivity  extends AppCompatActivity {
    public static Intent newIntent() {
        Intent intent = new Intent(BeautyApp.getContext(), PersonalityDetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, PersonalityListFragment.newInstance())
                .commit();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }
}
