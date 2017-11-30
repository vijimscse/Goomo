
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Luggage implements Parcelable
{

    @SerializedName("hand")
    @Expose
    private Hand hand;
    @SerializedName("check_in")
    @Expose
    private CheckIn checkIn;
    public final static Creator<Luggage> CREATOR = new Creator<Luggage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Luggage createFromParcel(Parcel in) {
            return new Luggage(in);
        }

        public Luggage[] newArray(int size) {
            return (new Luggage[size]);
        }

    }
    ;

    protected Luggage(Parcel in) {
        this.hand = ((Hand) in.readValue((Hand.class.getClassLoader())));
        this.checkIn = ((CheckIn) in.readValue((CheckIn.class.getClassLoader())));
    }

    public Luggage() {
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(hand);
        dest.writeValue(checkIn);
    }

    public int describeContents() {
        return  0;
    }

}
