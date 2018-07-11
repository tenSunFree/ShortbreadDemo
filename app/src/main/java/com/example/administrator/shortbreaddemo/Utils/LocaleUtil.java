package com.example.administrator.shortbreaddemo.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;

import com.example.administrator.shortbreaddemo.Main2Activity;

import java.util.Locale;

public class LocaleUtil {

    /**
     * 保存设置的语言
     *
     * @param currentLanguage index
     */
    public static void changeAppLanguage(Context context, int currentLanguage) {
        if (context == null) return;
        Context appContext = context.getApplicationContext();
        SharedPreferenceUtils.getInstance().save("currentLanguage", currentLanguage);
        Locale myLocale = Locale.TAIWAN;
        switch (currentLanguage) {
            case 0:
                myLocale = Locale.TAIWAN;
                break;
            case 1:
                myLocale = Locale.JAPAN;
                break;
            case 2:
                myLocale = Locale.ENGLISH;
                break;
        }
        if (LocaleUtil.needUpdateLocale(appContext, myLocale)) {
            LocaleUtil.updateLocale(appContext, myLocale);
        }
        restartApp(appContext);
    }

    /**
     * 重启app生效
     *
     * @param context
     */
    public static void restartApp(Context context) {
        Intent intent = new Intent(context, Main2Activity.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 获取当前的Locale
     *
     * @param context Context     * @return Locale
     */
    public static Locale getCurrentLocale(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = context.getResources().getConfiguration().locale;
        }
        return locale;
    }

    /**
     * 更新Locale
     * @param context Context     * @param locale  New User Locale
     */
    public static void updateLocale(Context context, Locale locale) {
        if (needUpdateLocale(context, locale)) {
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 19) {
                configuration.setLocale(locale);
            } else {
                configuration.locale = locale;
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            context.getResources().updateConfiguration(configuration, displayMetrics);
        }
    }

    /**
     * 判断需不需要更新     *     * @param context Context     * @param locale  New User Locale     * @return true / false
     */
    public static boolean needUpdateLocale(Context context, Locale locale) {
        return locale != null && !getCurrentLocale(context).equals(locale);
    }
}