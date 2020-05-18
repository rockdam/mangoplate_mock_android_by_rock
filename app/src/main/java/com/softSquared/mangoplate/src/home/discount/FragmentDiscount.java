package com.softSquared.mangoplate.src.home.discount;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softSquared.mangoplate.R;
import com.softSquared.mangoplate.src.home.HomeAcitivity;
import com.softSquared.mangoplate.src.home.mystatus.events.EventsService;
import com.softSquared.mangoplate.src.home.search_restaurant.RestaurantRecyclerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class FragmentDiscount extends Fragment {
    private TabLayout mTabLayout;
    private Context mContext;
    private ViewPager mViewPager;
    ViewGroup mRootView;
    HomeAcitivity mHomeAcitivity;
    Toolbar mAppToolbar;
    RecyclerView mRecyclerView;

    private GridLayoutManager mGridLayoutManager;

    private RestaurantRecyclerAdapter madapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mContext = context;
        mHomeAcitivity = (HomeAcitivity) getActivity();
         EatDealsService mainService = new EatDealsService(mHomeAcitivity);
        mainService.tryGetEdeals();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_discount, container, false);


        Log.e("dd","잔디가 안 심어지는 이유가 있었다..");



        Log.e("dd","잔디가 안 심어지는 이유가 있었다..");
        return mRootView;
    }



}
