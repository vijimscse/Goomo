package com.goomo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtility {

	/**
	 * Provides whether internet is connected or not
	 * @param context
	 * @return true if connected , 
	 * else false
	 */
	public static boolean isInternetOn(Context context) {
		if (context == null) 
			return false;
		
			ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = conn.getActiveNetworkInfo();
			if (networkInfo != null) {
				return networkInfo.isConnected();
			}
		
		return false;
	}
}
