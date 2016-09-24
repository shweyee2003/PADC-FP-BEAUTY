package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by windows on 9/22/2016.
 */
public class DressingVO {
    @SerializedName("dressing-id")
    private int id;

    @SerializedName("dressing-type")
    private String dressingtype;

    @SerializedName("image")
    private String img_url;

    @SerializedName("description")
    private String description;

    @SerializedName("estimate-price")
    private String price;

    @SerializedName("rating")
    private String rating;

    @SerializedName("for-skin-colors")
    private String[] skincolors;

    @SerializedName("for-body-shapes")
    private String[] bodyshapes;

    @SerializedName("for-hair-styles")
    private String[] hairstyles;

    @SerializedName("for-skin-types")
    private String[] skintypes;

    @SerializedName("shop-id")
    private long shopid;

    @SerializedName("shop-name")
    private String shopname;

    @SerializedName("direction-to-shop")
    private String shopdirection;

    @SerializedName("promotion")
    private String promotion;

    public int getid(){return id;}

    public String getdresstype(){return dressingtype;}

    public String getimgurl(){return img_url;}

    public String getDescription(){return description;}

    public String getprice(){return price;}

    public String getrating(){return rating;}

    public String[] getSkincolors(){
        return skincolors;
    }

    public String[] getSkintypes(){
        return skintypes;
    }

    public String[] getHairstyles(){
        return hairstyles;
    }

    public String[] getBodyshapes(){
        return bodyshapes;
    }

    public long getshopid(){return shopid;}

    public String getShopname(){return shopname;}

    public String getShopdirection(){return shopdirection;}

    public String getPromotion(){return promotion;}
}
