
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlightResults implements Parcelable
{

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    public final static Creator<FlightResults> CREATOR = new Creator<FlightResults>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FlightResults createFromParcel(Parcel in) {
            return new FlightResults(in);
        }

        public FlightResults[] newArray(int size) {
            return (new FlightResults[size]);
        }

    }
    ;

    protected FlightResults(Parcel in) {
        this.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
        in.readList(this.results, (Result.class.getClassLoader()));
    }

    public FlightResults() {
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(meta);
        dest.writeList(results);
    }

    public int describeContents() {
        return  0;
    }

}
