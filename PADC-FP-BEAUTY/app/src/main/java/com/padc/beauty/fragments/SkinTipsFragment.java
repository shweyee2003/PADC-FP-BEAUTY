package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by windows on 9/6/2016.
 =======
 import android.os.Bundle;
 import android.support.annotation.Nullable;
 import android.support.v4.app.Fragment;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;

 import com.padc.beauty.R;

 /**
 * Created by windows on 9/8/2016.

 */
public class SkinTipsFragment extends Fragment {

    @BindView(R.id.sp_tip_list)
    Spinner sptiplist;

    @BindView(R.id.tv_skintip_title)
    TextView tvskintiptitle;

    @BindView(R.id.tv_skintip_desc)
    TextView tvskintipdesc;

    @BindView(R.id.iv_tipskinimg)
    ImageView ivskintip;

    private TipAdapter mTipListAdapter;

    public static SkinTipsFragment newInstance(){
        SkinTipsFragment skinTipsFragment=new SkinTipsFragment();
        return skinTipsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] tipListArray = getResources().getStringArray(R.array.Skin_Type_tip_list);
        List<String> tipList = new ArrayList<>(Arrays.asList(tipListArray));

        mTipListAdapter = new TipAdapter(tipList);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_skin_tips, container, false);
        ButterKnife.bind(this, rootView);
        sptiplist.setAdapter(mTipListAdapter);
        showdata();
        return rootView;
    }

    private void showdata()
    {
        tvskintiptitle.setText(R.string.skin_title);
        tvskintipdesc.setText(R.string.sample_skintips);
        Glide.with(ivskintip.getContext())
                .load(R.drawable.hair1)
                .centerCrop()
                .into(ivskintip);
    }

}