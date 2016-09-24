package com.padc.beauty.data.models;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.data.vos.FashionshopVO;
import com.padc.beauty.events.DataEvent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by Asus on 9/16/2016.
 */
public class FashionshopModel extends BaseModel{
    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    private static FashionshopModel objInstance;

    private List<FashionshopVO> mFashionList;

    private FashionshopModel() {
        super();
        mFashionList = new ArrayList<>();
        dataAgent.loadFashionshops();
    }

    public static FashionshopModel getInstance() {
        if (objInstance == null) {
            objInstance = new FashionshopModel();
        }
        return objInstance;
    }
    public void loadFashionshops(){
        dataAgent.loadFashionshops();
    }


    public List<FashionshopVO> getFashionList() {
        return mFashionList;
    }



    public void notifyFashionshopsLoaded(ArrayList<FashionshopVO> fashionshopList) {
        //Notify that the data is ready - using LocalBroadcast
        mFashionList = fashionshopList;

        //keep the data in persistent layer.
        // AttractionVO.saveAttractions(mAttractionList);

        broadcastFashionshopnLoadedWithEventBus();
        //broadcastAttractionLoadedWithLocalBroadcastManager();
    }

    public void notifyErrorInLoadingFashionshops(String message) {
        Log.d(BeautyApp.TAG, message);
    }



    private void broadcastFashionshopLoadedWithLocalBroadcastManager() {
        Intent intent = new Intent(BROADCAST_DATA_LOADED);
        intent.putExtra("key-for-extra", "extra-in-broadcast");
        LocalBroadcastManager.getInstance(BeautyApp.getContext()).sendBroadcast(intent);
    }

    private void broadcastFashionshopnLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.FashionshopsLoadedEvent("extra-in-broadcast", mFashionList));
    }
}
