package com.padc.beauty.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.BeautySaloonVO;
import com.padc.beauty.data.vos.ServiceVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asus on 9/29/2016.
 */
public class ServicesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_service_title)
    TextView tvname;

    @BindView(R.id.tv_services_description)
    TextView tvaddr;

    @BindView(R.id.iv_services_image)
    ImageView ivbeautysaloon;

    private BeautySaloonVO mbeauty;
    private ControllerBeautysalonItem mController;
    private ServiceVO mServices;

    public ServicesViewHolder(View itemView, ControllerBeautysalonItem controller) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        mController = controller;
    }

    public void bindServicesData(ServiceVO services) {
        mServices = services;

        tvname.setText(services.getservicetitle());
        tvaddr.setText(services.getdescription());
        String imageUrl =  services.getimgurl();

        Glide.with(ivbeautysaloon.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivbeautysaloon);
    }
    @Override
    public void onClick(View view) {
        mController.onTapAttraction(mbeauty, ivbeautysaloon);
    }

    public interface ControllerBeautysalonItem {
        void onTapAttraction(BeautySaloonVO beautysalon, ImageView ivbeautysaloon);
    }
}