package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.beauty.R;

/**
 * Created by windows on 9/5/2016.
 */
public class FaceTipsFragment extends Fragment {
    public static FaceTipsFragment newInstance(){
        FaceTipsFragment faceTipsFragment=new FaceTipsFragment();
        return faceTipsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_face_tips, container, false);
        return rootView;
    }
}
