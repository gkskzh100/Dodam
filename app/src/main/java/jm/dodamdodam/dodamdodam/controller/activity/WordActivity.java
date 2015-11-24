package jm.dodamdodam.dodamdodam.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jm.dodamdodam.dodamdodam.Global;
import jm.dodamdodam.dodamdodam.R;
import jm.dodamdodam.dodamdodam.socketio.SocketReq;

public class WordActivity extends AppCompatActivity {

    private Button back_btn;
    private Button submit;
    private EditText word_edit_text;
    private Toolbar toolbar;

    private String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        init();
        setListener();
    }


    private void init() {
        word_edit_text = (EditText) findViewById(R.id.word_edit_text);
        back_btn = (Button) findViewById(R.id.activity_word_back_btn);
        submit = (Button) findViewById(R.id.activity_word_submit);
        toolbar = (Toolbar) findViewById(R.id.activity_word_toolbar);

        setSupportActionBar(toolbar);
    }


    private void setListener() {
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 확인
                word =  word_edit_text.getText().toString();
                if (TextUtils.isEmpty(word)) {
                    word_edit_text.setError("글귀를 입력하세요");
                    return;
                }

                // 서버에 글귀 추가 요청
                SocketReq.insertWord(getApplicationContext(), Global.HAPPY, word);
            }
        });
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent != null) {
            String command = intent.getStringExtra(Global.COMMAND);
            if (command != null) {
                int code = intent.getIntExtra(Global.CODE, -1);
                if (code != -1) {
                    if(code == 200) {
                        Toast.makeText(getApplicationContext(),"성공~!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else if (code == 400 || code == 401) {
                        Toast.makeText(getApplicationContext(),"네트워크를 확인하세요.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
