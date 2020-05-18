package com.softSquared.mangoplate.src.home.advertisement;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.softSquared.mangoplate.R;
import com.softSquared.mangoplate.src.BaseActivity;

import static com.bumptech.glide.Glide.with;


public class ActivityAdvertisement extends BaseActivity {

    ImageView mAdvertisemnetImage;
    String mImageUrl;
    int mEventId;
    TextView advertisement_close;

    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement);
        setView(); //View 세팅
        advertisement_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
        progress=new ProgressBar(getBaseContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
        //액티비티 종료시 애니메이션 주지 말기 .
    }

    void setView()
    {   mAdvertisemnetImage = findViewById(R.id.advertisement_image);
        Intent AdvertisementGetResponse = getIntent();
        //널 값 체크 . 잘 넘어 왔는지 . 남을 믿지 말라 .
        mImageUrl = AdvertisementGetResponse.getExtras().getString("ImageUrl");
        Log.e("이미지 url 체크",mImageUrl);
        advertisement_close = findViewById(R.id.advertisement_close);
        AdvertisementGetResponse.getExtras().getInt("EventId");
        // Glide로 이미지 표시하기
       Glide. with(this).
                load(mImageUrl)     .into(mAdvertisemnetImage);
//                .listener(new RequestListener<String, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        progress.setVisibility(View.GONE);
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        progress.setVisibility(View.GONE);
//                        return false;
//                    }
//                })
//                .crossFade(1000)






    }
}
