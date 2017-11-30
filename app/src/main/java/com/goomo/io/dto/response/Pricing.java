
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pricing implements Parcelable
{

    @SerializedName("class_type")
    @Expose
    private String classType;
    @SerializedName("class_code")
    @Expose
    private String classCode;
    @SerializedName("luggage")
    @Expose
    private Luggage luggage;
    public final static Creator<Pricing> CREATOR = new Creator<Pricing>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pricing createFromParcel(Parcel in) {
            return new Pricing(in);
        }

        public Pricing[] newArray(int size) {
            return (new Pricing[size]);
        }

    }
    ;

    protected Pricing(Parcel in) {
        this.classType = ((String) in.readValue((String.class.getClassLoader())));
        this.classCode = ((String) in.readValue((String.class.getClassLoader())));
        this.luggage = ((Luggage) in.readValue((Luggage.class.getClassLoader())));
    }

    public Pricing() {
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(classType);
        dest.writeValue(classCode);
        dest.writeValue(luggage);
    }

    public int describeContents() {
        return  0;
    }

}
