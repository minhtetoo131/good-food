package com.minhtetoo.goodfood.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.minhtetoo.goodfood.GoodFoodApp;
import com.minhtetoo.goodfood.data.vo.FeaturedVO;
import com.minhtetoo.goodfood.data.vo.GuideVO;
import com.minhtetoo.goodfood.data.vo.PromotionShopVO;
import com.minhtetoo.goodfood.data.vo.PromotionVO;
import com.minhtetoo.goodfood.events.RestAPIEvent;
import com.minhtetoo.goodfood.network.GoodFoodDataAgent;
import com.minhtetoo.goodfood.network.GoodFoodDataAgentImpl;
import com.minhtetoo.goodfood.persistence.GoodFoodContract;
import com.minhtetoo.goodfood.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by min on 1/19/2018.
 */

public class GoodFoodModel {
    private List<FeaturedVO> featuredVOList;
    private List<PromotionVO> promotionVOList;
    private List<GuideVO> guideVOList;

    @Inject
    GoodFoodDataAgent mDataAgent;

    private int featuredPageIndex = 1;
    private int promotionPageIndex = 1;
    private int guidePageIndex = 1;



    public GoodFoodModel(Context context) {
        EventBus.getDefault().register(this);
        GoodFoodApp appObj = (GoodFoodApp) context;
        appObj.getAppComponent().inject(this);
        featuredVOList = new ArrayList<>();
        promotionVOList = new ArrayList<>();
        guideVOList = new ArrayList<>();
    }



    public void startLoadingFeatureds(Context context) {
        mDataAgent.loadFeatured(AppConstants.ACCESS_TOKEN,
                1,
                context);
    }

    public void startLoadingPromotions(Context context) {
        mDataAgent.loadPromotions(AppConstants.ACCESS_TOKEN,
                1,
                context);
    }

    public void startLoadingGuides(Context context) {
        mDataAgent.loadGuides(AppConstants.ACCESS_TOKEN,
                1,
                context);
    }

    public List<FeaturedVO> getNews() {
        return featuredVOList;
    }

    public void loadMoreFeatured(Context context) {
        mDataAgent.loadFeatured(AppConstants.ACCESS_TOKEN,
                featuredPageIndex,
                context);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onFeaturedDataLoaded(RestAPIEvent.FeaturedDataLoadedEvent event) {
        featuredVOList.addAll(event.getLoadFeatureds());

        featuredPageIndex = featuredPageIndex + 1;

        ContentValues[] featuredCVs = new ContentValues[event.getLoadFeatureds().size()];

        for(int index = 0 ;index < featuredCVs.length; index++){
            FeaturedVO featuredVO = event.getLoadFeatureds().get(index);
            featuredCVs[index] = featuredVO.parseToContentValues();
        }

        int insertedFeaturedsRow = event.getContext().getContentResolver().bulkInsert(GoodFoodContract.FeaturedsEntry.CONTENT_URI,
                featuredCVs);
        Log.d("inseted row", "insertedNews : " + insertedFeaturedsRow);

//        Toast.makeText(event.getContext(),""+ insertedFeaturedsRow,Toast.LENGTH_LONG).show();


    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onPromotionDataLoaded(RestAPIEvent.PromotionDataLoadedEvent event) {
        promotionVOList.addAll(event.getLoadedPromotions());
        promotionPageIndex = promotionPageIndex + 1;

        ContentValues[] promotionCVs = new ContentValues[event.getLoadedPromotions().size()];
        ContentValues[] promotionShopCVs = new ContentValues[event.getLoadedPromotions().size()];
        List<ContentValues> promotionInTerms = new ArrayList<>();

        for(int index = 0 ;index < promotionCVs.length; index++){
            PromotionVO promotionVO = event.getLoadedPromotions().get(index);
            promotionCVs[index] = promotionVO.parseToContentValues();

            PromotionShopVO promotionShopVO = promotionVO.getPromotionShopVO();
            promotionShopCVs[index]= promotionShopVO.parseToContentValues();

            for (String terms : promotionVO.getBurpplePromotionTerms()) {
                ContentValues termsInPromotion = new ContentValues();
                termsInPromotion.put(GoodFoodContract.PromotionTermsEntry.COLUMN_PROMOTION_TERMS, terms);
                termsInPromotion.put(GoodFoodContract.PromotionTermsEntry.COLUMN_PROMOTION_ID, promotionVO.getPromotionId());
                promotionInTerms.add(termsInPromotion);
            }
        }

        int insertedPromotionsRow = event.getContext().getContentResolver().bulkInsert(GoodFoodContract.PromotionsEntry.CONTENT_URI,
                promotionCVs);
        Log.d("insertedPromotionsRow", " " + insertedPromotionsRow);

        int insertedPromotionShopsRow = event.getContext().getContentResolver().bulkInsert(GoodFoodContract.PromotionsShopsEntry.CONTENT_URI,
                promotionShopCVs);
        Log.d("insertedShopsRow", " " + insertedPromotionShopsRow);

        int insertedPromotionTermsRow = event.getContext().getContentResolver().bulkInsert(GoodFoodContract.PromotionTermsEntry.CONTENT_URI,
                promotionShopCVs);
        Log.d("insertedTermsRow", " " + insertedPromotionTermsRow);


    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onGuideDataLoaded(RestAPIEvent.GuuideDataLoadedEvent event) {
        guideVOList.addAll(event.getLoadedGuides());
        guidePageIndex = guidePageIndex + 1;

        ContentValues[] guideCVs = new ContentValues[event.getLoadedGuides().size()];

        for(int index = 0 ;index < guideCVs.length; index++){
            GuideVO guideVO = event.getLoadedGuides().get(index);
            guideCVs[index] = guideVO.parseToContentValues();
        }

        int insertedGuidesRow = event.getContext().getContentResolver().bulkInsert(GoodFoodContract.GuidesEntry.CONTENT_URI,
                guideCVs);
        Log.d("inseted row", "" + insertedGuidesRow);
    }
}
