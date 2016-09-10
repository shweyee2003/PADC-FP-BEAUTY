package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;

import com.padc.beauty.R;
import com.padc.beauty.adapters.TipAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows on 9/7/2016.
 */
public class BodyShapeTipsFragment extends Fragment {

    @BindView(R.id.sp_tip_list)
    Spinner sptiplist;

    private TipAdapter mTipListAdapter;
    public static BodyShapeTipsFragment newInstance(){
        BodyShapeTipsFragment bodyshapeTipsFragment=new BodyShapeTipsFragment();

        return bodyshapeTipsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] tipListArray = getResources().getStringArray(R.array.Body_Shape_tip_list);
        List<String> tipList = new ArrayList<>(Arrays.asList(tipListArray));

        mTipListAdapter = new TipAdapter(tipList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bodyshape_tips, container, false);
        ButterKnife.bind(this, rootView);
        sptiplist.setAdapter(mTipListAdapter);

        return rootView;
    }
}
