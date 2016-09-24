package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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

    @BindView(R.id.tv_bodytip_title)
    TextView tvbodytiptitle;

    @BindView(R.id.tv_bodyshape_desc)
    TextView tvbodytipdesc;

    @BindView(R.id.iv_tipbodyimg)
    ImageView ivbodytip;

    @BindView(R.id.tv_bodytip_title1)
    TextView tvbodytiptitle1;

    @BindView(R.id.tv_bodyshape_desc1)
    TextView tvbodytipdesc1;

    @BindView(R.id.iv_tipbodyimg1)
    ImageView ivbodytip1;

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
        showdata();
        return rootView;
    }

    private void showdata()
    {
        tvbodytiptitle.setText(R.string.body_title);
        tvbodytipdesc.setText(R.string.sample_bodyshapetips);
        Glide.with(ivbodytip.getContext())
                .load(R.drawable.pear_bodyshape)
                .placeholder(R.drawable.hair2)
                .centerCrop()
                .into(ivbodytip);
    }
}