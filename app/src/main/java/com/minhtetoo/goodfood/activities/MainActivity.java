package com.minhtetoo.goodfood.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.minhtetoo.goodfood.adapters.BurppleGuideAdapter;
import com.minhtetoo.goodfood.adapters.NewAndTrendAdapter;
import com.minhtetoo.goodfood.adapters.NewsimagesPagerAdapter;
import com.minhtetoo.goodfood.R;
import com.minhtetoo.goodfood.adapters.PromotionAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_promotions) RecyclerView rvPromotions;
    @BindView(R.id.rv_burpple_guides) RecyclerView rvBurppleGuides;
    @BindView(R.id.rv_new_and_trending) RecyclerView rvNewAndTrending;
    @BindView(R.id.vp_highlight_food_places_images)ViewPager vpMain;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        rvPromotions.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        PromotionAdapter promotionAdapter = new PromotionAdapter(getApplicationContext());
        rvPromotions.setAdapter(promotionAdapter);

        rvBurppleGuides.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        BurppleGuideAdapter burppleGuideAdapter = new BurppleGuideAdapter(getApplicationContext());
        rvBurppleGuides.setAdapter(burppleGuideAdapter);

        rvNewAndTrending.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        NewAndTrendAdapter newAndTrendAdapter = new NewAndTrendAdapter(getApplicationContext());
        rvNewAndTrending.setAdapter(newAndTrendAdapter);

        vpMain.setAdapter(new NewsimagesPagerAdapter(getApplicationContext()));
    }
}
