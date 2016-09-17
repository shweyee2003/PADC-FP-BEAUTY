package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padc.beauty.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 9/13/2016.
 */
public class FashionshopFragment extends Fragment {
    @BindView(R.id.tv_papillon)
    TextView fashionPapillon;
    @BindView(R.id.tv_mk)
    TextView fashionMk;
    @BindView(R.id.tv_baza)
    TextView fashionBaza;
    @BindView(R.id.tv_fashion_dream)
    TextView fashionDream;
    @BindView(R.id.tv_silverstar)
    TextView fashionSilverstar;
    @BindView(R.id.tv_sulecenterpoint)
    TextView fashionSule;
    public static FashionshopFragment newInstance(){
        FashionshopFragment fashionshopFragment = new FashionshopFragment();
        return fashionshopFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fashionshop, container, false);
        ButterKnife.bind(this, rootView);
        showdata();
        return rootView;
    }
    private void showdata()
    {
        fashionPapillon.setText(Html.fromHtml(getString(R.string.papillon)));
        fashionMk.setText(Html.fromHtml(getString(R.string.mk)));
        fashionBaza.setText(Html.fromHtml(getString(R.string.baza)));
        fashionDream.setText(Html.fromHtml(getString(R.string.fahsiondream)));
        fashionSilverstar.setText(Html.fromHtml(getString(R.string.silverstar)));
        fashionSule.setText(Html.fromHtml(getString(R.string.sulecenterpoint)));
    }
}
