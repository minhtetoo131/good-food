package com.minhtetoo.goodfood.data.vo;

import android.content.ContentValues;
import android.database.Cursor;

import com.google.gson.annotations.SerializedName;
import com.minhtetoo.goodfood.persistence.GoodFoodContract;

/**
 * Created by min on 1/19/2018.
 */

public class FeaturedVO {


    @SerializedName("burpple-featured-id")
    private String feturedId;

    @SerializedName("burpple-featured-image")
    private String image;

    @SerializedName("burpple-featured-title")
    private String title;

    @SerializedName("burpple-featured-desc")
    private String description;

    @SerializedName("burpple-featured-tag")
    private String tag;

    public String getFeturedId() {
        return feturedId;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }

    public ContentValues parseToContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(GoodFoodContract.FeaturedsEntry.COLUMN_FEATURED_ID, feturedId);
        contentValues.put(GoodFoodContract.FeaturedsEntry.COLUMN_IMAGE, image);
        contentValues.put(GoodFoodContract.FeaturedsEntry.COLUMN_TITLE, title);
        contentValues.put(GoodFoodContract.FeaturedsEntry.COLUMN_DESCRIPTION, description);
        contentValues.put(GoodFoodContract.FeaturedsEntry.COLUMN_TAG, tag);
        return contentValues;
    }

    public static FeaturedVO parseFromCursor(Cursor cursor) {
        FeaturedVO featuredVO = new FeaturedVO();

        featuredVO.feturedId = cursor.getString(cursor.getColumnIndex(GoodFoodContract.FeaturedsEntry.COLUMN_FEATURED_ID));
        featuredVO.image = cursor.getString(cursor.getColumnIndex(GoodFoodContract.FeaturedsEntry.COLUMN_IMAGE));
        featuredVO.title = cursor.getString(cursor.getColumnIndex(GoodFoodContract.FeaturedsEntry.COLUMN_TITLE));
        featuredVO.description = cursor.getString(cursor.getColumnIndex(GoodFoodContract.FeaturedsEntry.COLUMN_DESCRIPTION));
        featuredVO.tag = cursor.getString(cursor.getColumnIndex(GoodFoodContract.FeaturedsEntry.COLUMN_TAG));

        return featuredVO;
    }
}
