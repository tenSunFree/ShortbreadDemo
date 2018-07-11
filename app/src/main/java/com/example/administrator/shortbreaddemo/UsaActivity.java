package com.example.administrator.shortbreaddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.shortbreaddemo.Utils.LocaleUtil;

import shortbread.Shortcut;

@Shortcut(id = "usa", icon = R.drawable.if_flag_of_united_states2, shortLabelRes = R.string.label_usa, rank = 3)
public class UsaActivity extends Activity {

    private Button button_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usa);

        /** 將語言切換為英文, 並跳轉到Main2Activity */
        button_enter = findViewById(R.id.button_enter);
        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocaleUtil.changeAppLanguage(getApplicationContext(), 2);
                Intent intent = new Intent(UsaActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
