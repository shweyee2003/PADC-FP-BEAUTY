package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.adapters.FaceTipAdapter;
import com.padc.beauty.data.models.DressingModel;
import com.padc.beauty.data.models.TipModel;
import com.padc.beauty.data.vos.DressingVO;
import com.padc.beauty.data.vos.TipVO;

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

    @BindView(R.id.tv_foundation_title)
    TextView tvfoundationtitle;

    @BindView(R.id.tv_foundation_desc)
    TextView tvfoundationdesc;

    @BindView(R.id.iv_foundation)
    ImageView ivfoundation;

    @BindView(R.id.tv_powder_title)
    TextView tvpowdertitle;

    @BindView(R.id.tv_powder_desc)
    TextView tvpowderdesc;

    @BindView(R.id.iv_powder)
    ImageView ivpowder;

    @BindView(R.id.tv_lipstick_title)
    TextView tvlipsticktitle;

    @BindView(R.id.tv_lipstick_desc)
    TextView tvlipstickdesc;

    @BindView(R.id.iv_lipstick)
    ImageView ivlipstick;

    @BindView(R.id.tv_eyeshadow_title)
    TextView tveyeshadowtitle;

    @BindView(R.id.tv_eyeshadow_desc)
    TextView tveyeshadowdesc;

    @BindView(R.id.iv_eyeshadow)
    ImageView iveyeshadow;

    @BindView(R.id.tv_blush_title)
    TextView tvblushtitle;

    @BindView(R.id.tv_blush_desc)
    TextView tvblushdesc;

    @BindView(R.id.iv_blush)
    ImageView ivblush;

    private FaceTipAdapter mTipListAdapter;

    public static SkinTipsFragment newInstance(){
        SkinTipsFragment skinTipsFragment=new SkinTipsFragment();
        return skinTipsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] tipListArray = getResources().getStringArray(R.array.Skin_Tone_tip_list);
        List<String> tipList = new ArrayList<>(Arrays.asList(tipListArray));

        mTipListAdapter = new FaceTipAdapter(tipList);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_skin_tips, container, false);
        ButterKnife.bind(this, rootView);
        sptiplist.setAdapter(mTipListAdapter);
        List<TipVO> tipList = TipModel.getInstance().getmTipList();
        showdata();
        return rootView;
    }

    private void showdata()
    {
        tvfoundationtitle.setText(R.string.foundation_skintone_title);
        tvpowdertitle.setText(R.string.powder_skintone_title);
        tvlipsticktitle.setText(R.string.lipstick_skintone_title);
        tveyeshadowtitle.setText(R.string.eyeshadow_skintone_title);
        tvblushtitle.setText(R.string.blush_skintone_title);

        tvfoundationdesc.setText(R.string.foundation_skintone_desc);
        tvpowderdesc.setText(R.string.powder_skintone_desc);
        tvlipstickdesc.setText(R.string.lipstick_skintone_desc);
        tveyeshadowdesc.setText(R.string.eyeshadow_skintone_desc);
        tvblushdesc.setText(Html.fromHtml(getString(R.string.blush_skintone_desc)));

        Glide.with(ivfoundation.getContext())
                .load(R.drawable.yellowbasedmakeup)
             //   .centerCrop()
                .into(ivfoundation);

        Glide.with(ivpowder.getContext())
                .load(R.drawable.yellowbasedpowder)
             //   .centerCrop()
                .into(ivpowder);

        Glide.with(ivlipstick.getContext())
                .load(R.drawable.lipstickforwarmskintone)
                //   .centerCrop()
                .into(ivlipstick);

        Glide.with(iveyeshadow.getContext())
                .load(R.drawable.colorforwarmskintone)
                //   .centerCrop()
                .into(iveyeshadow);

        Glide.with(ivblush.getContext())
                .load(R.drawable.blushcolorforwarmskintone)
                //   .centerCrop()
                .into(ivblush);
    }

    @OnItemSelected(R.id.sp_tip_list)
    public void OnSelectedSpinner(){
        String spinnertext=sptiplist.getSelectedItem().toString();
   //     tvskintiptitle.setText(sptiplist.getSelectedItem().toString());
//        Toast.makeText(getContext(),"Spinner selected Data"+spinnertext,Toast.LENGTH_SHORT).show();
    }

}