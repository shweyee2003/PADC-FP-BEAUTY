package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by windows on 9/20/2016.
 */
public class ServiceVO {
    @SerializedName("service-id")
    private long serviceid;

    @SerializedName("service-title")
    private String service_title;

    @SerializedName("image")
    private String image;

    @SerializedName("description")
    private String description;

    public long getserviceid(){return serviceid;}

    public String getservicetitle(){return service_title;}

    public String getimgurl(){return image;}

    public String getdescription(){return description;}

}
