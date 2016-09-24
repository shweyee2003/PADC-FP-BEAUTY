package com.padc.beauty.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.DressingVO;
import com.padc.beauty.views.holders.OccassionalDressViewHolder;

import java.util.List;

/**
 * Created by windows on 9/23/2016.
 */
public class OccassionalDressAdapter extends RecyclerView.Adapter<OccassionalDressViewHolder>  {
    private List<DressingVO> mDressingList;
    private LayoutInflater inflater;

    public OccassionalDressAdapter(List<DressingVO> dressingList){
        inflater = LayoutInflater.from(BeautyApp.getContext());
        mDressingList = dressingList;

    }

    @Override
    public OccassionalDressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.view_item_occasionaldress, parent, false);
        return new OccassionalDressViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OccassionalDressViewHolder holder, int position) {
        holder.bindData(mDressingList.get(position));
    }

    @Override
    public int getItemCount() {
        return  mDressingList.size();
    }

    public void setNewData(List<DressingVO> newDressList) {
        mDressingList = newDressList;
        notifyDataSetChanged();//framework method
    }
}
