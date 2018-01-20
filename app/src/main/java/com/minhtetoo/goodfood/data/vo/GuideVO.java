package com.minhtetoo.goodfood.data.vo;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;
import com.minhtetoo.goodfood.persistence.GoodFoodContract;

import static com.minhtetoo.goodfood.persistence.GoodFoodContract.GuidesEntry.COLUMN_GUIDE_ID;

/**
 * Created by min on 1/19/2018.
 */

public class GuideVO {
    @SerializedName("burpple-guide-id")
    private String guideId;

    @SerializedName("burpple-guide-image")
    private String guideImage;

    @SerializedName("burpple-guide-title")
    private String guideTitle;

    @SerializedName("burpple-guide-desc")
    private String guideDescription;

    public String getGuideId() {
        return guideId;
    }

    public String getGuideImage() {
        return guideImage;
    }

    public String getGuideTitle() {
        return guideTitle;
    }

    public String getGuideDescription() {
        return guideDescription;
    }

    public ContentValues parseToContentValues() {
        ContentValues guideCV = new ContentValues();
        guideCV.put(GoodFoodContract.GuidesEntry.COLUMN_GUIDE_ID,guideId);
        guideCV.put(GoodFoodContract.GuidesEntry.COLUMN_GUIDE_IMAGE,guideImage);
        guideCV.put(GoodFoodContract.GuidesEntry.COLUMN_GUIDE_TITLE,guideTitle);
        guideCV.put(GoodFoodContract.GuidesEntry.COLUMN_GUIDE_DESCRIPTION,guideDescription);

        return guideCV;
    }
}
