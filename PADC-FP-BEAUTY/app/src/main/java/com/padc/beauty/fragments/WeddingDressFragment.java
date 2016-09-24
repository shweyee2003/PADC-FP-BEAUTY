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
import com.padc.beauty.adapters.OccassionalDressAdapter;
import com.padc.beauty.data.models.DressingModel;
import com.padc.beauty.data.vos.DressingVO;
import com.padc.beauty.events.DataEvent;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by windows on 9/14/2016.
 */
public class WeddingDressFragment extends Fragment {

    @BindView(R.id.rv_occassionaldress)
    RecyclerView rvdress;

    private int gridColumnSpanCount=1;

    private OccassionalDressAdapter mDressAdapter;

    public static WeddingDressFragment newInstance() {
        return new WeddingDressFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_occassional_dress, container, false);
        ButterKnife.bind(this, view);
        rvdress.setLayoutManager(new GridLayoutManager(getContext(), gridColumnSpanCount));
        List<DressingVO> dressingList = DressingModel.getInstance().getmDressingList();
        mDressAdapter = new OccassionalDressAdapter(dressingList);
        rvdress.setAdapter(mDressAdapter);
        return view;
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

    public void onEventMainThread(DataEvent.DressingDataLoadedEvent event) {
        String extra = event.getExtraMessage();
        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        List<DressingVO> newDressingList = event.getDressingList();
        mDressAdapter.setNewData(newDressingList);
    }

}
