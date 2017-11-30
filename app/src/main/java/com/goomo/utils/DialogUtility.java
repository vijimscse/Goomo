package com.goomo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by VijayaLakshmi.IN on 11/29/2017.
 */

public class DialogUtility {
    private static Toast mToast;

    public static void showToast(Context context, String message) {
        if (mToast != null) {
            mToast.cancel();
        }
        if (context != null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            mToast.show();
        }
    }
}
