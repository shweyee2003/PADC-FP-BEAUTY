package com.padc.beauty.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.PersonalityDetailVO;
import com.padc.beauty.data.vos.TipVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 9/14/2016.
 */
public class WorkoutDetailFragment extends Fragment {
    @BindView(R.id.tv_cardio)
    TextView cardio;
    @BindView(R.id.tv_capoeria)
    TextView capoeria;

    public static WorkoutDetailFragment newInstance(){
        WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
        return workoutDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_workoutdetail, container, false);
        ButterKnife.bind(this, rootView);
        showdata();
        return rootView;
    }
    private void showdata()
    {
        cardio.setText(Html.fromHtml(getString(R.string.cardio_exercise)));
        capoeria.setText(Html.fromHtml(getString(R.string.capoeria_exercise)));
    }

}
