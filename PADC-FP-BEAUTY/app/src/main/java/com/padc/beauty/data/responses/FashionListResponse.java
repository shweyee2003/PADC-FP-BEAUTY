package com.padc.beauty.data.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.beauty.data.vos.BeautysalonVO;
import com.padc.beauty.data.vos.FashionshopVO;

import java.util.ArrayList;

/**
 * Created by Asus on 9/19/2016.
 */
public class FashionListResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("fashion-shops")
    private ArrayList<FashionshopVO> fashionList;

    @SerializedName("beauty-saloons")
    private ArrayList<BeautysalonVO> beautysalonsList;

    public ArrayList<BeautysalonVO> getBeautysalonsList() {
        return beautysalonsList;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<FashionshopVO> getFashionList() {
        return fashionList;
    }

}
