package com.padc.beauty.data.models;

import com.padc.beauty.data.vos.DressingVO;
import com.padc.beauty.data.vos.TipVO;
import com.padc.beauty.events.DataEvent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by windows on 9/24/2016.
 */
public class TipModel extends BaseModel{
    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    private static TipModel objInstance;
    private List<TipVO> mTipList;

    private TipModel() {
        super();
        mTipList = new ArrayList<>();
        dataAgent.loadTips();
    }

    public static TipModel getInstance() {
        if (objInstance == null) {
            objInstance = new TipModel();
        }
        return objInstance;
    }

    public  void loadTips()
    {
        dataAgent.loadTips();
    }

    public List<TipVO> getmTipList() {

        return mTipList;
    }

    public TipVO getTipsbyCategory(String tipcategory) {
        for (TipVO tip : mTipList) {
            if (tip.getTipcategory() == tipcategory)
                return tip;
        }

        return null;
    }

    public TipVO getDressingbyId(int tipid) {
        for (TipVO tip : mTipList) {
            if (tip.getId()==tipid)
                return tip;
        }

        return null;
    }

    public void notifyTipssLoaded(List<TipVO> tipList) {

        mTipList = tipList;

        broadcastMealLoadedWithEventBus();

    }

    public void notifyErrorInLoadingTipItems(String message) {

    }

    private void broadcastMealLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.TipDataLoadedEvent("extra-in-broadcast", mTipList));
    }

}
