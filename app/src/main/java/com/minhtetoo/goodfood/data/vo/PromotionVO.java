package com.minhtetoo.goodfood.data.vo;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;
import com.minhtetoo.goodfood.persistence.GoodFoodContract;

import java.util.List;

/**
 * Created by min on 1/6/2018.
 */

public class PromotionVO {

    @SerializedName("burpple-promotion-id")
    private String promotionId;

    @SerializedName("burpple-promotion-image")
    private String promotionImage;

    @SerializedName("burpple-promotion-title")
    private String promotionTitle;

    @SerializedName("burpple-promotion-until")
    private String promotionUntil;


    @SerializedName("burpple-promotion-shop")
    private PromotionShopVO promotionShopVO;

    @SerializedName("is-burpple-exclusive")
    private boolean isBurppleexclusive;

    @SerializedName("burpple-promotion-terms")
    private List<String> burpplePromotionTerms;

    public String getPromotionId() {
        return promotionId;
    }

    public String getPromotionImage() {
        return promotionImage;
    }

    public String getPromotionTitle() {
        return promotionTitle;
    }

    public String getPromotionUntil() {
        return promotionUntil;
    }

    public PromotionShopVO getPromotionShopVO() {
        return promotionShopVO;
    }

    public boolean isBurppleexclusive() {
        return isBurppleexclusive;
    }

    public List<String> getBurpplePromotionTerms() {
        return burpplePromotionTerms;
    }

    public ContentValues parseToContentValues() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(GoodFoodContract.PromotionsEntry.COLUMN_PROMOTION_ID, promotionId);
        contentValues.put(GoodFoodContract.PromotionsEntry.COLUMN_IMAGE, promotionImage);
        contentValues.put(GoodFoodContract.PromotionsEntry.COLUMN_TITLE, promotionTitle);
        contentValues.put(GoodFoodContract.PromotionsEntry.COLUMN_UNTIL, promotionUntil);
        contentValues.put(GoodFoodContract.PromotionsEntry.COLUMN_SHOP_ID, promotionShopVO.getPromotionShopId());
        contentValues.put(GoodFoodContract.PromotionsEntry.COLUMN_IS_EXCLUSIVE, isBurppleexclusive);
        return contentValues;
    }
}
