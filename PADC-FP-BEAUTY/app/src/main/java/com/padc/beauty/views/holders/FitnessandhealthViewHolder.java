package com.padc.beauty.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.TipVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows on 9/27/2016.
 */
public class FitnessandhealthViewHolder extends RecyclerView.ViewHolder  {
    @BindView(R.id.tv_fitnessandhealth)
    TextView tvtitle;

    @BindView(R.id.iv_fitandhealth)
    ImageView ivfitnessandhealth;

    private TipVO mtip;

    public FitnessandhealthViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(TipVO tip) {
        mtip = tip;
        tvtitle.setText(tip.getTitle());
        String imageUrl =  tip.getImg_url();

        Glide.with(ivfitnessandhealth.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivfitnessandhealth);

    }
}
