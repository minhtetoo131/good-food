package com.minhtetoo.goodfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minhtetoo.goodfood.R;
import com.minhtetoo.goodfood.data.vo.PromotionVO;
import com.minhtetoo.goodfood.viewholders.BaseViewHolder;
import com.minhtetoo.goodfood.viewholders.PromotionViewHolder;

/**
 * Created by min on 1/6/2018.
 */

public class PromotionAdapter extends BaseRecyclerAdapter<PromotionViewHolder,PromotionVO> {

    LayoutInflater layoutInflater;
    public PromotionAdapter(Context context) {
        super(context);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public PromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =layoutInflater.inflate(R.layout.view_item_promotion,parent,false);

        PromotionViewHolder promotionViewHolder = new PromotionViewHolder(v);
        return promotionViewHolder;
    }
}
