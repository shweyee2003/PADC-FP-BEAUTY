package com.padc.beauty.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.BeautySaloonVO;
import com.padc.beauty.fragments.SaloonandFashionshopFragment;
import com.padc.beauty.views.holders.BeautySaloonViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 10/3/2016.
 */
public class SalonandFashionshopActivity extends AppCompatActivity implements  BeautySaloonViewHolder.ControllerBeautysalonItem {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static Intent newIntent() {
        Intent intent = new Intent(BeautyApp.getContext(), SalonandFashionshopActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_fashionshop);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, SaloonandFashionshopFragment.newInstance())
                .commit();
        }
    }

    @Override
    public void onTapBeautysalon(BeautySaloonVO beautysalon, ImageView ivbeautysaloon) {
        Intent intent = BeautysalonDetailActivity.newIntent(beautysalon.getsaloonid(), beautysalon.getPhoto(),beautysalon.getsaloonname());
        startActivity(intent);
    }
}
