package jm.dodamdodam.dodamdodam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WordActivity extends Activity {

    private Button back_btn;
    private Button word_send_btn;
    private EditText word_edit_text;

    private String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        word_edit_text = (EditText) findViewById(R.id.word_edit_text);

        back_btn = (Button) findViewById(R.id.word_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        word_send_btn = (Button) findViewById(R.id.word_send_btn);
        word_send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                word =  word_edit_text.getText().toString();
                if (TextUtils.isEmpty(word))
                    return;

                Intent intent = new Intent(getApplicationContext(), SocketService.class);
                intent.putExtra(Global.FEEL, Global.HAPPY);
                intent.putExtra(Global.WORD, word);
                startService(intent);
            }
        });
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent != null) {
            int code = intent.getIntExtra(Global.CODE, -1);
            if (code != -1) {
                if(code == 200) {
                    Toast.makeText(getApplicationContext(),"성공~!", Toast.LENGTH_SHORT).show();
                } else if (code == 400 || code == 401) {
                    Toast.makeText(getApplicationContext(),"네트워크를 확인하세요.",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
