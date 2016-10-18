package com.owm.lib_keybroadutil;

import android.os.SystemClock;

/**
 * Created by ouweiming on 2016/10/18.
 */

public class MoreClick {

    long[] mHits = new long[2];
    public boolean click(){
        //每点击一次 实现左移一格数据
        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
        //给数组的最后赋当前时钟值
        mHits[mHits.length - 1] = SystemClock.uptimeMillis();
        //当0出的值大于当前时间-500时  证明在500秒内点击了2次
        if(mHits[0] > SystemClock.uptimeMillis() - 500){
            return true;
        }
        return false;
    }

}
