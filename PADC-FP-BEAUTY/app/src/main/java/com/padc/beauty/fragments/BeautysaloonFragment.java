package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padc.beauty.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 9/13/2016.
 */
public class BeautysaloonFragment extends Fragment {
    @BindView(R.id.tv_lili)
    TextView tvLiLi;
    @BindView(R.id.tv_koko)
    TextView tvKoKo;
    @BindView(R.id.tv_seri)
    TextView tvSeri;
    @BindView(R.id.tv_spamyway)
    TextView tvSpaMyway;
    @BindView(R.id.tv_inyadayspa)
    TextView tvInyaDaySpa;
    @BindView(R.id.tv_tonytuntun)
    TextView tvTonyTunTun;

    public static BeautysaloonFragment newInstance(){
        BeautysaloonFragment beautysaloonFragment = new BeautysaloonFragment();
        return beautysaloonFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_beautysaloon, container, false);
        ButterKnife.bind(this, rootView);
        showdata();
        return rootView;
    }
    private void showdata()
    {
        tvLiLi.setText(Html.fromHtml(getString(R.string.lili_beautysalon)));
        tvKoKo.setText(Html.fromHtml(getString(R.string.koko_beautysalon)));
        tvSeri.setText(Html.fromHtml(getString(R.string.seri_beautysalon)));
        tvSpaMyway.setText(Html.fromHtml(getString(R.string.spamyway_beautysalon)));
        tvInyaDaySpa.setText(Html.fromHtml(getString(R.string.inyaday_spa)));
        tvTonyTunTun.setText(Html.fromHtml(getString(R.string.tonytuntun_beautysalon)));
    }
}
