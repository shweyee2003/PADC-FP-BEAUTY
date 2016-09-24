package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by windows on 9/20/2016.
 */
public class BeautySaloonVO {

    @SerializedName("saloon-id")
    private long saloonid;

    @SerializedName("saloon-name")
    private String saloon_name;

    @SerializedName("direction-to-saloon")
    private String direction_to_saloon;

    @SerializedName("full-address")
    private String full_address;

    @SerializedName("photos")
    private String photo;

    @SerializedName("open daily")
    private String opendaily;

    @SerializedName("available-services")
    private ArrayList<ServiceVO> available_services;

    public long getsaloonid(){return saloonid;}

    public String getsaloonname(){return saloon_name;}

    public String getdirectiontosaloon(){return direction_to_saloon;}

    public String getfulladdr(){return full_address;}

    public String getPhoto(){return photo;}

    public String getOpendaily(){return opendaily;}

    public ArrayList<ServiceVO> getAvailable_services() {
        return available_services;
    }


}
