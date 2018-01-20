package com.minhtetoo.goodfood.dagger;

import com.minhtetoo.goodfood.GoodFoodApp;
import com.minhtetoo.goodfood.activities.MainActivity;
import com.minhtetoo.goodfood.data.model.GoodFoodModel;
import com.minhtetoo.goodfood.mvp.presenters.MainPresenter;

import dagger.Component;

/**
 * Created by min on 1/20/2018.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject (GoodFoodApp app);
    void inject (GoodFoodModel model);
    void inject (MainPresenter mainPresenter);
    void inject (MainActivity mainActivity);

}
