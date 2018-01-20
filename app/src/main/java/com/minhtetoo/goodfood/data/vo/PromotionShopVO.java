package com.minhtetoo.goodfood.data.vo;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;
import com.minhtetoo.goodfood.persistence.GoodFoodContract;

/**
 * Created by min on 1/19/2018.
 */

public class PromotionShopVO {

    @SerializedName("burpple-shop-id")
    private String promotionShopId;

    @SerializedName("burpple-shop-name")
    private String promotionShopName;

    @SerializedName("burpple-shop-area")
    private String promotionShopArea;


    public String getPromotionShopId() {
        return promotionShopId;
    }

    public String getPromotionShopName() {
        return promotionShopName;
    }

    public String getPromotionShopArea() {
        return promotionShopArea;
    }

    public ContentValues parseToContentValues() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(GoodFoodContract.PromotionsShopsEntry.COLUMN_PROMOTION_SHOP_ID, promotionShopId);
        contentValues.put(GoodFoodContract.PromotionsShopsEntry.COLUMN_SHOP_NAME, promotionShopName);
        contentValues.put(GoodFoodContract.PromotionsShopsEntry.COLUMN_SHOP_AREA, promotionShopArea);

        return contentValues;
    }
}
