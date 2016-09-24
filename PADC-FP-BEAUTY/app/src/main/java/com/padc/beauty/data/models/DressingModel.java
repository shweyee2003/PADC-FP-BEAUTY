package com.padc.beauty.data.models;

import com.padc.beauty.data.vos.DressingVO;
import com.padc.beauty.events.DataEvent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by windows on 9/22/2016.
 */
public class DressingModel extends BaseModel {
    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    private static DressingModel objInstance;
    private List<DressingVO> mDressingList;

    private DressingModel() {
        super();
        mDressingList = new ArrayList<>();
        dataAgent.loadDressings();
    }

    public static DressingModel getInstance() {
        if (objInstance == null) {
            objInstance = new DressingModel();
        }
        return objInstance;
    }

    public  void loadDressings()
    {
        dataAgent.loadDressings();
    }

    public List<DressingVO> getmDressingList() {

        return mDressingList;
    }

    public DressingVO getDressingbyType(String dressingtype) {
        for (DressingVO dressing : mDressingList) {
            if (dressing.getdresstype() == dressingtype)
                return dressing;
        }

        return null;
    }

    public DressingVO getDressingbyId(int dressingid) {
        for (DressingVO dressing : mDressingList) {
            if (dressing.getid()==dressingid)
                return dressing;
        }

        return null;
    }

    public void notifyAttractionsLoaded(List<DressingVO> dressingList) {

        mDressingList = dressingList;

        broadcastMealLoadedWithEventBus();

    }

    public void notifyErrorInLoadingFoodItems(String message) {

    }

    private void broadcastMealLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.DressingDataLoadedEvent("extra-in-broadcast", mDressingList));
    }


}
