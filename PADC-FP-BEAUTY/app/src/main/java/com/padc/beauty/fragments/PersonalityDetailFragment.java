package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.data.models.PersonalityDetailModel;
import com.padc.beauty.data.vos.BeautySaloonVO;
import com.padc.beauty.data.vos.PerDetailVO;
import com.padc.beauty.data.vos.PersonalityDetailVO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows on 9/17/2016.
 */
public class PersonalityDetailFragment extends Fragment {

    @BindView(R.id.tv_personality_title)
    TextView tvpersonalitytitle;

    @BindView(R.id.tv_personality_Desc)
    TextView tvpersonalitydesc;

    @BindView(R.id.iv_personality)
    ImageView ivpersonality;

    private View mView;

    private static final String BARG_PERSONALITY_INDEX = "BARG_PERSONALITY_INDEX";
    private static final String BARG_TIP_ID = "BARG_TIP_ID";
    private PersonalityDetailVO personalityDetailVO;
    private PerDetailVO mperDtlVO;
    private List<PerDetailVO> perDtlVOList;
    private List<PersonalityDetailVO> mpersonalityDetailList;
    private int personalityIndex;
    private long tipid;

    public static PersonalityDetailFragment newInstance(long tipid,int personalityIndex){
        PersonalityDetailFragment personalitydetailfragment = new PersonalityDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BARG_PERSONALITY_INDEX, personalityIndex);
        bundle.putLong(BARG_TIP_ID, tipid);
        personalitydetailfragment.setArguments(bundle);
        return personalitydetailfragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            personalityIndex = bundle.getInt(BARG_PERSONALITY_INDEX);
            tipid=bundle.getLong(BARG_TIP_ID);
           // personalityDetailVO = PersonalityDetailModel.getInstance().getPersonalityByID(tipid);
            mpersonalityDetailList = PersonalityDetailModel.getInstance().getPersonalityList();
            personalityDetailVO=filterByPersonalityID();
            perDtlVOList=personalityDetailVO.getPersondtlVO();
            Log.d(BeautyApp.TAG,"dtlvolist"+perDtlVOList);
        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_personality_detail, container, false);
        ButterKnife.bind(this, mView);
        Log.d(BeautyApp.TAG, "onCreateView: "+perDtlVOList.size()+"INDEX"+personalityIndex);
        Log.d(BeautyApp.TAG,"title"+perDtlVOList.get(personalityIndex).getPersonalityTitle());
        tvpersonalitytitle.setText(perDtlVOList.get(personalityIndex).getPersonalityTitle());
        tvpersonalitydesc.setText(perDtlVOList.get(personalityIndex).getPersonalityContent());
       // ivpersonality.setImageResource(personalityDetailVO.getPersonalityImage());
        Glide.with(ivpersonality.getContext())
                .load(perDtlVOList.get(personalityIndex).getPersonalityImage())
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivpersonality);
        return  mView;
    }

    private PersonalityDetailVO filterByPersonalityID() {
        //List<PersonalityDetailVO> persondtllist = new ArrayList<>();
        for(PersonalityDetailVO personalitydtlVO:mpersonalityDetailList) {
            if(personalitydtlVO.getTipid()== tipid) {
                return  personalitydtlVO;
                //mpersonalityDetailList.add((PersonalityDetailVO) personalitydtlVO.getPersondtlVO());
              //mperDtlVO.( personalitydtlVO.getPersondtlVO());
              //  tvpersonalitytitle.setText( personalitydtlVO.getPersondtlVO().get(0).getPersonalityContent());

               // persondtllist.add(personalitydtlVO.getPersondtlVO());
            }
        }

        return null;
    }
}
