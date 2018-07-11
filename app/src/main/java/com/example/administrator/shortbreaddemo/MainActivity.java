package com.example.administrator.shortbreaddemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** 如果使用者單擊AppIcon時, 只會彈出通知, 告訴使用者必須透過長按來啟動App */
        Toast.makeText(getApplicationContext(), "您好, 請長按圖示後 選擇語言進入", Toast.LENGTH_SHORT).show();
        finish();
    }
}
