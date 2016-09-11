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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.adapters.TipAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

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

    @BindView(R.id.tv_skintip_title1)
    TextView tvskintiptitle1;

    @BindView(R.id.tv_skintip_desc1)
    TextView tvskintipdesc1;

    @BindView(R.id.iv_tipskinimg1)
    ImageView ivskintip1;

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
        tvskintiptitle1.setText(R.string.skin_title1);
        tvskintipdesc1.setText(R.string.sample_skintips1);

        Glide.with(ivskintip.getContext())
                .load(R.drawable.makeupbaseforoilyskin)
             //   .centerCrop()
                .into(ivskintip);

        Glide.with(ivskintip1.getContext())
                .load(R.drawable.liquidfoundationforoilyskin)
             //   .centerCrop()
                .into(ivskintip1);
    }

    @OnItemSelected(R.id.sp_tip_list)
    public void OnSelectedSpinner(){
        String spinnertext=sptiplist.getSelectedItem().toString();
   //     tvskintiptitle.setText(sptiplist.getSelectedItem().toString());
//        Toast.makeText(getContext(),"Spinner selected Data"+spinnertext,Toast.LENGTH_SHORT).show();
    }

}