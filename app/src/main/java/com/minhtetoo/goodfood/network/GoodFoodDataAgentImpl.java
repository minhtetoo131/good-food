package com.minhtetoo.goodfood.network;

import android.content.Context;

import com.google.gson.Gson;
import com.minhtetoo.goodfood.events.RestAPIEvent;
import com.minhtetoo.goodfood.network.responses.GetFeaturedResponse;
import com.minhtetoo.goodfood.network.responses.GetGuidesResponse;
import com.minhtetoo.goodfood.network.responses.GetPromotionResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by min on 1/19/2018.
 */

public class GoodFoodDataAgentImpl implements GoodFoodDataAgent {

    private GoodFoodAPI theAPI;

    public GoodFoodDataAgentImpl() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        theAPI = retrofit.create(GoodFoodAPI.class);

    }


    @Override
    public void loadFeatured(String accessToken, int pageNo, final Context context) {

        Call<GetFeaturedResponse> loadFeaturedCall = theAPI.loadFeatured(pageNo, accessToken);
        loadFeaturedCall.enqueue(new GoodFoodCallBack<GetFeaturedResponse>() {
            @Override
            public void onResponse(Call<GetFeaturedResponse> call, Response<GetFeaturedResponse> response) {
                super.onResponse(call, response);
                GetFeaturedResponse getFeaturedResponse = response.body();
                if (getFeaturedResponse != null
                        && getFeaturedResponse.getFeaturedVOList().size() > 0) {
                    RestAPIEvent.FeaturedDataLoadedEvent featuredDataLoadedEvent = new RestAPIEvent.FeaturedDataLoadedEvent(
                            getFeaturedResponse.getPageNo(), getFeaturedResponse.getFeaturedVOList(), context);
                    EventBus.getDefault().post(featuredDataLoadedEvent);
                }
            }
        });
    }

    @Override
    public void loadPromotions(String accessToken, int pageNo, final Context context) {
        Call<GetPromotionResponse> loadPromotionsCall = theAPI.loadPromotions(pageNo, accessToken);
        loadPromotionsCall.enqueue(new GoodFoodCallBack<GetPromotionResponse>() {
            @Override
            public void onResponse(Call<GetPromotionResponse> call, Response<GetPromotionResponse> response) {
                super.onResponse(call, response);
                GetPromotionResponse getPromotionResponse = response.body();
                if (getPromotionResponse != null
                        && getPromotionResponse.getPromotionVOList().size() > 0) {
                    RestAPIEvent.PromotionDataLoadedEvent promotionDataLoadedEvent = new RestAPIEvent.PromotionDataLoadedEvent(
                            getPromotionResponse.getPageNo(), getPromotionResponse.getPromotionVOList(), context);
                    EventBus.getDefault().post(promotionDataLoadedEvent);
                }
            }
        });
    }

    @Override
    public void loadGuides(String accessToken, int pageNo, final Context context) {
        Call<GetGuidesResponse> loadGuidesCall = theAPI.loadGuides(pageNo, accessToken);
        loadGuidesCall.enqueue(new GoodFoodCallBack<GetGuidesResponse>() {
            @Override
            public void onResponse(Call<GetGuidesResponse> call, Response<GetGuidesResponse> response) {
                super.onResponse(call, response);
                GetGuidesResponse getGuidesResponse = response.body();
                if (getGuidesResponse != null
                        && getGuidesResponse.getGuideVOList().size() > 0) {
                    RestAPIEvent.GuuideDataLoadedEvent guideDataLoadedEvent = new RestAPIEvent.GuuideDataLoadedEvent(
                            getGuidesResponse.getPageNo(), getGuidesResponse.getGuideVOList(), context);
                    EventBus.getDefault().post(guideDataLoadedEvent);
                }
            }
        });
    }
}
