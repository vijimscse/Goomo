
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("missing_connectors_count")
    @Expose
    private int missingConnectorsCount;
    @SerializedName("flight_type")
    @Expose
    private String flightType;
    @SerializedName("total_connectors")
    @Expose
    private int totalConnectors;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
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

    }
    ;

    protected Meta(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.missingConnectorsCount = ((int) in.readValue((int.class.getClassLoader())));
        this.flightType = ((String) in.readValue((String.class.getClassLoader())));
        this.totalConnectors = ((int) in.readValue((int.class.getClassLoader())));
        this.origin = ((String) in.readValue((String.class.getClassLoader())));
        this.destination = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Meta() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMissingConnectorsCount() {
        return missingConnectorsCount;
    }

    public void setMissingConnectorsCount(int missingConnectorsCount) {
        this.missingConnectorsCount = missingConnectorsCount;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public int getTotalConnectors() {
        return totalConnectors;
    }

    public void setTotalConnectors(int totalConnectors) {
        this.totalConnectors = totalConnectors;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(missingConnectorsCount);
        dest.writeValue(flightType);
        dest.writeValue(totalConnectors);
        dest.writeValue(origin);
        dest.writeValue(destination);
    }

    public int describeContents() {
        return  0;
    }

}
