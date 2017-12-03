
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pricing_ implements Parcelable
{

    @SerializedName("child")
    @Expose
    private Child child;
    @SerializedName("infant")
    @Expose
    private Infant infant;
    @SerializedName("adult")
    @Expose
    private Adult adult;
    @SerializedName("cancellation_fee")
    @Expose
    private int cancellationFee;
    @SerializedName("date_change_fee")
    @Expose
    private int dateChangeFee;
    @SerializedName("goomo_date_change_fee")
    @Expose
    private int goomoDateChangeFee;
    @SerializedName("goomo_cancellation_fee")
    @Expose
    private int goomoCancellationFee;
    public final static Creator<Pricing_> CREATOR = new Creator<Pricing_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pricing_ createFromParcel(Parcel in) {
            return new Pricing_(in);
        }

        public Pricing_[] newArray(int size) {
            return (new Pricing_[size]);
        }

    }
    ;

    protected Pricing_(Parcel in) {
        this.child = ((Child) in.readValue((Child.class.getClassLoader())));
        this.infant = ((Infant) in.readValue((Infant.class.getClassLoader())));
        this.adult = ((Adult) in.readValue((Adult.class.getClassLoader())));
        this.cancellationFee = ((int) in.readValue((int.class.getClassLoader())));
        this.dateChangeFee = ((int) in.readValue((int.class.getClassLoader())));
        this.goomoDateChangeFee = ((int) in.readValue((int.class.getClassLoader())));
        this.goomoCancellationFee = ((int) in.readValue((int.class.getClassLoader())));
    }

    public Pricing_() {
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Infant getInfant() {
        return infant;
    }

    public void setInfant(Infant infant) {
        this.infant = infant;
    }

    public Adult getAdult() {
        return adult;
    }

    public void setAdult(Adult adult) {
        this.adult = adult;
    }

    public int getCancellationFee() {
        return cancellationFee;
    }

    public void setCancellationFee(int cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public int getDateChangeFee() {
        return dateChangeFee;
    }

    public void setDateChangeFee(int dateChangeFee) {
        this.dateChangeFee = dateChangeFee;
    }

    public int getGoomoDateChangeFee() {
        return goomoDateChangeFee;
    }

    public void setGoomoDateChangeFee(int goomoDateChangeFee) {
        this.goomoDateChangeFee = goomoDateChangeFee;
    }

    public int getGoomoCancellationFee() {
        return goomoCancellationFee;
    }

    public void setGoomoCancellationFee(int goomoCancellationFee) {
        this.goomoCancellationFee = goomoCancellationFee;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(child);
        dest.writeValue(infant);
        dest.writeValue(adult);
        dest.writeValue(cancellationFee);
        dest.writeValue(dateChangeFee);
        dest.writeValue(goomoDateChangeFee);
        dest.writeValue(goomoCancellationFee);
    }

    public int describeContents() {
        return  0;
    }

}
