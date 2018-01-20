package com.minhtetoo.goodfood.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by min on 1/19/2018.
 */

public class GoodFoodDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "goodFoods.db";
    private static final int DB_VERSION = 1;

    private static final String SQL_CREATE_FEATURED = "CREATE TABLE " + GoodFoodContract.FeaturedsEntry.TABLE_NAME + " (" +
            GoodFoodContract.FeaturedsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GoodFoodContract.FeaturedsEntry.COLUMN_FEATURED_ID + " VARCHAR(256), " +
            GoodFoodContract.FeaturedsEntry.COLUMN_IMAGE + " TEXT, " +
            GoodFoodContract.FeaturedsEntry.COLUMN_TITLE + " TEXT, " +
            GoodFoodContract.FeaturedsEntry.COLUMN_DESCRIPTION + " TEXT, " +
            GoodFoodContract.FeaturedsEntry.COLUMN_TAG + " TEXT, " +

            " UNIQUE (" + GoodFoodContract.FeaturedsEntry.COLUMN_FEATURED_ID + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_PROMOTIONS = "CREATE TABLE " + GoodFoodContract.PromotionsEntry.TABLE_NAME + " (" +
            GoodFoodContract.PromotionsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GoodFoodContract.PromotionsEntry.COLUMN_PROMOTION_ID + " VARCHAR(256), " +
            GoodFoodContract.PromotionsEntry.COLUMN_IMAGE + " TEXT, " +
            GoodFoodContract.PromotionsEntry.COLUMN_TITLE + " TEXT, " +
            GoodFoodContract.PromotionsEntry.COLUMN_UNTIL + " TEXT, " +
            GoodFoodContract.PromotionsEntry.COLUMN_SHOP_ID + " VARCHAR(256), " +
            GoodFoodContract.PromotionsEntry.COLUMN_IS_EXCLUSIVE + " BOOLEAN, " +

            " UNIQUE (" + GoodFoodContract.PromotionsEntry.COLUMN_PROMOTION_ID + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_PROMOTIONS_SHOPS = "CREATE TABLE " + GoodFoodContract.PromotionsShopsEntry.TABLE_NAME + " (" +
            GoodFoodContract.PromotionsShopsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GoodFoodContract.PromotionsShopsEntry.COLUMN_PROMOTION_SHOP_ID + " VARCHAR(256), " +
            GoodFoodContract.PromotionsShopsEntry.COLUMN_SHOP_NAME + " TEXT, " +
            GoodFoodContract.PromotionsShopsEntry.COLUMN_SHOP_AREA + " TEXT, " +

            " UNIQUE (" + GoodFoodContract.PromotionsShopsEntry.COLUMN_PROMOTION_SHOP_ID + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_PROMOTIONS_TERMS = "CREATE TABLE " + GoodFoodContract.PromotionTermsEntry.TABLE_NAME + " (" +
            GoodFoodContract.PromotionTermsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GoodFoodContract.PromotionTermsEntry.COLUMN_PROMOTION_TERMS + " TEXT, " +
            GoodFoodContract.PromotionTermsEntry.COLUMN_PROMOTION_ID + " VARCHAR(256), " +

//            " UNIQUE (" + GoodFoodContract.PromotionTermsEntry.COLUMN_PROMOTION_ID + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_GUIDES = "CREATE TABLE " + GoodFoodContract.GuidesEntry.TABLE_NAME + " (" +
            GoodFoodContract.GuidesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GoodFoodContract.GuidesEntry.COLUMN_GUIDE_ID + " VARCHAR(256), " +
            GoodFoodContract.GuidesEntry.COLUMN_GUIDE_IMAGE + " TEXT, " +
            GoodFoodContract.GuidesEntry.COLUMN_GUIDE_TITLE + " TEXT, " +
            GoodFoodContract.GuidesEntry.COLUMN_GUIDE_DESCRIPTION + " TEXT, " +

            " UNIQUE (" + GoodFoodContract.GuidesEntry.COLUMN_GUIDE_ID + ") ON CONFLICT REPLACE" +
            ");";

    public GoodFoodDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_FEATURED);
        db.execSQL(SQL_CREATE_PROMOTIONS);
        db.execSQL(SQL_CREATE_PROMOTIONS_SHOPS);

        db.execSQL(SQL_CREATE_PROMOTIONS_TERMS);
        db.execSQL(SQL_CREATE_GUIDES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + GoodFoodContract.FeaturedsEntry.TABLE_NAME);

        db.execSQL("DROP TABLE IF EXISTS " + GoodFoodContract.PromotionsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GoodFoodContract.PromotionsShopsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GoodFoodContract.PromotionTermsEntry.TABLE_NAME);

        db.execSQL("DROP TABLE IF EXISTS " + GoodFoodContract.GuidesEntry.TABLE_NAME);

        onCreate(db);

    }
}
