package com.goomo.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by VijayaLakshmi.IN on 03-12-2017.
 */

public class DateUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static final String TIME_FORMAT = "HH:mm";
    private static final String HEADER_DATE_INPUT_FORMAT = "yyyy-MM-dd";
    private static final String HEADER_DATE_OUTPUT_FORMAT = "dd MMM";
    private static final String SEARCH_DATE_PICKER_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * @param dateTimeStr
     * @return
     */
    public static String getTimeFormat(String dateTimeStr) {
        String formattedDate = "";
        if (!TextUtils.isEmpty(dateTimeStr)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                SimpleDateFormat output = new SimpleDateFormat(TIME_FORMAT);
                Date d = sdf.parse(dateTimeStr);
                formattedDate = output.format(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return formattedDate;
    }

    /**
     * @param dateTimeStr
     * @return
     */
    public static String getHeaderDateFormat(String dateTimeStr) {
        String formattedDate = "";
        if (!TextUtils.isEmpty(dateTimeStr)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(HEADER_DATE_INPUT_FORMAT);
                SimpleDateFormat output = new SimpleDateFormat(HEADER_DATE_OUTPUT_FORMAT);
                Date d = sdf.parse(dateTimeStr);
                formattedDate = output.format(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return formattedDate;
    }

    /**
     * @param dateTimeStr
     * @return
     */
    public static long getTimeInMilliseconds(String dateTimeStr) {
        long timeInMS = 0;
        if (!TextUtils.isEmpty(dateTimeStr)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                Date d = sdf.parse(dateTimeStr);
                timeInMS = d.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return timeInMS;
    }

    public static String getSearchDateFormat(Date date) {
        String formattedDate = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(SEARCH_DATE_PICKER_DATE_FORMAT);
            formattedDate = sdf.format(date);
        }
        return formattedDate;
    }
}
