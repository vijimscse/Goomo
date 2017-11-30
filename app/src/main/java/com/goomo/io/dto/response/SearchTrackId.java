
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchTrackId implements Parcelable {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    public final static Creator<SearchTrackId> CREATOR = new Creator<SearchTrackId>() {
        @SuppressWarnings({
                "unchecked"
        })
        public SearchTrackId createFromParcel(Parcel in) {
            return new SearchTrackId(in);
        }

        public SearchTrackId[] newArray(int size) {
            return (new SearchTrackId[size]);
        }

    };

    protected SearchTrackId(Parcel in) {
        this.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
    }

    public SearchTrackId() {
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(meta);
    }

    public int describeContents() {
        return 0;
    }

}
