package com.minhtetoo.goodfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minhtetoo.goodfood.R;
import com.minhtetoo.goodfood.data.vo.BurppleGuideVO;
import com.minhtetoo.goodfood.data.vo.PromotionVO;
import com.minhtetoo.goodfood.viewholders.BurppleGuidesViewHolder;
import com.minhtetoo.goodfood.viewholders.PromotionViewHolder;

/**
 * Created by min on 1/6/2018.
 */


public class BurppleGuideAdapter extends BaseRecyclerAdapter<BurppleGuidesViewHolder,BurppleGuideVO> {

    LayoutInflater layoutInflater;
    public BurppleGuideAdapter(Context context) {
        super(context);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BurppleGuidesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =layoutInflater.inflate(R.layout.view_item_burpple_guides,parent,false);

        BurppleGuidesViewHolder burppleGuidesViewHolder = new BurppleGuidesViewHolder(v);
        return burppleGuidesViewHolder;
    }
}