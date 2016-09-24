package com.padc.beauty.events;

import com.padc.beauty.data.vos.FashionshopVO;

import java.util.List;

/**
 * Created by aung on 7/9/16.
 */
public class DataEvent {
    public static class AttractionDataLoadedEvent {

        private String extraMessage;
        private List<FashionshopVO> fashionshopsList;

        public AttractionDataLoadedEvent(String extraMessage, List<FashionshopVO> fashionshopsList) {
            this.extraMessage = extraMessage;
            this.fashionshopsList = fashionshopsList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<FashionshopVO> getFashionshopsList() {
            return fashionshopsList;
        }
    }


    public static class RefreshUserLoginStatusEvent {

    }
    public static class FashionshopsLoadedEvent {

        private String extraMessage;
        private List<FashionshopVO> fashionshopsList;

        public FashionshopsLoadedEvent(String extraMessage, List<FashionshopVO> fashionshopsList) {
            this.extraMessage = extraMessage;
            this.fashionshopsList = fashionshopsList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<FashionshopVO> getFashionshopsList() {
            return fashionshopsList;
        }
    }
}