package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.adapters.BodyshapeListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 9/8/2016.
 */
public class BodyshapeFragment extends Fragment {
    @BindView(R.id.sp_bodyshape)
    Spinner spBodyshapeList;
    private BodyshapeListAdapter mBodyshapeListAdapter;

    public BodyshapeFragment() {
    }

    public static BodyshapeFragment newInstance() {
        BodyshapeFragment fragment = new BodyshapeFragment();
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] tipListArray = getResources().getStringArray(R.array.Body_Shape_tip_list);
        List<String> bodyshapeList = new ArrayList<>(Arrays.asList(tipListArray));

        mBodyshapeListAdapter = new BodyshapeListAdapter(bodyshapeList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bodyshape, container, false);
        ButterKnife.bind(this, rootView);
        spBodyshapeList.setAdapter(mBodyshapeListAdapter);

        return rootView;
    }

    
}
