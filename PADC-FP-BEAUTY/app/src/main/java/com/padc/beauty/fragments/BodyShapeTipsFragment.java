package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.adapters.TipAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

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
        tvbodytipdesc.setText(R.string.bd_description);
        tvbodytiptitle1.setText(R.string.body_title1);
        tvbodytipdesc1.setText(R.string.body_dos1);


        Glide.with(ivbodytip.getContext())
                .load(R.drawable.pear_bodyshape)
                .placeholder(R.drawable.special_dressing_style1)
                .centerCrop()
                .into(ivbodytip);

        Glide.with(ivbodytip1.getContext())
                .load(R.drawable.pear_bodyshape)
                .placeholder(R.drawable.special_dressing_style2)
                .centerCrop()
                .into(ivbodytip1);
    }

    @OnItemSelected(R.id.sp_tip_list)
    public void OnSelectedSpinner(){
        String spinnertext=sptiplist.getSelectedItem().toString();
      //  tvbodytiptitle.setText(sptiplist.getSelectedItem().toString());
       // Toast.makeText(getContext(),"Spinner selected Data"+spinnertext,Toast.LENGTH_SHORT).show();
    }
}