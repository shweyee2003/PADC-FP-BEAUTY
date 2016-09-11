package com.padc.beauty.fragments;

import android.content.res.Resources;
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
import com.padc.beauty.utils.BeautyAppConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

/**
 * Created by windows on 9/5/2016.
 */
public class FaceTipsFragment extends Fragment {

    @BindView(R.id.sp_tip_list)
    Spinner sptiplist;

    @BindView(R.id.tv_facetip_title)
    TextView tvfacetiptitle;

    @BindView(R.id.tv_facetip_desc)
    TextView tvfacetipdesc;

    @BindView(R.id.iv_tipfaceimg)
    ImageView ivfacetip;

    @BindView(R.id.tv_facetip_title1)
    TextView tvfacetiptitle1;

    @BindView(R.id.tv_facetip_desc1)
    TextView tvfacetipdesc1;

    @BindView(R.id.iv_tipfaceimg1)
    ImageView ivfacetip1;

    private TipAdapter mTipListAdapter;


    private Integer[] mThumbIds = {R.drawable.special_hair_style1,R.drawable.special_hair_style2,R.drawable.special_hair_style3};

    public static FaceTipsFragment newInstance(){
        FaceTipsFragment faceTipsFragment=new FaceTipsFragment();

        return faceTipsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] tipListArray = getResources().getStringArray(R.array.face_tip_list);
        List<String> tipList = new ArrayList<>(Arrays.asList(tipListArray));

        mTipListAdapter = new TipAdapter(tipList);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_face_tips, container, false);
        ButterKnife.bind(this, rootView);

        sptiplist.setAdapter(mTipListAdapter);
        showdata();
        return rootView;
    }

    private void showdata()
    {
        tvfacetiptitle.setText(R.string.face_title);
        tvfacetipdesc.setText(R.string.sample_facetips);
        tvfacetiptitle1.setText(R.string.face_title1);
        tvfacetipdesc1.setText(R.string.sample_facetips1);
        Random random = new Random();
        int randomInt = random.nextInt(3);

        Toast.makeText(getContext(),"ImageRandom"+mThumbIds.length,Toast.LENGTH_SHORT).show();

        // String imageUrl = MyanmarAttractionsConstants.IMAGE_ROOT_DIR + attraction.getImages()[0];
        Glide.with(ivfacetip.getContext())
                .load(mThumbIds[randomInt])
             //   .centerCrop()
                .into(ivfacetip);

        // String imageUrl = MyanmarAttractionsConstants.IMAGE_ROOT_DIR + attraction.getImages()[0];
        Glide.with(ivfacetip1.getContext())
                .load(R.drawable.jewelleryforroundface)
              //  .centerCrop()
                .into(ivfacetip1);
    }

    @OnItemSelected(R.id.sp_tip_list)
    public void OnSelectedSpinner(){
        String spinnertext=sptiplist.getSelectedItem().toString();
      //  tvfacetiptitle.setText(sptiplist.getSelectedItem().toString());
       Toast.makeText(getContext(),"Spinner selected Data"+spinnertext,Toast.LENGTH_SHORT).show();
    }
}