package com.minhtetoo.goodfood.network.responses;

import com.google.gson.annotations.SerializedName;
import com.minhtetoo.goodfood.data.vo.FeaturedVO;
import com.minhtetoo.goodfood.data.vo.GuideVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 1/19/2018.
 */

public class GetGuidesResponse extends GoodFoodResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int pageNo;

    @SerializedName("featured")
    private List<GuideVO> guideVOSList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPageNo() {
        return pageNo;
    }

    public List<GuideVO> getGuideVOList() {
        if (guideVOSList == null){
            guideVOSList = new ArrayList<>();
        }
        return guideVOSList;
    }
}
