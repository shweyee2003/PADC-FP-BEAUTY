package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 9/20/2016.
 */
public class ServicesVO {
    @SerializedName("service-id")
    private long serviceid;

    @SerializedName("service-title")
    private String service_title;

    @SerializedName("image")
    private String image;

    @SerializedName("description")
    private String description;

    public long getServiceid() {
        return serviceid;
    }

    public String getService_title() {
        return service_title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
