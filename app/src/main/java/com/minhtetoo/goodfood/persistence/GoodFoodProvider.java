package com.minhtetoo.goodfood.persistence;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by min on 1/19/2018.
 */

public class GoodFoodProvider extends ContentProvider {

    public static final int FEATURED = 100;
    public static final int PROMOTIONS = 200;
    public static final int PROMOTIONS_SHOP = 300;
    public static final int PROMOTIONS_TERMS = 400;
    public static final int GUIDES = 500;

    private static final SQLiteQueryBuilder sPromotionsWithPromotionShop_IJ;


    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private GoodFoodDBHelper mDBHelper;

    static {
        sPromotionsWithPromotionShop_IJ = new SQLiteQueryBuilder();
        sPromotionsWithPromotionShop_IJ.setTables(
                GoodFoodContract.PromotionsEntry.TABLE_NAME + " INNER JOIN " +
                        GoodFoodContract.PromotionsShopsEntry.TABLE_NAME + " ON " +
                        GoodFoodContract.PromotionsEntry.TABLE_NAME + "." + GoodFoodContract.PromotionsEntry.COLUMN_SHOP_ID + " = " +
                        GoodFoodContract.PromotionsShopsEntry.TABLE_NAME + "." + GoodFoodContract.PromotionsShopsEntry.COLUMN_PROMOTION_SHOP_ID
        );
    }

    private static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(GoodFoodContract.CONTENT_AUTHORITY, GoodFoodContract.PATH_FEATUREDS, FEATURED);
        uriMatcher.addURI(GoodFoodContract.CONTENT_AUTHORITY, GoodFoodContract.PATH_PROMOTIONS, PROMOTIONS);
        uriMatcher.addURI(GoodFoodContract.CONTENT_AUTHORITY, GoodFoodContract.PATH_PROMOTION_SHOP, PROMOTIONS_SHOP);
        uriMatcher.addURI(GoodFoodContract.CONTENT_AUTHORITY, GoodFoodContract.PATH_PROMOTION_TERMS, PROMOTIONS_TERMS);
        uriMatcher.addURI(GoodFoodContract.CONTENT_AUTHORITY, GoodFoodContract.PATH_GUIDES, GUIDES);

        return uriMatcher;
    }

    private String getTableName(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case FEATURED:
                return GoodFoodContract.FeaturedsEntry.TABLE_NAME;
            case PROMOTIONS:
                return GoodFoodContract.PromotionsEntry.TABLE_NAME;
            case PROMOTIONS_SHOP:
                return GoodFoodContract.PromotionsShopsEntry.TABLE_NAME;
            case PROMOTIONS_TERMS:
                return GoodFoodContract.PromotionTermsEntry.TABLE_NAME;
            case GUIDES:
                return GoodFoodContract.GuidesEntry.TABLE_NAME;
        }
        return null;
    }

    private Uri getContentUri(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case FEATURED:
                return GoodFoodContract.FeaturedsEntry.CONTENT_URI;
            case PROMOTIONS:
                return GoodFoodContract.PromotionsEntry.CONTENT_URI;
            case PROMOTIONS_SHOP:
                return GoodFoodContract.PromotionsShopsEntry.CONTENT_URI;
            case PROMOTIONS_TERMS:
                return GoodFoodContract.PromotionTermsEntry.CONTENT_URI;
            case GUIDES:
                return GoodFoodContract.GuidesEntry.CONTENT_URI;
        }
        return null;
    }


    @Override
    public boolean onCreate() {
        mDBHelper = new GoodFoodDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor queryCursor = null;
        switch (sUriMatcher.match(uri)) {
            case FEATURED:
                queryCursor = mDBHelper.getReadableDatabase().query(getTableName(uri),
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case PROMOTIONS:
                queryCursor = sPromotionsWithPromotionShop_IJ.query(mDBHelper.getReadableDatabase(),
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case PROMOTIONS_TERMS:
                queryCursor = mDBHelper.getReadableDatabase().query(getTableName(uri),
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case GUIDES:
                queryCursor = mDBHelper.getReadableDatabase().query(getTableName(uri),
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

        }

        if (getContext() != null) {
            queryCursor.setNotificationUri(getContext().getContentResolver(), uri);
        }

        return queryCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case FEATURED:
                return GoodFoodContract.FeaturedsEntry.DIR_TYPE;
            case PROMOTIONS:
                return GoodFoodContract.PromotionsEntry.DIR_TYPE;
            case PROMOTIONS_SHOP:
                return GoodFoodContract.PromotionsShopsEntry.DIR_TYPE;
            case PROMOTIONS_TERMS:
                return GoodFoodContract.PromotionTermsEntry.DIR_TYPE;
            case GUIDES:
                return GoodFoodContract.GuidesEntry.DIR_TYPE;

        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        long _id = db.insert(tableName, null, values);
        if (_id > 0) {
            Uri tableContentUri = getContentUri(uri);
            Uri insertedUri = ContentUris.withAppendedId(tableContentUri, _id);

            if (getContext() != null) {
                getContext().getContentResolver().notifyChange(uri, null);
            }

            return insertedUri;
        }

        return null;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        final SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int insertedCount = 0;

        try {
            db.beginTransaction();
            for (ContentValues cv : values) {
                long _id = db.insert(tableName, null, cv);
                if (_id > 0) {
                    insertedCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            //db.close();
        }

        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return insertedCount;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int rowDeleted;
        String tableName = getTableName(uri);

        rowDeleted = db.delete(tableName, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowDeleted > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int rowUpdated;
        String tableName = getTableName(uri);

        rowUpdated = db.update(tableName, values, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowUpdated > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowUpdated;
    }
}
