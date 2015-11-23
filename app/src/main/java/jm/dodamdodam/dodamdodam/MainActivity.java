package jm.dodamdodam.dodamdodam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nispok.snackbar.Snackbar;

public class MainActivity extends Activity {

    private FloatingActionButton summaryView;
    private FloatingActionButton write;
    private FloatingActionButton add;

    private long backPressedTime = 0;
    private final long FINISH_INTERVAL_TIME = 2000;

    private GridView gridView;
    private CustomAdapter adapter;
    private String[] values = {"ㅁ","ㄴ","ㄷ","ㄹ","ㄴ","ㄷ","ㄹ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomAdapter(this, values);
        gridView = (GridView) findViewById(R.id.main_gridview);
        gridView.setAdapter(adapter);

        summaryView = (FloatingActionButton) findViewById(R.id.btn_summary);
        write = (FloatingActionButton) findViewById(R.id.btn_write);
        add = (FloatingActionButton) findViewById(R.id.btn_add);

        summaryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WriteActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if(0 <= intervalTime && FINISH_INTERVAL_TIME >=intervalTime) {
            super.onBackPressed();
        } else {
            backPressedTime = tempTime;
            Snackbar.with(getApplicationContext())
                    .text("'뒤로' 버튼을 한번 더 누르세요.")
                    .show(this);
        }
    }
}
