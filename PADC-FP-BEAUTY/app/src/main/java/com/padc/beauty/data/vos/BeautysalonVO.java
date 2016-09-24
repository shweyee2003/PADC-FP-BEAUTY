package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Asus on 9/20/2016.
 */
public class BeautysalonVO {
    @SerializedName("saloon-id")
    private long saloonid;

    @SerializedName("saloon-name")
    private String saloon_name;

    @SerializedName("direction-to-saloon")
    private String direction_to_saloon;

    @SerializedName("full_address")
    private String full_address;

    @SerializedName("available-services")
    private ArrayList<ServicesVO> available_services;

    public long getsaloonid(){return saloonid;}

    public String getsaloonname(){return saloon_name;}

    public String getdirectiontosaloon(){return direction_to_saloon;}

    public String getfulladdr(){return full_address;}

    public ArrayList<ServicesVO> getServiceList() {
        return available_services;
    }
}
