package jm.dodamdodam.dodamdodam.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import jm.dodamdodam.dodamdodam.Global;
import jm.dodamdodam.dodamdodam.R;

public class ViewActivity extends Activity {

    private static final String TAG = "ViewActivity";
    private Button back_btn;
    private TextView view_text_view;
    private TextView view_date_text;

    private long backPressedTime = 0;
    private final long FINISH_INTERVAL_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        view_date_text = (TextView) findViewById(R.id.view_date_text);

        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date currentTime = new Date();
        String mTime = mSimpleDateFormat.format(currentTime);
        view_date_text.setText("날짜 : " + mTime);


        view_text_view = (TextView) findViewById(R.id.view_text_view);
        back_btn = (Button) findViewById(R.id.view_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String diary_str = intent.getStringExtra(Global.DIARY);
            if (diary_str != null) {
                Log.d(TAG, "diary = " + diary_str);
                view_text_view.setText(diary_str);
            }
        }
    }

//    @Override
//    public void onBackPressed() {
//        long tempTime = System.currentTimeMillis();
//        long intervalTime = tempTime - backPressedTime;
//
//        if(0 <= intervalTime && FINISH_INTERVAL_TIME >=intervalTime) {
//            super.onBackPressed();
//        } else {
//            backPressedTime = tempTime;
//        }
//    }
}
