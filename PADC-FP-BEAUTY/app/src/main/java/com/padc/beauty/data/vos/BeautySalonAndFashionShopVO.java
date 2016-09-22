package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 9/20/2016.
 */
public class BeautySalonAndFashionShopVO {
    @SerializedName("fashion-shops")
    private String Fashionshops;
    class Fashionshops
    {
        @SerializedName("shop-id")
        private String shopid;
        @SerializedName("shop-name")
        private String shopname;
        @SerializedName("direction-to-shop")
        private String directionToShop;
        @SerializedName("full-address")
        private String fullAddress;
        @SerializedName("photos")
        private String photos;
    }
}
