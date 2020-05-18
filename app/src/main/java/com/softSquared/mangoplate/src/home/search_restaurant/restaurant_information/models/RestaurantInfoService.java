package com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information.models;

import android.content.Context;
import android.util.Log;

import com.softSquared.mangoplate.src.home.interfaces.HomeActivityView;
import com.softSquared.mangoplate.src.home.search_restaurant.models.RestaurantResult;
import com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information.RestaurantInfoRecyclerAdapter;
import com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information.interfaces.RestaurantInfoRetrofitInterface;
import com.softSquared.mangoplate.src.home.search_restaurant.restaurant_information.interfaces.RestaurantInfoViewFragment;

import java.util.ArrayList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softSquared.mangoplate.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softSquared.mangoplate.src.ApplicationClass.getRetrofit;

public class RestaurantInfoService {
    private HomeActivityView mHomeActivityView;

    private RestaurantInfoViewFragment mRestaurantInfoViewFragment;
    private RestaurantInfomationResponse mRestaurantInfomationResponse;
    private RecyclerView mInfoRestaurantRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private RestaurantInfoRecyclerAdapter madapter;
    private Context mContext;
    private String area = ""; // 쿼리 ?area= .......;
    private ArrayList<RestaurantResult> listData = new ArrayList<>();
    int mRestaurantId;

    public RestaurantInfoService( RestaurantInfoViewFragment mRestaurantInfoViewFragment, int restaurantId) {
        this.mRestaurantInfoViewFragment = mRestaurantInfoViewFragment;
        this.mRestaurantId =restaurantId;
    }



    public void tryGetRestaurantInfoList() {

        final RestaurantInfoRetrofitInterface restaurantInfoRetrofitInterface = getRetrofit().create(RestaurantInfoRetrofitInterface.class);

        restaurantInfoRetrofitInterface.toString();

//        init();
        restaurantInfoRetrofitInterface.getRestaurants(X_ACCESS_TOKEN, mRestaurantId).enqueue(new Callback<RestaurantInfomationResponse>() {
            @Override
            public void onResponse(Call<RestaurantInfomationResponse> call, Response<RestaurantInfomationResponse> response) {
                mRestaurantInfomationResponse = response.body();
                Log.e("망고 안되네", "area");
                if (mRestaurantInfomationResponse.getResult() != null) {

                        if (response.code() == 200) {

                            if (mRestaurantInfomationResponse.getResult() != null) {

                                mRestaurantInfoViewFragment.successUpdateRecyclerView(mRestaurantInfomationResponse);



                            }

                        } else {
                            mHomeActivityView.validateFailure(null);

                        }


                    }

                    madapter.notifyDataSetChanged();
                }

            @Override
            public void onFailure(Call<RestaurantInfomationResponse> call, Throwable t) {

            }




        });



    }



}

