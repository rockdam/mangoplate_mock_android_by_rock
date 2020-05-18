package com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.naver.maps.map.NaverMap;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.util.FusedLocationSource;
import com.softSquared.mangoplate.R;
import com.softSquared.mangoplate.src.BaseActivity;
import com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information.interfaces.RestaurantInfoViewFragment;
import com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information.models.RestaurantInfoResultList;
import com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information.models.RestaurantInfomationResponse;


public class RetaurantInformationLayout extends BaseActivity implements RestaurantInfoViewFragment {
    RestaurantInfoService restaurantInfoService;
    int restaurantId;
    private RecyclerView mInfoRestaurantRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private RestaurantInfoRecyclerAdapter madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retaurant_information);
        Intent receiveIntent = getIntent();
        init(); //리사이클러뷰 초기화
        tryGetRestaurantInfoList();//
        restaurantId = receiveIntent.getIntExtra("restaurantId", restaurantId);


        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
    }

    void tryGetRestaurantInfoList() {
        restaurantInfoService = new RestaurantInfoService(this, restaurantId);
        restaurantInfoService.tryGetRestaurantInfoList();

    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void successUpdateRecyclerView(RestaurantInfomationResponse restaurantInfomationResponse) {

        madapter.clear();
        for (RestaurantInfoResultList restaurantInfoResultList : restaurantInfomationResponse.getResult()) {


            madapter.addItem(restaurantInfoResultList);

        }

        madapter.notifyDataSetChanged();

    }


    private void init() {
        int numberOfColumns = 1;// 한줄에 2개의 컬럼을 추가
        mInfoRestaurantRecyclerView = findViewById(R.id.recyclerview_informaiton);
        mGridLayoutManager = new GridLayoutManager(this, numberOfColumns);
        mInfoRestaurantRecyclerView.setLayoutManager(mGridLayoutManager);
        madapter = new RestaurantInfoRecyclerAdapter();
        mInfoRestaurantRecyclerView.setAdapter(madapter);


    }
}


