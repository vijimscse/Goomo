
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareRules implements Parcelable
{

    @SerializedName("raw")
    @Expose
    private String raw;
    public final static Creator<FareRules> CREATOR = new Creator<FareRules>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FareRules createFromParcel(Parcel in) {
            return new FareRules(in);
        }

        public FareRules[] newArray(int size) {
            return (new FareRules[size]);
        }

    }
    ;

    protected FareRules(Parcel in) {
        this.raw = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FareRules() {
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(raw);
    }

    public int describeContents() {
        return  0;
    }

}
