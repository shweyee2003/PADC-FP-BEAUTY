package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.beauty.R;

/**
 * Created by windows on 9/17/2016.
 */
public class PersonalityListFragment extends Fragment {
    public static PersonalityListFragment newInstance() {
        return new PersonalityListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personality_list, container, false);
        return view;


    }
}
