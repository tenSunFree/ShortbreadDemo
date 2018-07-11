package com.example.administrator.shortbreaddemo.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.administrator.shortbreaddemo.SampleApplication;

/**
 * Created by xpf on 2017/03/25 :) * Function: sp存储的工具类
 */
public class SharedPreferenceUtils {

    private static final String APP_SP = "app_sp";

    private SharedPreferenceUtils() {
    }

    private static SharedPreferenceUtils instance = new SharedPreferenceUtils();
    private static SharedPreferences mSp = null;

    public static SharedPreferenceUtils getInstance() {
        if (mSp == null) {
            mSp = SampleApplication.context.getSharedPreferences(APP_SP, Context.MODE_PRIVATE);
        }
        return instance;
    }

    /**
     * 保存数据
     *
     * @param key   键
     * @param value 值
     */
    public void save(String key, Object value) {
        if (value == null) {
            Toast.makeText(SampleApplication.context, "保存失敗", Toast.LENGTH_SHORT).show();
            return;
        }
        if (value instanceof String) {
            mSp.edit().putString(key, (String) value).commit();
        } else if (value instanceof Boolean) {
            mSp.edit().putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof Integer) {
            mSp.edit().putInt(key, (Integer) value).commit();
        }
    }
}
