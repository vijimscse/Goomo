
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Adult implements Parcelable
{

    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("tax_details")
    @Expose
    private Object taxDetails;
    public final static Creator<Adult> CREATOR = new Creator<Adult>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Adult createFromParcel(Parcel in) {
            return new Adult(in);
        }

        public Adult[] newArray(int size) {
            return (new Adult[size]);
        }

    }
    ;

    protected Adult(Parcel in) {
        this.price = ((Price) in.readValue((Price.class.getClassLoader())));
        this.taxDetails = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Adult() {
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Object getTaxDetails() {
        return taxDetails;
    }

    public void setTaxDetails(Object taxDetails) {
        this.taxDetails = taxDetails;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(price);
        dest.writeValue(taxDetails);
    }

    public int describeContents() {
        return  0;
    }

}
