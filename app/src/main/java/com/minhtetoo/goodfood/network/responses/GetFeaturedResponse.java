package com.minhtetoo.goodfood.network.responses;

import com.google.gson.annotations.SerializedName;
import com.minhtetoo.goodfood.data.vo.FeaturedVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 1/19/2018.
 */

public class GetFeaturedResponse extends GoodFoodResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int pageNo;

    @SerializedName("featured")
    private List<FeaturedVO> featuredVOList;

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

    public List<FeaturedVO> getFeaturedVOList() {
        if (featuredVOList==null){
            featuredVOList = new ArrayList<>();
        }
        return featuredVOList;
    }
}
