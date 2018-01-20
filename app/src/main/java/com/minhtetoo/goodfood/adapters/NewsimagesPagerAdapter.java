package com.minhtetoo.goodfood.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minhtetoo.goodfood.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 1/6/2018.
 */

public class NewsimagesPagerAdapter extends PagerAdapter {


    private LayoutInflater mLayoutInflater;
    private List<String> mImages;

    public NewsimagesPagerAdapter(Context context) {
        super();

        mLayoutInflater = LayoutInflater.from(context);
        mImages = new ArrayList<>();


    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.view_item_news_details_image,container,false);
        container.addView(itemView);
        return itemView;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);

        super.destroyItem(container, position, object);

    }

    public void setImages(List<String> images) {
        mImages = images;
        notifyDataSetChanged();
    }
}
