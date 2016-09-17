package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.beauty.R;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows on 9/14/2016.
 */
public class WeddingDressFragment extends Fragment {


    public static WeddingDressFragment newInstance() {
        return new WeddingDressFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wedding_dress, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
