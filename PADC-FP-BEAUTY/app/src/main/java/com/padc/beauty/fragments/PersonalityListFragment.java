package com.padc.beauty.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.padc.beauty.R;
import com.padc.beauty.activities.PersonalityDetailActivity;
import com.padc.beauty.activities.WorkoutDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by windows on 9/17/2016.
 */
public class PersonalityListFragment extends Fragment {
    @BindView(R.id.ll_good_personality)
    LinearLayout llgoodpersonality;
    public static PersonalityListFragment newInstance() {
        return new PersonalityListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personality_list, container, false);
        ButterKnife.bind(this, view);
        return view;


    }

    @OnClick(R.id.ll_good_personality)
    public void onTapPersonality(){
        Intent intent = PersonalityDetailActivity.newIntent();
        startActivity(intent);
    }
}
