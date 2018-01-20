package com.minhtetoo.goodfood.network;

import android.content.Context;

/**
 * Created by min on 1/19/2018.
 */

public interface GoodFoodDataAgent {

    void loadFeatured(String accessToken, int pageNo, Context context);
    void loadPromotions(String accessToken, int pageNo, Context context);
    void loadGuides(String accessToken, int pageNo, Context context);
}
