
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecialFare implements Parcelable
{

    @SerializedName("is_special")
    @Expose
    private boolean isSpecial;
    @SerializedName("base_travel_plan")
    @Expose
    private Object baseTravelPlan;
    @SerializedName("promo_travel_plan")
    @Expose
    private Object promoTravelPlan;
    @SerializedName("matching_travel_plans")
    @Expose
    private MatchingTravelPlans matchingTravelPlans;
    public final static Creator<SpecialFare> CREATOR = new Creator<SpecialFare>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SpecialFare createFromParcel(Parcel in) {
            return new SpecialFare(in);
        }

        public SpecialFare[] newArray(int size) {
            return (new SpecialFare[size]);
        }

    }
    ;

    protected SpecialFare(Parcel in) {
        this.isSpecial = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.baseTravelPlan = ((Object) in.readValue((Object.class.getClassLoader())));
        this.promoTravelPlan = ((Object) in.readValue((Object.class.getClassLoader())));
        this.matchingTravelPlans = ((MatchingTravelPlans) in.readValue((MatchingTravelPlans.class.getClassLoader())));
    }

    public SpecialFare() {
    }

    public boolean isIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public Object getBaseTravelPlan() {
        return baseTravelPlan;
    }

    public void setBaseTravelPlan(Object baseTravelPlan) {
        this.baseTravelPlan = baseTravelPlan;
    }

    public Object getPromoTravelPlan() {
        return promoTravelPlan;
    }

    public void setPromoTravelPlan(Object promoTravelPlan) {
        this.promoTravelPlan = promoTravelPlan;
    }

    public MatchingTravelPlans getMatchingTravelPlans() {
        return matchingTravelPlans;
    }

    public void setMatchingTravelPlans(MatchingTravelPlans matchingTravelPlans) {
        this.matchingTravelPlans = matchingTravelPlans;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isSpecial);
        dest.writeValue(baseTravelPlan);
        dest.writeValue(promoTravelPlan);
        dest.writeValue(matchingTravelPlans);
    }

    public int describeContents() {
        return  0;
    }

}
