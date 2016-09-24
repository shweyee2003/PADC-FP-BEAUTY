package com.padc.beauty.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.FashionshopVO;
import com.padc.beauty.views.holders.FashionshopViewHolder;

import java.util.List;

/**
 * Created by Asus on 9/17/2016.
 */
public class FashionshopAdapter extends RecyclerView.Adapter<FashionshopViewHolder> {

    private LayoutInflater mInflater;
    private List<FashionshopVO> mFashionshopsList;
   // private FashionshopViewHolder.ControllerAttractionItem mControllerAttractionItem;

    public FashionshopAdapter(List<FashionshopVO> fashionshopList) {
        mInflater = LayoutInflater.from(BeautyApp.getContext());
        mFashionshopsList = fashionshopList;
      // mControllerAttractionItem = (AttractionViewHolder.ControllerAttractionItem) controllerAttractionItem;
    }

    @Override
    public FashionshopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_item_attraction, parent, false);
        return new FashionshopViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FashionshopViewHolder holder, int position) {
        holder.bindData(mFashionshopsList.get(position));
    }


    @Override
    public int getItemCount() {
        return mFashionshopsList.size();
    }

    public void setNewData(List<FashionshopVO> newAttractionList) {
        mFashionshopsList = newAttractionList;
        notifyDataSetChanged();
    }
}
