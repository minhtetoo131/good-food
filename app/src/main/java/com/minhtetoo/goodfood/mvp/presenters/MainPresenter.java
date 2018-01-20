package com.minhtetoo.goodfood.mvp.presenters;

import android.content.Context;
import android.database.Cursor;

import com.minhtetoo.goodfood.GoodFoodApp;
import com.minhtetoo.goodfood.data.model.GoodFoodModel;
import com.minhtetoo.goodfood.data.vo.FeaturedVO;
import com.minhtetoo.goodfood.mvp.views.MainView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by min on 1/20/2018.
 */

public class MainPresenter extends BasePresenter<MainView>  {

    @Inject
    GoodFoodModel goodFoodModel;


    public MainPresenter(Context context) {
        GoodFoodApp appObj = (GoodFoodApp) context;
        appObj.getAppComponent().inject(this);

    }

    @Override
    public void onCreate(MainView view) {
        super.onCreate(view);

    }

    @Override
    public void onStart() {
        EventBus.getDefault().register(mView);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(mView);

    }

    public void onLoadFinished(Cursor data) {
        if (data != null && data.moveToFirst()) {
            List<FeaturedVO> featuredVOList = new ArrayList<>();

            do {
                FeaturedVO featuredVO = FeaturedVO.parseFromCursor(data);
                featuredVOList.add(featuredVO);
            } while (data.moveToNext());

            mView.setDataToAdapter(featuredVOList);


        }
    }
}
