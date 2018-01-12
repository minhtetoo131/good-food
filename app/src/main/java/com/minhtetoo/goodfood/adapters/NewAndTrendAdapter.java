package com.minhtetoo.goodfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minhtetoo.goodfood.R;
import com.minhtetoo.goodfood.data.vo.NewaAndTrendVO;
import com.minhtetoo.goodfood.data.vo.PromotionVO;
import com.minhtetoo.goodfood.viewholders.NewAndTrendViewHolder;
import com.minhtetoo.goodfood.viewholders.PromotionViewHolder;

/**
 * Created by min on 1/6/2018.
 */


public class NewAndTrendAdapter extends BaseRecyclerAdapter<NewAndTrendViewHolder,NewaAndTrendVO> {

    LayoutInflater layoutInflater;
    public NewAndTrendAdapter(Context context) {
        super(context);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NewAndTrendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =layoutInflater.inflate(R.layout.view_item_new_and_trend,parent,false);

        NewAndTrendViewHolder newAndTrendViewHolder = new NewAndTrendViewHolder(v);
        return newAndTrendViewHolder;
    }
}

