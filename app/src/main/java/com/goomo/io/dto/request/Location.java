package com.goomo.io.dto.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VijayaLakshmi.IN on 24-11-2017.
 */

public class Location {

    @SerializedName("airport")
    String mAirport;

    public Location(String airport) {
        mAirport = airport;
    }
}
