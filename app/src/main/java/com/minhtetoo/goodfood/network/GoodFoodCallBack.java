package com.minhtetoo.goodfood.network;

import com.minhtetoo.goodfood.events.RestAPIEvent;
import com.minhtetoo.goodfood.network.responses.GoodFoodResponse;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by min on 1/19/2018.
 */

public abstract class GoodFoodCallBack <T extends GoodFoodResponse> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        GoodFoodResponse goodFoodResponse = response.body();
        if (goodFoodResponse == null) {
            RestAPIEvent.ErrorInvokingAPIEvent errorEvent
                    = new RestAPIEvent.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
            EventBus.getDefault().post(errorEvent);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        RestAPIEvent.ErrorInvokingAPIEvent errorEvent = new RestAPIEvent.ErrorInvokingAPIEvent(t.getMessage());
        EventBus.getDefault().post(errorEvent);
    }
}
