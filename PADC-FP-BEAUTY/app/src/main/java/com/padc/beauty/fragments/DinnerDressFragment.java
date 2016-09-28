package com.padc.beauty.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.adapters.DressingAdapter;
import com.padc.beauty.data.models.DressingModel;
import com.padc.beauty.data.persistence.BeautyContract;
import com.padc.beauty.data.vos.DressingVO;
import com.padc.beauty.events.DataEvent;
import com.padc.beauty.utils.BeautyAppConstant;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by windows on 9/16/2016.
 */
public class DinnerDressFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>  {

    @BindView(R.id.rv_freedress)
    RecyclerView rvdress;

    private DressingAdapter mDressAdapter;

    public static DinnerDressFragment newInstance() {
        return new DinnerDressFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_free_dress, container, false);
        ButterKnife.bind(this, view);
        int gridColumnSpanCount = getResources().getInteger(R.integer.tip_list_grid);
        rvdress.setLayoutManager(new GridLayoutManager(getContext(), gridColumnSpanCount));
        List<DressingVO> dressingList = DressingModel.getInstance().getmDressingList();
        mDressAdapter=new DressingAdapter(dressingList);
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                BeautyContract.DressingEntry.CONTENT_URI,
                null,
                BeautyContract.DressingEntry.COLUMN_TYPE + " = ?",
                new String[]{"free"},
                BeautyContract.DressingEntry.COLUMN_DRESSINGID + " ASC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        List<DressingVO> dressingList = new ArrayList<>();
        if (data != null && data.moveToFirst()) {
            do {
                DressingVO dressing = DressingVO.parseFromCursor(data);
                dressing.setHairstyles(DressingModel.loadHairStyleByDressingID(dressing.getid()));
                dressing.setBodyshapes(DressingModel.loadBodyShapeByDressingID(dressing.getid()));
                dressing.setSkintypes(DressingModel.loadSkinTypeByDressingID(dressing.getid()));
                dressing.setSkincolors(DressingModel.loadSkinColorByDressingID(dressing.getid()));
                dressingList.add(dressing);
            } while (data.moveToNext());
        }

        Log.d(BeautyApp.TAG, "Retrieved Free Dressing : " + dressingList.size());
        mDressAdapter.setNewData(dressingList);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getSupportLoaderManager().initLoader(BeautyAppConstant.DRESSINGS_FREELIST_LOADER, null, this);
    }
}
