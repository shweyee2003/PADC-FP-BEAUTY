package com.padc.beauty.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.BeautySaloonVO;
import com.padc.beauty.data.vos.ServiceVO;
import com.padc.beauty.data.vos.TipVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows on 9/24/2016.
 */
public class BeautySaloonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_beautysaloonname)
    TextView tvname;

    @BindView(R.id.tv_beautysaloonaddr)
    TextView tvaddr;

    @BindView(R.id.tv_openhr)
    TextView tvOpenhr;

    @BindView(R.id.iv_beautysaloon)
    ImageView ivbeautysaloon;

    private BeautySaloonVO mbeauty;
    private ControllerBeautysalonItem mController;
    private ServiceVO mServices;

    public BeautySaloonViewHolder(View itemView, ControllerBeautysalonItem controller) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        mController = controller;
    }

    public void bindData(BeautySaloonVO beautysaloon) {
        mbeauty = beautysaloon;

        tvname.setText(beautysaloon.getsaloonname());
        tvaddr.setText(beautysaloon.getdirectiontosaloon());
        tvOpenhr.setText("Open Daily : "+beautysaloon.getOpendaily());
        String imageUrl =  beautysaloon.getPhoto();

        Glide.with(ivbeautysaloon.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivbeautysaloon);
    }

    @Override
    public void onClick(View view) {
        mController.onTapBeautysalon(mbeauty, ivbeautysaloon);
    }

    public interface ControllerBeautysalonItem {
        void onTapBeautysalon(BeautySaloonVO beautysalon, ImageView ivbeautysaloon);
    }

}
