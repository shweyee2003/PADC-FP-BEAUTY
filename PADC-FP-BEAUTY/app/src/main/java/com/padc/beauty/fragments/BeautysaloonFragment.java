package com.padc.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.padc.beauty.R;
import com.padc.beauty.adapters.BeautySaloonAdapter;
import com.padc.beauty.data.models.FashionShopandBeautySaloonModel;
import com.padc.beauty.data.vos.BeautySaloonVO;
import com.padc.beauty.events.DataEvent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by Asus on 9/13/2016.
 */
public class BeautysaloonFragment extends Fragment {
    @BindView(R.id.rv_beautysaloon)
    RecyclerView rvbeautysaloon;

    private int gridColumnSpanCount=2;

    private BeautySaloonAdapter mBeautySaloonAdapter;

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
        rvbeautysaloon.setLayoutManager(new GridLayoutManager(getContext(), gridColumnSpanCount));
        List<BeautySaloonVO> beautysaloonList = FashionShopandBeautySaloonModel.getInstance().getBeautySaloonList();
        //showdata();
        mBeautySaloonAdapter = new BeautySaloonAdapter(beautysaloonList);
        rvbeautysaloon.setAdapter(mBeautySaloonAdapter);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus eventBus = EventBus.getDefault();
        eventBus.unregister(this);
    }

    public void onEventMainThread(DataEvent.FahionShopandBeautySaloonDataLoadedEvent event) {
        String extra = event.getExtraMessage();
        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        List<BeautySaloonVO> newBeautySaloonList = event.getBeautySaloonList();
        mBeautySaloonAdapter.setNewData(newBeautySaloonList);
    }
}
