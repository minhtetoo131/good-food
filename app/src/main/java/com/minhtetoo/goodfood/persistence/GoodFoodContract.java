package com.minhtetoo.goodfood.persistence;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.minhtetoo.goodfood.GoodFoodApp;

/**
 * Created by min on 1/19/2018.
 */

public class GoodFoodContract {
    public static final String CONTENT_AUTHORITY = GoodFoodApp.class.getPackage().getName();
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_FEATUREDS = "featureds";
    public static final String PATH_PROMOTIONS = "promotions";
    public static final String PATH_PROMOTION_SHOP = "promotions_shops";
    public static final String PATH_PROMOTION_TERMS = "promotions_terms";
    public static final String PATH_GUIDES = "guides";

    public static class FeaturedsEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_FEATUREDS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FEATUREDS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FEATUREDS;

        public static final String TABLE_NAME = PATH_FEATUREDS;

        public static final String COLUMN_FEATURED_ID = "featured_id";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_TAG = "tag";

        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }

    public static class PromotionsEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PROMOTIONS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTIONS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTIONS;

        public static final String TABLE_NAME = PATH_PROMOTIONS;

        public static final String COLUMN_PROMOTION_ID = "promotion_id";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_UNTIL = "until";
        public static final String COLUMN_SHOP_ID = "shop_id";
        public static final String COLUMN_IS_EXCLUSIVE = "is_exclusive";

        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }

    public static class PromotionsShopsEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PROMOTION_SHOP).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTION_SHOP;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTION_SHOP;

        public static final String TABLE_NAME = PATH_PROMOTION_SHOP;

        public static final String COLUMN_PROMOTION_SHOP_ID = "shop_id";
        public static final String COLUMN_SHOP_NAME= "shop_name";
        public static final String COLUMN_SHOP_AREA = "shop_area";


        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }

    public static class PromotionTermsEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PROMOTION_TERMS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTION_TERMS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTION_TERMS;

        public static final String TABLE_NAME = PATH_PROMOTION_TERMS;

        public static final String COLUMN_PROMOTION_TERMS = "promotion_terms";
        public static final String COLUMN_PROMOTION_ID= "promotion_id";


        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }

    public static class GuidesEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_GUIDES).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GUIDES;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GUIDES;

        public static final String TABLE_NAME = PATH_GUIDES;

        public static final String COLUMN_GUIDE_ID = "guide_id";
        public static final String COLUMN_GUIDE_IMAGE= "guide_image";
        public static final String COLUMN_GUIDE_TITLE= "guide_title";
        public static final String COLUMN_GUIDE_DESCRIPTION= "guide_description";


        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }
}
