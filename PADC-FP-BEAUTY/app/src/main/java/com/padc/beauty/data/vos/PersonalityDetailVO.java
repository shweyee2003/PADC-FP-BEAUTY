package com.padc.beauty.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aung on 6/24/16.
 */
public class PersonalityDetailVO {
    @SerializedName("tip-id")
    private long tipid;

    @SerializedName("title")
    private String PersonalityTitle;

    @SerializedName("image")
    private String PersonalityImage;

    @SerializedName("description")
    private String PersonalityContent;

    public PersonalityDetailVO(Long Tipid,String personalityTitle, String personalityContent, String personalityImage) {
        this.PersonalityTitle = personalityTitle;
        this.PersonalityContent = personalityContent;
        this.PersonalityImage = personalityImage;
        this.tipid=Tipid;
    }

    public long getTipid() {
        return tipid;
    }

    public String getPersonalityTitle() {
        return PersonalityTitle;
    }

    public String getPersonalityContent() {
        return PersonalityContent;
    }

    public String  getPersonalityImage() {
        return PersonalityImage;
    }
}
