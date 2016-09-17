package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.beauty.R;

import butterknife.ButterKnife;

/**
 * Created by Asus on 9/13/2016.
 */
public class FashionshopFragment extends Fragment {
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

        return rootView;
    }
}
