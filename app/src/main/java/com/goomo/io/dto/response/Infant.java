
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Infant implements Parcelable
{

    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("tax_details")
    @Expose
    private Object taxDetails;
    public final static Creator<Infant> CREATOR = new Creator<Infant>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Infant createFromParcel(Parcel in) {
            return new Infant(in);
        }

        public Infant[] newArray(int size) {
            return (new Infant[size]);
        }

    }
    ;

    protected Infant(Parcel in) {
        this.price = ((Price) in.readValue((Price.class.getClassLoader())));
        this.taxDetails = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Infant() {
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
