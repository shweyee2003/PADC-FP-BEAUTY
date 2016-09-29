package com.padc.beauty.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.BeautySaloonVO;

import butterknife.ButterKnife;

/**
 * Created by windows on 9/25/2016.
 */
public class TipViewHolder extends RecyclerView.ViewHolder {
    private BeautySaloonVO mbeauty;

    public TipViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(BeautySaloonVO beautysaloon) {
        mbeauty = beautysaloon;

//        tvname.setText(beautysaloon.getsaloonname());
//        tvaddr.setText(beautysaloon.getdirectiontosaloon());
//        String imageUrl =  beautysaloon.getPhoto();
//
//        Glide.with(ivbeautysaloon.getContext())
//                .load(imageUrl)
//                .centerCrop()
//                .placeholder(R.drawable.stock_photo_placeholder)
//                .error(R.drawable.stock_photo_placeholder)
//                .into(ivbeautysaloon);
    }
}
