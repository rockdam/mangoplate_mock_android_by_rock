package com.softSquared.mangoplate.src.home.mystatus.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.softSquared.mangoplate.R;
import com.softSquared.mangoplate.src.BaseActivity;
import com.softSquared.mangoplate.src.home.mystatus.events.interfaces.EventsActivityView;
import com.softSquared.mangoplate.src.home.mystatus.events.models.EventsResponse;
import com.softSquared.mangoplate.src.home.mystatus.events.models.EventsResult;

import java.util.HashMap;

public class EventsActivity extends BaseActivity implements EventsActivityView {
    private EventsRecyclerAdapter madapter;
    ImageView backkey_events;
    private EventsActivity mEventsActivity;
    private HashMap<String, String> mEventresponse;
    private EventsRecyclerAdapter mAdapter;
    private GridLayoutManager mGridLayoutManager;
    RecyclerView mRecyclerViewEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
        evnets_tryGet(); // events 목록 API 통신 (GET)
        init();// recyclerView 초기화
        backkey_events=findViewById(R.id.backkey_events);
        backkey_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void evnets_tryGet() {

        final EventsService mainService = new EventsService(this);
        mainService.tryEventsGet();
    }


    //코드만 봐도 바로 알 수 있게


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    public void successUpdateRecyclerView(EventsResponse eventsResponse) {

        mAdapter.clear();
        for (EventsResult eventsResult : eventsResponse.getResult()) {
            mAdapter.addItem(eventsResult);
        }
        mAdapter.notifyDataSetChanged();
    }

    private void init() {
        int numberOfColumns = 1;// 한줄에 2개의 컬럼을 추가
        mRecyclerViewEvents = mEventsActivity.findViewById(R.id.recyclerview_events);
        mGridLayoutManager = new GridLayoutManager(mEventsActivity, numberOfColumns);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerViewEvents.setLayoutManager(mGridLayoutManager);
        mAdapter = new EventsRecyclerAdapter(mEventsActivity);
        mRecyclerViewEvents.setAdapter(mAdapter);
    }
}

