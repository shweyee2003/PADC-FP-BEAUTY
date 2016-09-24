package com.padc.beauty.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.BeautySaloonVO;
import com.padc.beauty.data.vos.DressingVO;
import com.padc.beauty.data.vos.ServiceVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows on 9/24/2016.
 */
public class BeautySaloonViewHolder extends RecyclerView.ViewHolder  {

    @BindView(R.id.tv_beautysaloonname)
    TextView tvname;

    @BindView(R.id.tv_beautysaloonaddr)
    TextView tvaddr;

    @BindView(R.id.iv_beautysaloon)
    ImageView ivbeautysaloon;

    private BeautySaloonVO mbeauty;

    public BeautySaloonViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(BeautySaloonVO beautysaloon) {
        mbeauty = beautysaloon;

        tvname.setText(beautysaloon.getsaloonname());
        tvaddr.setText(beautysaloon.getdirectiontosaloon());
        String imageUrl =  beautysaloon.getPhoto();

        Glide.with(ivbeautysaloon.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivbeautysaloon);
    }

}
