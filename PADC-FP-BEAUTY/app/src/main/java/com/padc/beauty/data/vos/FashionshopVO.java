package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 9/16/2016.
 */
public class FashionshopVO {
    @SerializedName("shop-id")
    private long shopid;

    @SerializedName("shop-name")
    private String shop_name;

    @SerializedName("direction-to-shop")
    private String direction_to_shop;

    @SerializedName("full_address")
    private String full_address;

    @SerializedName("photos")
    private String photos;

    public String getShop_name() {
        return shop_name;
    }

    public String getDirection_to_shop() {
        return direction_to_shop;
    }

    public String getFull_address() {
        return full_address;
    }

    public long getShopid() {

        return shopid;
    }

    public String getPhotos() {
        return photos;
    }
}
