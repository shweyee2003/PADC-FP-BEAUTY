package com.padc.beauty.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.padc.beauty.R;
import com.padc.beauty.adapters.FashionshopAdapter;
import com.padc.beauty.data.models.FashionshopModel;
import com.padc.beauty.data.vos.FashionshopVO;
import com.padc.beauty.views.holders.FashionshopViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by Asus on 9/13/2016.
 */
public class FashionshopFragment extends Fragment {
//    @BindView(R.id.tv_papillon)
//    TextView fashionPapillon;
//    @BindView(R.id.tv_mk)
//    TextView fashionMk;
//    @BindView(R.id.tv_baza)
//    TextView fashionBaza;
//    @BindView(R.id.tv_fashion_dream)
//    TextView fashionDream;
//    @BindView(R.id.tv_silverstar)
//    TextView fashionSilverstar;
//    @BindView(R.id.tv_sulecenterpoint)
//    TextView fashionSule;

    @BindView(R.id.rv_attractions)
    RecyclerView rvAttractions;

    private FashionshopAdapter mAttractionAdapter;
    private FashionshopViewHolder.ControllerAttractionItem controllerAttractionItem;
    private BroadcastReceiver mDataLoadedBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //TODO instructions when the new data is ready.
            String extra = intent.getStringExtra("key-for-extra");
            Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

            List<FashionshopVO> newMealsList = FashionshopModel.getInstance().getFashionList();
            //FashionshopAdapter.setNewData(newMealsList);
        }
    };

    public static FashionshopFragment newInstance(){
        FashionshopFragment fashionshopFragment = new FashionshopFragment();
        return fashionshopFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        List<FashionshopVO> fashionshopList = FashionshopModel.getInstance().getFashionList();
        mAttractionAdapter = new FashionshopAdapter(fashionshopList);
        rvAttractions.setAdapter(mAttractionAdapter);

        int gridColumnSpanCount = getResources().getInteger(R.integer.attraction_list_grid);
        rvAttractions.setLayoutManager(new GridLayoutManager(getContext(), gridColumnSpanCount));

        return rootView;
    }
    private void showdata()
    {
//        fashionPapillon.setText(Html.fromHtml(getString(R.string.papillon)));
//        fashionMk.setText(Html.fromHtml(getString(R.string.mk)));
//        fashionBaza.setText(Html.fromHtml(getString(R.string.baza)));
//        fashionDream.setText(Html.fromHtml(getString(R.string.fahsiondream)));
//        fashionSilverstar.setText(Html.fromHtml(getString(R.string.silverstar)));
//        fashionSule.setText(Html.fromHtml(getString(R.string.sulecenterpoint)));
    }

    @Override
    public void onStart() {
        super.onStart();
        //LocalBroadcastManager.getInstance(getContext()).registerReceiver(mDataLoadedBroadcastReceiver,
          //      new IntentFilter(FashionshopModel.BROADCAST_DATA_LOADED));

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
       // LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(mDataLoadedBroadcastReceiver);

        EventBus eventBus = EventBus.getDefault();
        eventBus.unregister(this);
    }
}
