package com.padc.beauty.data.agents.retrofit;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.data.responses.FashionListResponse;
import com.padc.beauty.utils.BeautyAppConstant;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Asus on 9/23/2016.
 */
public interface FashionshopsandBeautysalonsApi {
    @FormUrlEncoded
    @POST(BeautyAppConstant.API_GET_FASHIONSHOP_BEAUTYSALON)
    Call<FashionListResponse> loadFashionshops(
            @Field(BeautyAppConstant.PARAM_ACCESS_TOKEN) String param);
}
