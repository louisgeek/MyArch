package com.louisgeek.myarch.tool;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by louisgeek on 2016/12/12.
 */
public class ThreadTool {
    public static void runOnUiThread(Runnable runnable) {
        Handler mHandler = new Handler(Looper.getMainLooper());
        //使用Looper类判断
        if (isMainThread()) {
            runnable.run();
        } else {
            mHandler.post(runnable);
        }
    }

    public static boolean isMainThread() {
        //使用Looper类判断
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isMainThread2() {
        //通过查看Thread类的当前线程
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
