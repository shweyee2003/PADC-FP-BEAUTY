package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.beauty.R;
import com.padc.beauty.data.models.PersonalityDetailModel;
import com.padc.beauty.data.vos.PersonalityDetailVO;

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
    private PersonalityDetailVO personalityDetailVO;
    private int personalityIndex;

    public static PersonalityDetailFragment newInstance(int personalityindex){
        PersonalityDetailFragment personalitydetailfragment = new PersonalityDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BARG_PERSONALITY_INDEX, personalityindex);
        personalitydetailfragment.setArguments(bundle);
        return personalitydetailfragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            personalityIndex = bundle.getInt(BARG_PERSONALITY_INDEX);
            personalityDetailVO = PersonalityDetailModel.getInstance().getPersonalityDetail(personalityIndex);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_personality_detail, container, false);
        ButterKnife.bind(this, mView);
        tvpersonalitytitle.setText(personalityDetailVO.getPersonalityTitle());
        tvpersonalitydesc.setText(personalityDetailVO.getPersonalityContent());
        ivpersonality.setImageResource(personalityDetailVO.getPersonalityImage());
        return  mView;
    }
}
