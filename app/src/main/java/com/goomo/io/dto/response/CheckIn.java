
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckIn implements Parcelable
{

    @SerializedName("quantity")
    @Expose
    private int quantity;
    @SerializedName("unit")
    @Expose
    private String unit;
    public final static Creator<CheckIn> CREATOR = new Creator<CheckIn>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CheckIn createFromParcel(Parcel in) {
            return new CheckIn(in);
        }

        public CheckIn[] newArray(int size) {
            return (new CheckIn[size]);
        }

    }
    ;

    protected CheckIn(Parcel in) {
        this.quantity = ((int) in.readValue((int.class.getClassLoader())));
        this.unit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CheckIn() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(quantity);
        dest.writeValue(unit);
    }

    public int describeContents() {
        return  0;
    }

}
