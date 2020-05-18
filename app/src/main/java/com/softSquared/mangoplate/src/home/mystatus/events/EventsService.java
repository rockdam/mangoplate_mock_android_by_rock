package com.softSquared.mangoplate.src.home.mystatus.events;

import android.util.Log;

import com.softSquared.mangoplate.R;
import com.softSquared.mangoplate.src.home.interfaces.HomeActivityView;
import com.softSquared.mangoplate.src.home.mystatus.events.interfaces.EventsActivityView;
import com.softSquared.mangoplate.src.home.mystatus.events.interfaces.EventsRetrofitInterface;
import com.softSquared.mangoplate.src.home.mystatus.events.models.EventsResponse;
import com.softSquared.mangoplate.src.home.mystatus.events.models.EventsResult;

import java.util.HashMap;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softSquared.mangoplate.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softSquared.mangoplate.src.ApplicationClass.getRetrofit;

public class EventsService {
    private EventsActivityView mEventsActivityView;

    private EventsActivity mEventsActivity;
    private HashMap<String, String> mEventresponse;
    private EventsRecyclerAdapter mAdapter;
    private GridLayoutManager mGridLayoutManager;
    RecyclerView mRecyclerViewEvents;
    EventsService(final EventsActivityView mEventsActivityView) {
        this.mEventsActivityView = mEventsActivityView;
    }



    void tryEventsGet() {

        final EventsRetrofitInterface eventsRetrofitInterface = getRetrofit().create(EventsRetrofitInterface.class);
        Log.e("성공", "" + "돌긴 도니 ");
        eventsRetrofitInterface.toString();

        eventsRetrofitInterface.GetEvents("detail", X_ACCESS_TOKEN).enqueue(new Callback<EventsResponse>() {
            @Override
            public void onResponse(Call<EventsResponse> call, Response<EventsResponse> response) {
                final EventsResponse eventsResponse = response.body();


                if (eventsResponse.getResult() != null && eventsResponse.getResult().size() > 0) {
                    for (EventsResult eventsResult : eventsResponse.getResult()) {

                        if (response.code() == 200) {

                            mEventsActivityView.successUpdateRecyclerView(eventsResponse);

                        }


                    }


                }

            }

            @Override
            public void onFailure(Call<EventsResponse> call, Throwable t) {

            }


        });
    }

}
