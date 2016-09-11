package com.padc.beauty.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.padc.beauty.R;
import com.padc.beauty.adapters.BodyshapeListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class SpecialtipActivityFragment extends Fragment {
    @BindView(R.id.sp_bodyshape)
    Spinner spBodyshapeList;
    @BindView(R.id.lbl_tips_title)
    TextView lblTipsTitle;
    private BodyshapeListAdapter mBodyshapeListAdapter;
    private FragmentChangeListener mChangeFragment;
    public static SpecialtipActivityFragment newInstance() {
        SpecialtipActivityFragment fragment = new SpecialtipActivityFragment();
        return fragment;
    }
    public SpecialtipActivityFragment() {
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mChangeFragment = (FragmentChangeListener) context;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] bodyshapeListArray = getResources().getStringArray(R.array.body_shape);
        List<String> bodyshapeList = new ArrayList<>(Arrays.asList(bodyshapeListArray));

        mBodyshapeListAdapter = new BodyshapeListAdapter(bodyshapeList);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_specialtip, container, false);
        ButterKnife.bind(this, rootView);
        spBodyshapeList.setAdapter(mBodyshapeListAdapter);
        lblTipsTitle.setText("Special Tips for you");
        return rootView;
    }

    @OnClick(R.id.btn_ok)
    public void onTapOk(Button btnOk) {
        Fragment fr=new ShowResultFragment();
        FragmentChangeListener fc=(FragmentChangeListener)getActivity();
        fc.replaceFragment(fr);
    }

    public interface FragmentChangeListener {
        public void replaceFragment(Fragment fragment);
    }
}
