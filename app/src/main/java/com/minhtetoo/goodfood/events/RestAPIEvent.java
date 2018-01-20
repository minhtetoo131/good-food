package com.minhtetoo.goodfood.events;

import android.content.Context;

import com.minhtetoo.goodfood.data.vo.FeaturedVO;
import com.minhtetoo.goodfood.data.vo.GuideVO;
import com.minhtetoo.goodfood.data.vo.PromotionVO;

import java.util.List;

/**
 * Created by min on 1/19/2018.
 */

public class RestAPIEvent {


    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class FeaturedDataLoadedEvent {
        private int loadedPageIndex;
        private List<FeaturedVO> mloadedFeatureds;
        private Context context;

        public FeaturedDataLoadedEvent(int loadedPageIndex, List<FeaturedVO> loadedFeatureds, Context context) {
            this.loadedPageIndex = loadedPageIndex;
            this.mloadedFeatureds = loadedFeatureds;
            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<FeaturedVO> getLoadFeatureds() {
            return mloadedFeatureds;
        }

        public Context getContext() {
            return context;
        }
    }

    public static class PromotionDataLoadedEvent {
        private int loadedPageIndex;
        private List<PromotionVO> mloadedPromotions;
        private Context context;

        public PromotionDataLoadedEvent(int loadedPageIndex, List<PromotionVO> loadedPromotions, Context context) {
            this.loadedPageIndex = loadedPageIndex;
            this.mloadedPromotions = loadedPromotions;
            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<PromotionVO> getLoadedPromotions() {
            return mloadedPromotions;
        }

        public Context getContext() {
            return context;
        }
    }

    public static class GuuideDataLoadedEvent {
        private int loadedPageIndex;
        private List<GuideVO> mloadedGuides;
        private Context context;

        public GuuideDataLoadedEvent(int loadedPageIndex, List<GuideVO> loadedGuides, Context context) {
            this.loadedPageIndex = loadedPageIndex;
            this.mloadedGuides = loadedGuides;
            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<GuideVO> getLoadedGuides() {
            return mloadedGuides;
        }

        public Context getContext() {
            return context;
        }
    }
}
