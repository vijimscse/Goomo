
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price implements Parcelable
{

    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("gross_amount")
    @Expose
    private int grossAmount;
    @SerializedName("commision")
    @Expose
    private int commision;
    @SerializedName("original_gross_amount")
    @Expose
    private int originalGrossAmount;
    @SerializedName("service_tax")
    @Expose
    private Object serviceTax;
    @SerializedName("yq")
    @Expose
    private int yq;
    public final static Creator<Price> CREATOR = new Creator<Price>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Price createFromParcel(Parcel in) {
            return new Price(in);
        }

        public Price[] newArray(int size) {
            return (new Price[size]);
        }

    }
    ;

    protected Price(Parcel in) {
        this.amount = ((int) in.readValue((int.class.getClassLoader())));
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        this.grossAmount = ((int) in.readValue((int.class.getClassLoader())));
        this.commision = ((int) in.readValue((int.class.getClassLoader())));
        this.originalGrossAmount = ((int) in.readValue((int.class.getClassLoader())));
        this.serviceTax = ((Object) in.readValue((Object.class.getClassLoader())));
        this.yq = ((int) in.readValue((int.class.getClassLoader())));
    }

    public Price() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(int grossAmount) {
        this.grossAmount = grossAmount;
    }

    public int getCommision() {
        return commision;
    }

    public void setCommision(int commision) {
        this.commision = commision;
    }

    public int getOriginalGrossAmount() {
        return originalGrossAmount;
    }

    public void setOriginalGrossAmount(int originalGrossAmount) {
        this.originalGrossAmount = originalGrossAmount;
    }

    public Object getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(Object serviceTax) {
        this.serviceTax = serviceTax;
    }

    public int getYq() {
        return yq;
    }

    public void setYq(int yq) {
        this.yq = yq;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(amount);
        dest.writeValue(currency);
        dest.writeValue(grossAmount);
        dest.writeValue(commision);
        dest.writeValue(originalGrossAmount);
        dest.writeValue(serviceTax);
        dest.writeValue(yq);
    }

    public int describeContents() {
        return  0;
    }

}
