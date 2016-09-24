package com.padc.beauty.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.FashionshopVO;
import com.padc.beauty.utils.BeautyAppConstant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 9/23/2016.
 */
public class FashionshopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.tv_attraction_title)
    TextView tvAttractionTitle;

    @BindView(R.id.tv_attraction_desc)
    TextView tvAttractionDesc;

    @BindView(R.id.iv_attraction)
    ImageView ivAttraction;

    private ControllerAttractionItem mController;
    private FashionshopVO mAttraction;

    public FashionshopViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        //mController = controller;
    }

    public void bindData(FashionshopVO attraction) {
        mAttraction = attraction;
        tvAttractionTitle.setText(attraction.getShop_name());
        tvAttractionDesc.setText(attraction.getFull_address());

        String imageUrl = attraction.getPhotos();

        Glide.with(ivAttraction.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivAttraction);
    }

    @Override
    public void onClick(View view) {
        //mController.onTapAttraction(mAttraction, ivAttraction);
    }

    public interface ControllerAttractionItem {
       // void onTapAttraction(FashionshopVO attraction, ImageView ivAttraction);
    }
}

