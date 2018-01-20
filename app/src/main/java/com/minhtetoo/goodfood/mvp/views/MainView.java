package com.minhtetoo.goodfood.mvp.views;

import com.minhtetoo.goodfood.data.vo.FeaturedVO;

import java.util.List;

/**
 * Created by min on 1/20/2018.
 */

public interface MainView {
    void setDataToAdapter(List<FeaturedVO> featuredVOList);
}
