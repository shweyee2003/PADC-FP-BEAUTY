package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.beauty.R;
import com.padc.beauty.adapters.DinnerDressAdapter;
import com.padc.beauty.adapters.WeddingDressAdapter;
import com.padc.beauty.data.models.DinnerDressModel;
import com.padc.beauty.data.models.WeddingDressModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows on 9/16/2016.
 */
public class DinnerDressFragment extends Fragment {
    @BindView(R.id.rv_dinnerdress)
    RecyclerView rvdinnerdress;

    private DinnerDressAdapter mDinnerDressAdapter;

    public static DinnerDressFragment newInstance() {
        return new DinnerDressFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDinnerDressAdapter = new DinnerDressAdapter(DinnerDressModel.getInstance().getDinnerdressList());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dinner_dress, container, false);
        ButterKnife.bind(this, view);
        rvdinnerdress.setAdapter(mDinnerDressAdapter);
        //rvdinnerdress.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvdinnerdress.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }
}
