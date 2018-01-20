package com.minhtetoo.goodfood.dagger;

import android.content.Context;

import com.minhtetoo.goodfood.GoodFoodApp;
import com.minhtetoo.goodfood.data.model.GoodFoodModel;
import com.minhtetoo.goodfood.mvp.presenters.MainPresenter;
import com.minhtetoo.goodfood.network.GoodFoodDataAgent;
import com.minhtetoo.goodfood.network.GoodFoodDataAgentImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by min on 1/20/2018.
 */
@Module
public class AppModule {
    private GoodFoodApp appObject;

    public AppModule(GoodFoodApp appObject) {
        this.appObject = appObject;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return appObject.getApplicationContext();
    }

    @Provides
    @Singleton
    public GoodFoodModel provideModel(Context context){
        return new GoodFoodModel(context);
    }

    @Provides
    @Singleton
    public GoodFoodDataAgent provideDataAgent(){
        return new GoodFoodDataAgentImpl();
    }

    @Provides
    public MainPresenter provideMainPresenter(Context context){
        return new MainPresenter(context);
    }
}
