package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by windows on 9/24/2016.
 */
public class TipVO {
    @SerializedName("tip-id")
    private long id;

    @SerializedName("ip-category")
    private String tipcategory;

    @SerializedName("image")
    private String img_url;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("for-face-types")
    private String[] facetypes;

    @SerializedName("for-skin-colors")
    private String[] skincolors;

    @SerializedName("for-body-shapes")
    private String[] bodyshapes;

    @SerializedName("for-hair-color")
    private String[] hairstyles;

    @SerializedName("for-skin-types")
    private String[] skintypes;

    public long getId() {
        return id;
    }

    public String getTipcategory() {
        return tipcategory;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String[] getFacetypes() {
        return facetypes;
    }

    public String[] getSkincolors() {
        return skincolors;
    }

    public String[] getBodyshapes() {
        return bodyshapes;
    }

    public String[] getHairstyles() {
        return hairstyles;
    }

    public String[] getSkintypes() {
        return skintypes;
    }
}
