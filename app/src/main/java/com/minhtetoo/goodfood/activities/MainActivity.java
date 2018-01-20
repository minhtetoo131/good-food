package com.minhtetoo.goodfood.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.EventLog;
import android.util.Log;
import android.widget.Toast;

import com.minhtetoo.goodfood.GoodFoodApp;
import com.minhtetoo.goodfood.adapters.BurppleGuideAdapter;
import com.minhtetoo.goodfood.adapters.NewAndTrendAdapter;
import com.minhtetoo.goodfood.adapters.NewsimagesPagerAdapter;
import com.minhtetoo.goodfood.R;
import com.minhtetoo.goodfood.adapters.PromotionAdapter;
import com.minhtetoo.goodfood.data.vo.FeaturedVO;
import com.minhtetoo.goodfood.events.RestAPIEvent;
import com.minhtetoo.goodfood.mvp.presenters.MainPresenter;
import com.minhtetoo.goodfood.mvp.views.MainView;
import com.minhtetoo.goodfood.persistence.GoodFoodContract;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>,MainView {

    @BindView(R.id.rv_promotions) RecyclerView rvPromotions;
    @BindView(R.id.rv_burpple_guides) RecyclerView rvBurppleGuides;
    @BindView(R.id.rv_new_and_trending) RecyclerView rvNewAndTrending;
    @BindView(R.id.vp_highlight_images)ViewPager vpMain;

    private static final int FEATURED_LIST_LOADER_ID = 1001;
    private static final int PROMOTION_LIST_LOADER_ID = 1002;
    private static final int GUIDE_LIST_LOADER_ID = 1003;


    PromotionAdapter promotionAdapter;
    NewAndTrendAdapter newAndTrendAdapter;
    BurppleGuideAdapter burppleGuideAdapter;

    @Inject
    MainPresenter mainPresenter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        GoodFoodApp goodFoodApp = (GoodFoodApp)getApplicationContext();
        goodFoodApp.getAppComponent().inject(this);

        rvPromotions.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        promotionAdapter = new PromotionAdapter(getApplicationContext());
        rvPromotions.setAdapter(promotionAdapter);

        rvBurppleGuides.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        burppleGuideAdapter = new BurppleGuideAdapter(getApplicationContext());
        rvBurppleGuides.setAdapter(burppleGuideAdapter);

        rvNewAndTrending.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        newAndTrendAdapter = new NewAndTrendAdapter(getApplicationContext());
        rvNewAndTrending.setAdapter(newAndTrendAdapter);

        vpMain.setAdapter(new NewsimagesPagerAdapter(getApplicationContext()));

        getSupportLoaderManager().initLoader(FEATURED_LIST_LOADER_ID, null, this);
        getSupportLoaderManager().initLoader(PROMOTION_LIST_LOADER_ID, null, this);
        getSupportLoaderManager().initLoader(GUIDE_LIST_LOADER_ID, null, this);
    }

    @Override
    protected void onStart() {
        mainPresenter.onStart();
        super.onStart();
    }

    @Override
    protected void onResume() {
        mainPresenter.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mainPresenter.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        mainPresenter.onStop();
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getApplicationContext(),
                GoodFoodContract.FeaturedsEntry.CONTENT_URI,
                null,
                null, null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        mainPresenter.onLoadFinished(data);


//            Log.d("featured list size",""+ featuredVOList.size());

    }



    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void errorInvokingAPIEvent(RestAPIEvent.ErrorInvokingAPIEvent event) {
        Toast.makeText(getApplicationContext(),event.getErrorMsg(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void setDataToAdapter(List<FeaturedVO> featuredVOList) {

    }
}
