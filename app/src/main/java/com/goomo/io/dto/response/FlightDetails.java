
package com.goomo.io.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlightDetails implements Parcelable
{

    @SerializedName("travel_plan_id")
    @Expose
    private String travelPlanId;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("travel_duration_in_minutes")
    @Expose
    private int travelDurationInMinutes;
    @SerializedName("flights")
    @Expose
    private List<Flight> flights = null;
    @SerializedName("pricing")
    @Expose
    private Pricing_ pricing;
    @SerializedName("booking_pricing")
    @Expose
    private BookingPricing bookingPricing;
    @SerializedName("refundable")
    @Expose
    private boolean refundable;
    @SerializedName("special_fare")
    @Expose
    private SpecialFare specialFare;
    public final static Creator<FlightDetails> CREATOR = new Creator<FlightDetails>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FlightDetails createFromParcel(Parcel in) {
            return new FlightDetails(in);
        }

        public FlightDetails[] newArray(int size) {
            return (new FlightDetails[size]);
        }

    }
    ;

    protected FlightDetails(Parcel in) {
        this.travelPlanId = ((String) in.readValue((String.class.getClassLoader())));
        this.origin = ((String) in.readValue((String.class.getClassLoader())));
        this.destination = ((String) in.readValue((String.class.getClassLoader())));
        this.travelDurationInMinutes = ((int) in.readValue((int.class.getClassLoader())));
        in.readList(this.flights, (Flight.class.getClassLoader()));
        this.pricing = ((Pricing_) in.readValue((Pricing_.class.getClassLoader())));
        this.bookingPricing = ((BookingPricing) in.readValue((BookingPricing.class.getClassLoader())));
        this.refundable = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.specialFare = ((SpecialFare) in.readValue((SpecialFare.class.getClassLoader())));
    }

    public FlightDetails() {
    }

    public String getTravelPlanId() {
        return travelPlanId;
    }

    public void setTravelPlanId(String travelPlanId) {
        this.travelPlanId = travelPlanId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTravelDurationInMinutes() {
        return travelDurationInMinutes;
    }

    public void setTravelDurationInMinutes(int travelDurationInMinutes) {
        this.travelDurationInMinutes = travelDurationInMinutes;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Pricing_ getPricing() {
        return pricing;
    }

    public void setPricing(Pricing_ pricing) {
        this.pricing = pricing;
    }

    public BookingPricing getBookingPricing() {
        return bookingPricing;
    }

    public void setBookingPricing(BookingPricing bookingPricing) {
        this.bookingPricing = bookingPricing;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public SpecialFare getSpecialFare() {
        return specialFare;
    }

    public void setSpecialFare(SpecialFare specialFare) {
        this.specialFare = specialFare;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(travelPlanId);
        dest.writeValue(origin);
        dest.writeValue(destination);
        dest.writeValue(travelDurationInMinutes);
        dest.writeList(flights);
        dest.writeValue(pricing);
        dest.writeValue(bookingPricing);
        dest.writeValue(refundable);
        dest.writeValue(specialFare);
    }

    public int describeContents() {
        return  0;
    }

}
