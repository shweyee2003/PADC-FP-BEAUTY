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

    @BindView(R.id.tv_sunglasstip_title)
    TextView tvsunglasstiptitle;

    @BindView(R.id.tv_sunglasstip_desc)
    TextView tvsunglasstipdesc;

    @BindView(R.id.iv_sunglasstip)
    ImageView ivsunglasstip;

    @BindView(R.id.tv_jewelrytip_title)
    TextView tvjewlrytiptitle;

    @BindView(R.id.tv_jewelrytip_desc)
    TextView tvjewlrytipdesc;

    @BindView(R.id.iv_jewelrytip)
    ImageView ivjewelrytip;

    private TipAdapter mTipListAdapter;


    private Integer[] mhairstyleids = {R.drawable.special_hair_style1,R.drawable.special_hair_style2,R.drawable.special_hair_style3};


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
        tvfacetiptitle.setText(R.string.hairstyle_facetip_title);
        tvsunglasstiptitle.setText(R.string.sunglass_facetip_title);
        tvjewlrytiptitle.setText(R.string.jewlery_facetip_title);

        Random random = new Random();
        int randomInt = random.nextInt(3);

      //  Toast.makeText(getContext(),"ImageRandom"+ mhairstyleids.length,Toast.LENGTH_SHORT).show();
        tvfacetipdesc.setText(Html.fromHtml(getString(R.string.hairstyle_facetips)));
        tvsunglasstipdesc.setText(Html.fromHtml(getString(R.string.sunglasses_facetips)));
        tvjewlrytipdesc.setText(Html.fromHtml(getString(R.string.jewellery_facetips)));

        Glide.with(ivfacetip.getContext())
                .load(mhairstyleids[randomInt])
             //   .centerCrop()
                .into(ivfacetip);


        Glide.with(ivsunglasstip.getContext())
                .load(R.drawable.sunglassforroundface)
              //  .centerCrop()
                .into(ivsunglasstip);

        Glide.with(ivjewelrytip.getContext())
                .load(R.drawable.accessories_for_roundface)
                //  .centerCrop()
                .into(ivjewelrytip);
    }

    @OnItemSelected(R.id.sp_tip_list)
    public void OnSelectedSpinner(){
        String spinnertext=sptiplist.getSelectedItem().toString();
      //  tvfacetiptitle.setText(sptiplist.getSelectedItem().toString());
       Toast.makeText(getContext(),"Spinner selected Data"+spinnertext,Toast.LENGTH_SHORT).show();
    }
}