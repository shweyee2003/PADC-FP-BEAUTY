package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by windows on 9/20/2016.
 */
public class FashionShopVO {
    @SerializedName("shop-id")
    private long shopid;

    @SerializedName("shop-name")
    private String shop_name;

    @SerializedName("direction-to-shop")
    private String direction_to_shop;

    @SerializedName("full-address")
    private String full_address;

    @SerializedName("photos")
    private String photo;

    public long getshopid(){return shopid;}

    public String getshopname(){return shop_name;}

    public String getdirectiontoshop(){return direction_to_shop;}

    public String getfulladdr(){return full_address;}

    public String getPhoto(){return photo;}
}
