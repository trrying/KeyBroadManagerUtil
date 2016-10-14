package com.owm.lib_keybroadutil;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 其他util方法，一些琐碎的util方法；
 * Created by ouweiming on 2016/9/12.
 */
public class KeyBroadUtil {

    /**
     * 隐藏输入键盘
     * @param activity 获取焦点view
     */
    public static boolean hideKeyBroad(Activity activity) {
        if (activity == null) {
            Log.i("hideKeyBroad", "activity is null");
            return false;
        }
        return hideKeyBroad(activity.getCurrentFocus());
    }

    /**
     * 隐藏输入键盘
     * @param fragment 获取焦点view
     */
    public static boolean hideKeyBroad(Fragment fragment) {
        if (fragment == null) {
            Log.i("hideKeyBroad", "fragment is null");
            return false;
        }
        if (!hideKeyBroad(fragment.getActivity())) {
            return hideKeyBroad(fragment.getView());
        }
        return true;
    }

    /**
     * 隐藏输入键盘
     * @param focusView 获得焦点view
     */
    public static boolean hideKeyBroad(View focusView) {
        if (focusView == null) {
            Log.i("hideKeyBroad", "focusView is null");
            return false;
        }
        if (focusView.getWindowToken() == null) {
            Log.i("hideKeyBroad", "hideKeyBroad fail, focusView.getCurrentFocus() == null");
            return false;
        }
        InputMethodManager imm = (InputMethodManager) focusView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        return imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
    }

}
