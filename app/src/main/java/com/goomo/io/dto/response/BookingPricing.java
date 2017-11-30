
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingPricing implements Parcelable
{

    @SerializedName("promotion_campaign_discount")
    @Expose
    private Object promotionCampaignDiscount;
    @SerializedName("actual_promotion_campaign_discount")
    @Expose
    private Object actualPromotionCampaignDiscount;
    @SerializedName("convenience_fee")
    @Expose
    private ConvenienceFee convenienceFee;
    @SerializedName("actual_convenience_fee")
    @Expose
    private ActualConvenienceFee actualConvenienceFee;
    public final static Creator<BookingPricing> CREATOR = new Creator<BookingPricing>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BookingPricing createFromParcel(Parcel in) {
            return new BookingPricing(in);
        }

        public BookingPricing[] newArray(int size) {
            return (new BookingPricing[size]);
        }

    }
    ;

    protected BookingPricing(Parcel in) {
        this.promotionCampaignDiscount = ((Object) in.readValue((Object.class.getClassLoader())));
        this.actualPromotionCampaignDiscount = ((Object) in.readValue((Object.class.getClassLoader())));
        this.convenienceFee = ((ConvenienceFee) in.readValue((ConvenienceFee.class.getClassLoader())));
        this.actualConvenienceFee = ((ActualConvenienceFee) in.readValue((ActualConvenienceFee.class.getClassLoader())));
    }

    public BookingPricing() {
    }

    public Object getPromotionCampaignDiscount() {
        return promotionCampaignDiscount;
    }

    public void setPromotionCampaignDiscount(Object promotionCampaignDiscount) {
        this.promotionCampaignDiscount = promotionCampaignDiscount;
    }

    public Object getActualPromotionCampaignDiscount() {
        return actualPromotionCampaignDiscount;
    }

    public void setActualPromotionCampaignDiscount(Object actualPromotionCampaignDiscount) {
        this.actualPromotionCampaignDiscount = actualPromotionCampaignDiscount;
    }

    public ConvenienceFee getConvenienceFee() {
        return convenienceFee;
    }

    public void setConvenienceFee(ConvenienceFee convenienceFee) {
        this.convenienceFee = convenienceFee;
    }

    public ActualConvenienceFee getActualConvenienceFee() {
        return actualConvenienceFee;
    }

    public void setActualConvenienceFee(ActualConvenienceFee actualConvenienceFee) {
        this.actualConvenienceFee = actualConvenienceFee;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(promotionCampaignDiscount);
        dest.writeValue(actualPromotionCampaignDiscount);
        dest.writeValue(convenienceFee);
        dest.writeValue(actualConvenienceFee);
    }

    public int describeContents() {
        return  0;
    }

}
