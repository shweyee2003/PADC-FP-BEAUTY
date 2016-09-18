package com.padc.beauty.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.fragments.PersonalityDetailFragment;
import com.padc.beauty.fragments.WorkoutDetailFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by windows on 9/17/2016.
 */
public class PersonalityDetailActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.btn_next)
    Button btnnext;

    @BindView(R.id.btn_previous)
    Button btnprevious;

    private int presonalityIndex = -1;

    public static Intent newIntent() {
        Intent intent = new Intent(BeautyApp.getContext(), PersonalityDetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (savedInstanceState == null) {
            presonalityIndex++;
            navigateToPersonality(presonalityIndex);
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @OnClick(R.id.btn_next)
    public void  onTapNext(){
        presonalityIndex++;
        if (presonalityIndex < 3) {
            navigateToPersonality(presonalityIndex);
        } else {
            presonalityIndex =2;
            //Toast.makeText(getApplicationContext(), R.string.msg_no_more_joke, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_previous)
    public void  onTapPrevious(){
        presonalityIndex--;
        if (presonalityIndex >=0) {
            navigateToPersonality(presonalityIndex);
        } else {
            presonalityIndex =0;
            //Toast.makeText(getApplicationContext(), R.string.msg_no_more_joke, Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToPersonality(int presonalityIndex) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, PersonalityDetailFragment.newInstance(presonalityIndex))
                .commit();
    }
}
