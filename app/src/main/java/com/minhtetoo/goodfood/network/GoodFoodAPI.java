package com.minhtetoo.goodfood.network;

import com.minhtetoo.goodfood.network.responses.GetFeaturedResponse;
import com.minhtetoo.goodfood.network.responses.GetGuidesResponse;
import com.minhtetoo.goodfood.network.responses.GetPromotionResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by min on 1/19/2018.
 */

public interface GoodFoodAPI {

    @FormUrlEncoded
    @POST("v1/getFeatured.php")
    Call<GetFeaturedResponse> loadFeatured(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("v1/getPromotions.php")
    Call<GetPromotionResponse> loadPromotions(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("v1/getGuides.php")
    Call<GetGuidesResponse> loadGuides(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);
}
