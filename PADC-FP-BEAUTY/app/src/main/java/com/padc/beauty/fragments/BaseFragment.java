package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.padc.beauty.R;
import com.padc.beauty.adapters.TipAdapter;
import com.padc.beauty.utils.BeautyAppConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by windows on 9/9/2016.
 */
public class BaseFragment extends Fragment {

    public TipAdapter mTipListAdapter;
    private BeautyAppConstant beautyAppConstant;

    String[] tipListArray;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
