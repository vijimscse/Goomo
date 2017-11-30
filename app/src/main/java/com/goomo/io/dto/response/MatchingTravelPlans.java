
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchingTravelPlans implements Parcelable
{

    @SerializedName("all")
    @Expose
    private boolean all;
    @SerializedName("list")
    @Expose
    private List<Object> list = null;
    public final static Creator<MatchingTravelPlans> CREATOR = new Creator<MatchingTravelPlans>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MatchingTravelPlans createFromParcel(Parcel in) {
            return new MatchingTravelPlans(in);
        }

        public MatchingTravelPlans[] newArray(int size) {
            return (new MatchingTravelPlans[size]);
        }

    }
    ;

    protected MatchingTravelPlans(Parcel in) {
        this.all = ((boolean) in.readValue((boolean.class.getClassLoader())));
        in.readList(this.list, (Object.class.getClassLoader()));
    }

    public MatchingTravelPlans() {
    }

    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(all);
        dest.writeList(list);
    }

    public int describeContents() {
        return  0;
    }

}
