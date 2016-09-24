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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

/**
 * Created by windows on 9/7/2016.
 */
public class BodyShapeTipsFragment extends Fragment {

    @BindView(R.id.sp_tip_list)
    Spinner sptiplist;

    @BindView(R.id.tv_bodyshape_title_dress)
    TextView tvbodytiptitledress;

    @BindView(R.id.tv_bodyshape_desc_dress)
    TextView tvbodytipdescdress;

    @BindView(R.id.iv_bodyshape_dress)
    ImageView ivbodyshapedress;

    @BindView(R.id.tv_bodyshape_title_do_and_dont)
    TextView tvbodytiptitledoanddont;

    @BindView(R.id.tv_bodyshape_desc_do_and_dont)
    TextView tvbodytipdescdoanddont;

    @BindView(R.id.iv_bodyshape_do_and_dont)
    ImageView ivbodyshapedoanddont;


    private FaceTipAdapter mTipListAdapter;
    public static BodyShapeTipsFragment newInstance(){
        BodyShapeTipsFragment bodyshapeTipsFragment=new BodyShapeTipsFragment();

        return bodyshapeTipsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] tipListArray = getResources().getStringArray(R.array.body_shape);
        List<String> tipList = new ArrayList<>(Arrays.asList(tipListArray));

        mTipListAdapter = new FaceTipAdapter(tipList);
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
        tvbodytiptitledress.setText(R.string.bodyshape_dress_title);
        tvbodytipdescdress.setText(R.string.bdshape_desc_dress);
        tvbodytiptitledoanddont.setText(R.string.bdshape_do_and_dont_title);
        tvbodytipdescdoanddont.setText(Html.fromHtml(getString(R.string.bdshape_desc_do_and_dont)));



        Glide.with(ivbodyshapedress.getContext())
                .load(R.drawable.howtodressapearshapedbody)
                .centerCrop()
                .into(ivbodyshapedress);

        Glide.with(ivbodyshapedoanddont.getContext())
                .load(R.drawable.doanddontpearshape)
                .placeholder(R.drawable.doanddontpearshape)
                .centerCrop()
                .into(ivbodyshapedoanddont);
    }

    @OnItemSelected(R.id.sp_tip_list)
    public void OnSelectedSpinner(){
        String spinnertext=sptiplist.getSelectedItem().toString();
      //  tvbodytiptitle.setText(sptiplist.getSelectedItem().toString());
       // Toast.makeText(getContext(),"Spinner selected Data"+spinnertext,Toast.LENGTH_SHORT).show();
    }
}