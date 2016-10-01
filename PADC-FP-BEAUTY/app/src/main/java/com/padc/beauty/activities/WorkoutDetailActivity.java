package com.padc.beauty.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.data.models.TipModel;
import com.padc.beauty.data.vos.TipVO;
import com.padc.beauty.fragments.WorkoutDetailFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 9/15/2016.
 */
public class WorkoutDetailActivity extends AppCompatActivity{
    private static final String IE_TIP_ID = "TIP_ID";
    private Long mTipId;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    public static Intent newIntent(long tipId) {
        Intent intent = new Intent(BeautyApp.getContext(), WorkoutDetailActivity.class);
        intent.putExtra(IE_TIP_ID,tipId);
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
        mTipId = getIntent().getLongExtra(IE_TIP_ID,0);
        final TipVO mHealth = TipModel.getInstance().getTipsById(mTipId);
        if(mHealth == null){
            throw new RuntimeException("Can't find Tips obj with tipid : "+mTipId);
        }
        else {
            Log.d(BeautyApp.TAG,"Health");
        }
    }

}
