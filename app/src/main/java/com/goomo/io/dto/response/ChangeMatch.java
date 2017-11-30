
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangeMatch implements Parcelable
{

    @SerializedName("airport")
    @Expose
    private boolean airport;
    @SerializedName("terminal")
    @Expose
    private boolean terminal;
    public final static Creator<ChangeMatch> CREATOR = new Creator<ChangeMatch>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ChangeMatch createFromParcel(Parcel in) {
            return new ChangeMatch(in);
        }

        public ChangeMatch[] newArray(int size) {
            return (new ChangeMatch[size]);
        }

    }
    ;

    protected ChangeMatch(Parcel in) {
        this.airport = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.terminal = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    public ChangeMatch() {
    }

    public boolean isAirport() {
        return airport;
    }

    public void setAirport(boolean airport) {
        this.airport = airport;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(airport);
        dest.writeValue(terminal);
    }

    public int describeContents() {
        return  0;
    }

}
