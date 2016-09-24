package com.padc.beauty.data.agents.retrofit;

import android.util.Log;
import com.padc.beauty.BeautyApp;
import com.padc.beauty.data.agents.FashionshopDataAgent;
import com.padc.beauty.data.models.FashionshopModel;
import com.padc.beauty.data.responses.FashionListResponse;
import com.padc.beauty.utils.BeautyAppConstant;
import com.padc.beauty.utils.CommonInstances;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aung on 7/9/16.
 */
public class RetrofitDataAgent implements FashionshopDataAgent {

    private static RetrofitDataAgent objInstance;

    //private final AttractionApi theApi;
    private final FashionshopsandBeautysalonsApi theFashionApi;
    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BeautyAppConstant.FASHION_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
                .client(okHttpClient)
                .build();

       // theApi = retrofit.create(AttractionApi.class);
        theFashionApi = retrofit.create(FashionshopsandBeautysalonsApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadFashionshops() {
        Call<FashionListResponse> loadFashionshopCall = theFashionApi.loadFashionshops(BeautyAppConstant.ACCESS_TOKEN);
        loadFashionshopCall.enqueue(new Callback<FashionListResponse>() {
            @Override
            public void onResponse(Call<FashionListResponse> call, Response<FashionListResponse> response) {
                Log.d(BeautyApp.TAG, "Reached this place");
                FashionListResponse fashionshopsListResponse = response.body();
                if (fashionshopsListResponse == null) {
                    FashionshopModel.getInstance().notifyErrorInLoadingFashionshops(response.message());
                } else {
                    FashionshopModel.getInstance().notifyFashionshopsLoaded(fashionshopsListResponse.getFashionList());
                }
            }

            @Override
            public void onFailure(Call<FashionListResponse> call, Throwable throwable) {
                FashionshopModel.getInstance().notifyErrorInLoadingFashionshops(throwable.getMessage());
            }

        });
    }
}
