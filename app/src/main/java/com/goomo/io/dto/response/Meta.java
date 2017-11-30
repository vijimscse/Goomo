
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta implements Parcelable {

    @SerializedName("search_track_id")
    @Expose
    private String searchTrackId;
    @SerializedName("flight_type")
    @Expose
    private String flightType;
    public final static Creator<Meta> CREATOR = new Creator<Meta>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Meta createFromParcel(Parcel in) {
            return new Meta(in);
        }

        public Meta[] newArray(int size) {
            return (new Meta[size]);
        }

    };

    protected Meta(Parcel in) {
        this.searchTrackId = ((String) in.readValue((String.class.getClassLoader())));
        this.flightType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Meta() {
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
