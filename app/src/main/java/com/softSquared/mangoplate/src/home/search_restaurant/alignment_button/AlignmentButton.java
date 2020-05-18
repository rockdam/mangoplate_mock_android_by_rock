package com.softSquared.mangoplate.src.home.search_restaurant.alignment_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.softSquared.mangoplate.R;

public class AlignmentButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alignment_button);
        setWindow(); // 액티비티가 다이얼로그로 변할 때 위치 세팅;

    }

    private void setWindow()
    {
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH, WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH);

    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
        finish();
        //액티비티 애니메이션 x
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            System.out.println("TOuch outside the dialog ******************** ");
            finish();
            return false;
        }

        return false;

    }
}
