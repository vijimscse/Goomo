
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchTrackIdMeta implements Parcelable {

    @SerializedName("search_track_id")
    @Expose
    private String searchTrackId;
    @SerializedName("flight_type")
    @Expose
    private String flightType;
    public final static Creator<SearchTrackIdMeta> CREATOR = new Creator<SearchTrackIdMeta>() {
        @SuppressWarnings({
                "unchecked"
        })
        public SearchTrackIdMeta createFromParcel(Parcel in) {
            return new SearchTrackIdMeta(in);
        }

        public SearchTrackIdMeta[] newArray(int size) {
            return (new SearchTrackIdMeta[size]);
        }

    };

    protected SearchTrackIdMeta(Parcel in) {
        this.searchTrackId = ((String) in.readValue((String.class.getClassLoader())));
        this.flightType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SearchTrackIdMeta() {
    }

    public String getSearchTrackId() {
        return searchTrackId;
    }

    public void setSearchTrackId(String searchTrackId) {
        this.searchTrackId = searchTrackId;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(searchTrackId);
        dest.writeValue(flightType);
    }

    public int describeContents() {
        return 0;
    }

}
