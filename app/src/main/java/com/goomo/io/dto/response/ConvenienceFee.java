
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConvenienceFee implements Parcelable
{

    @SerializedName("default")
    @Expose
    private int _default;
    @SerializedName("credit_card")
    @Expose
    private int creditCard;
    @SerializedName("netbanking")
    @Expose
    private int netbanking;
    @SerializedName("wallet")
    @Expose
    private int wallet;
    public final static Creator<ConvenienceFee> CREATOR = new Creator<ConvenienceFee>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ConvenienceFee createFromParcel(Parcel in) {
            return new ConvenienceFee(in);
        }

        public ConvenienceFee[] newArray(int size) {
            return (new ConvenienceFee[size]);
        }

    }
    ;

    protected ConvenienceFee(Parcel in) {
        this._default = ((int) in.readValue((int.class.getClassLoader())));
        this.creditCard = ((int) in.readValue((int.class.getClassLoader())));
        this.netbanking = ((int) in.readValue((int.class.getClassLoader())));
        this.wallet = ((int) in.readValue((int.class.getClassLoader())));
    }

    public ConvenienceFee() {
    }

    public int getDefault() {
        return _default;
    }

    public void setDefault(int _default) {
        this._default = _default;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }

    public int getNetbanking() {
        return netbanking;
    }

    public void setNetbanking(int netbanking) {
        this.netbanking = netbanking;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_default);
        dest.writeValue(creditCard);
        dest.writeValue(netbanking);
        dest.writeValue(wallet);
    }

    public int describeContents() {
        return  0;
    }

}
