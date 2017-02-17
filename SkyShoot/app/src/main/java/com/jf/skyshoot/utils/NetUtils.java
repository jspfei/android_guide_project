package com.jf.skyshoot.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.main.PayAgent;
import com.touchtech.player.Constant;

/**
 *检查网路连接
 * Created by admin on 2017/2/7.
 */

public class NetUtils {
    /**
     * 检测当的网络（WLAN、3G/2G）状态
     * @param context Context
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected())
            {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED)
                {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }
    public static void reAgainStartPayAgent(Activity activity, Context context){
        if(!Constant.payAgentFirst){
            Boolean isNetConnection = NetUtils.isNetworkAvailable(context);
            if(isNetConnection){
                PayAgent.initWithKeys(activity, null, "m0001", "m00010001", false);
                Constant.payAgentFirst=true;
            }
        }
    }

}
