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
 * Created by Asus on 10/2/2016.
 */
public class AboutusFragment extends Fragment {
    public static AboutusFragment newInstance(){
        AboutusFragment aboutusFragment = new AboutusFragment();
        return aboutusFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_salon_aboutus, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
