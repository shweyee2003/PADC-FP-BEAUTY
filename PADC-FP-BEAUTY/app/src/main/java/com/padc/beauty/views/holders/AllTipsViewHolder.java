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
 * Created by windows on 9/25/2016.
 */
public class AllTipsViewHolder extends RecyclerView.ViewHolder  {
    @BindView(R.id.tv_tips_title)
    TextView tvskintypetitle;

    @BindView(R.id.tv_tips_desc)
    TextView tvskintypedesc;

    @BindView(R.id.iv_tips)
    ImageView ivskintype;

    private TipVO mtip;

    public AllTipsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(TipVO tip) {
        mtip = tip;
        tvskintypetitle.setText(tip.getTitle());
        tvskintypedesc.setText(tip.getDescription());


        String imageUrl =  tip.getImg_url();
        // Log.d(BeautyApp.TAG,"imageurl:"+imageUrl);
        Glide.with(ivskintype.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivskintype);

    }
}
