
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child implements Parcelable
{

    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("tax_details")
    @Expose
    private Object taxDetails;
    public final static Creator<Child> CREATOR = new Creator<Child>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Child createFromParcel(Parcel in) {
            return new Child(in);
        }

        public Child[] newArray(int size) {
            return (new Child[size]);
        }

    }
    ;

    protected Child(Parcel in) {
        this.price = ((Price) in.readValue((Price.class.getClassLoader())));
        this.taxDetails = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Child() {
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
