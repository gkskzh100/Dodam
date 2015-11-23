package jm.dodamdodam.dodamdodam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteActivity extends Activity {

    private Button back_btn;
    private Button save_btn;
    private EditText edit_text;

    private TextView write_date_text;

    private String diary_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        edit_text = (EditText) findViewById(R.id.write_edit_text);

        write_date_text = (TextView) findViewById(R.id.write_date_text);

        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date currentTime = new Date();
        String mTime = mSimpleDateFormat.format(currentTime);
        write_date_text.setText("날짜 : " + mTime);

        save_btn = (Button) findViewById(R.id.write_save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diary_str = edit_text.getText().toString();
                Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
                intent.putExtra(Global.DIARY, diary_str);
                startActivity(intent);
                finish();
            }
        });
        back_btn = (Button) findViewById(R.id.write_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
