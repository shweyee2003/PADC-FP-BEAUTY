package com.padc.beauty.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.beauty.R;
import com.padc.beauty.data.vos.DressingVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows on 9/23/2016.
 */
public class DressingViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_price)
    TextView tvprice;

    @BindView(R.id.iv_dress)
    ImageView ivdress;

    @BindView(R.id.tv_shopname)
    TextView tvShopName;

    @BindView(R.id.tv_shopdirection)
    TextView tvShopDirection;

    @BindView(R.id.tv_hairstyle)
    TextView tvHairStyle;

    @BindView(R.id.tv_bodyshape)
    TextView tvBodyShape;

    @BindView(R.id.tv_skincolor)
    TextView tvSkinColor;

    @BindView(R.id.tv_skintype)
    TextView tvSkinType;

    private DressingVO mdress;
    private String skintypes="";
    private String skincolors="";

    public DressingViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(DressingVO dress) {
        mdress = dress;
        String hairstyle="";
        tvShopName.setText(dress.getShopname());
        tvprice.setText(dress.getprice()+" Ks");
        tvShopDirection.setText(dress.getShopdirection());
        tvHairStyle.setText(showsuitablepersondata(dress.getHairstyles()));;
        tvSkinColor.setText(showsuitablepersondata(dress.getSkincolors()));
        tvSkinType.setText(showsuitablepersondata(dress.getSkintypes()));
        tvBodyShape.setText(showsuitablepersondata(dress.getBodyshapes()));

        String imageUrl =  dress.getimgurl();
       // Log.d(BeautyApp.TAG,"imageurl:"+imageUrl);
        Glide.with(ivdress.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivdress);

    }

    private String showsuitablepersondata(String[] suitableperson)
    {
        String suitablepersons="";

        for(int index=0;index<suitableperson.length;index++)
        {

            suitablepersons = suitablepersons + suitableperson[index] + "\n" ;
        }
        return suitablepersons;
    }

}
