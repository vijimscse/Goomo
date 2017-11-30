package com.goomo.io.dto.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VijayaLakshmi.IN on 27-11-2017.
 */

public class SearchRequest {

    @SerializedName("origin")
    Location mOrigin;

    @SerializedName("destination")
    Location mDestination;

    @SerializedName("travel_date")
    String mTravelDate;

    @SerializedName("class_type")
    String mClassType;

    @SerializedName("residentof_india")
    boolean mIsResidentofindia;

    @SerializedName("adult_count")
    int mAdultCount;

    @SerializedName("child_count")
    int mChildCount;

    @SerializedName("infant_count")
    int mInfantCount;

    public SearchRequest(Location origin, Location destination, String travelDate, String classType,
                         boolean residentofindia, int adultCount, int childCount, int infantCount) {
        mOrigin = origin;
        mDestination = destination;
        mTravelDate = travelDate;
        mClassType = classType;
        mIsResidentofindia = residentofindia;
        mAdultCount = adultCount;
        mChildCount = childCount;
        mInfantCount = infantCount;
    }
}
