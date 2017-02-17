package com.jf.skyshoot.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import common.sdFile;

/**
 * 获取andoird系统信息
*/
public final class AndrUtils {

   private AndrUtils() {

    }

    public static String getIMSI(Context context) {
        String imsi = getTelephonyManager(context).getSubscriberId();
        if (TextUtils.isEmpty(imsi)) {
            String ret = sdFile.readUuidWhenNullImsi();
            return ret;
        }
        return imsi;
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
    }
}
