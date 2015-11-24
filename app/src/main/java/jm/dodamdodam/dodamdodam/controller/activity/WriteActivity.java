package jm.dodamdodam.dodamdodam.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import jm.dodamdodam.dodamdodam.Global;
import jm.dodamdodam.dodamdodam.R;

public class WriteActivity extends Activity {

    private Button back_btn;
    private Button save_btn;
    private EditText edit_text;

    private TextView write_date_text;
    private Toolbar toolbar;

    private String diary_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        init();
        setListener();
        setDate();
    }


    private void init() {
        edit_text = (EditText) findViewById(R.id.write_edit_text);
        write_date_text = (TextView) findViewById(R.id.write_date_text);
        save_btn = (Button) findViewById(R.id.write_save_btn);
        back_btn = (Button) findViewById(R.id.write_back_btn);
    }


    private void setListener() {
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diary_str = edit_text.getText().toString();
                if (TextUtils.isEmpty(diary_str)) {
                    // 다이어리 내용 입력 안했을 때
                    edit_text.setError("내용을 입력하세요");
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
                intent.putExtra(Global.DIARY, diary_str);
                startActivity(intent);
                finish();
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void setDate() {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date currentTime = new Date();
        String mTime = mSimpleDateFormat.format(currentTime);
        write_date_text.setText("날짜 : " + mTime);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
