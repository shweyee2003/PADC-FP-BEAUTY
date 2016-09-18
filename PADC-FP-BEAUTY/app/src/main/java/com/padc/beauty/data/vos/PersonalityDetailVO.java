package com.padc.beauty.data.vos;

/**
 * Created by aung on 6/24/16.
 */
public class PersonalityDetailVO {
    private String PersonalityTitle;
    private String PersonalityContent;
    private int PersonalityImage;

    public PersonalityDetailVO(String personalityTitle, String personalityContent, int personalityImage) {
        this.PersonalityTitle = personalityTitle;
        this.PersonalityContent = personalityContent;
        this.PersonalityImage = personalityImage;
    }

    public String getPersonalityTitle() {
        return PersonalityTitle;
    }

    public String getPersonalityContent() {
        return PersonalityContent;
    }

    public int getPersonalityImage() {
        return PersonalityImage;
    }
}
