
package com.goomo.io.dto.response;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flight implements Parcelable
{

    @SerializedName("flight_id")
    @Expose
    private String flightId;
    @SerializedName("flight_code")
    @Expose
    private String flightCode;
    @SerializedName("airline_code")
    @Expose
    private String airlineCode;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("departure_datetime")
    @Expose
    private String departureDatetime;
    @SerializedName("arrival_datetime")
    @Expose
    private String arrivalDatetime;
    @SerializedName("travel_duration")
    @Expose
    private String travelDuration;
    @SerializedName("travel_duration_in_minutes")
    @Expose
    private int travelDurationInMinutes;
    @SerializedName("aircraft_type")
    @Expose
    private String aircraftType;
    @SerializedName("visa_required")
    @Expose
    private boolean visaRequired;
    @SerializedName("wifi")
    @Expose
    private Object wifi;
    @SerializedName("number_of_stops")
    @Expose
    private int numberOfStops;
    @SerializedName("origin_terminal")
    @Expose
    private String originTerminal;
    @SerializedName("destination_terminal")
    @Expose
    private Object destinationTerminal;
    @SerializedName("change_match")
    @Expose
    private ChangeMatch changeMatch;
    @SerializedName("pricing")
    @Expose
    private List<Pricing> pricing = null;
    @SerializedName("extra_luggage")
    @Expose
    private Object extraLuggage;
    @SerializedName("extra_meals")
    @Expose
    private Object extraMeals;
    @SerializedName("fare_rules")
    @Expose
    private FareRules fareRules;
    @SerializedName("fare_rules_id")
    @Expose
    private Object fareRulesId;
    @SerializedName("no_check_in_luggage_alert")
    @Expose
    private boolean noCheckInLuggageAlert;
    @SerializedName("order_id")
    @Expose
    private int orderId;
    @SerializedName("layover_duration_in_minutes")
    @Expose
    private Object layoverDurationInMinutes;
    public final static Creator<Flight> CREATOR = new Creator<Flight>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Flight createFromParcel(Parcel in) {
            return new Flight(in);
        }

        public Flight[] newArray(int size) {
            return (new Flight[size]);
        }

    }
    ;

    protected Flight(Parcel in) {
        this.flightId = ((String) in.readValue((String.class.getClassLoader())));
        this.flightCode = ((String) in.readValue((String.class.getClassLoader())));
        this.airlineCode = ((String) in.readValue((String.class.getClassLoader())));
        this.origin = ((String) in.readValue((String.class.getClassLoader())));
        this.destination = ((String) in.readValue((String.class.getClassLoader())));
        this.departureDatetime = ((String) in.readValue((String.class.getClassLoader())));
        this.arrivalDatetime = ((String) in.readValue((String.class.getClassLoader())));
        this.travelDuration = ((String) in.readValue((String.class.getClassLoader())));
        this.travelDurationInMinutes = ((int) in.readValue((int.class.getClassLoader())));
        this.aircraftType = ((String) in.readValue((String.class.getClassLoader())));
        this.visaRequired = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.wifi = ((Object) in.readValue((Object.class.getClassLoader())));
        this.numberOfStops = ((int) in.readValue((int.class.getClassLoader())));
        this.originTerminal = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationTerminal = ((Object) in.readValue((Object.class.getClassLoader())));
        this.changeMatch = ((ChangeMatch) in.readValue((ChangeMatch.class.getClassLoader())));
        in.readList(this.pricing, (Pricing.class.getClassLoader()));
        this.extraLuggage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.extraMeals = ((Object) in.readValue((Object.class.getClassLoader())));
        this.fareRules = ((FareRules) in.readValue((FareRules.class.getClassLoader())));
        this.fareRulesId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.noCheckInLuggageAlert = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.orderId = ((int) in.readValue((int.class.getClassLoader())));
        this.layoverDurationInMinutes = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Flight() {
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
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

    public String getDepartureDatetime() {
        return departureDatetime;
    }

    public void setDepartureDatetime(String departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    public String getArrivalDatetime() {
        return arrivalDatetime;
    }

    public void setArrivalDatetime(String arrivalDatetime) {
        this.arrivalDatetime = arrivalDatetime;
    }

    public String getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(String travelDuration) {
        this.travelDuration = travelDuration;
    }

    public int getTravelDurationInMinutes() {
        return travelDurationInMinutes;
    }

    public void setTravelDurationInMinutes(int travelDurationInMinutes) {
        this.travelDurationInMinutes = travelDurationInMinutes;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public boolean isVisaRequired() {
        return visaRequired;
    }

    public void setVisaRequired(boolean visaRequired) {
        this.visaRequired = visaRequired;
    }

    public Object getWifi() {
        return wifi;
    }

    public void setWifi(Object wifi) {
        this.wifi = wifi;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public String getOriginTerminal() {
        return originTerminal;
    }

    public void setOriginTerminal(String originTerminal) {
        this.originTerminal = originTerminal;
    }

    public Object getDestinationTerminal() {
        return destinationTerminal;
    }

    public void setDestinationTerminal(Object destinationTerminal) {
        this.destinationTerminal = destinationTerminal;
    }

    public ChangeMatch getChangeMatch() {
        return changeMatch;
    }

    public void setChangeMatch(ChangeMatch changeMatch) {
        this.changeMatch = changeMatch;
    }

    public List<Pricing> getPricing() {
        return pricing;
    }

    public void setPricing(List<Pricing> pricing) {
        this.pricing = pricing;
    }

    public Object getExtraLuggage() {
        return extraLuggage;
    }

    public void setExtraLuggage(Object extraLuggage) {
        this.extraLuggage = extraLuggage;
    }

    public Object getExtraMeals() {
        return extraMeals;
    }

    public void setExtraMeals(Object extraMeals) {
        this.extraMeals = extraMeals;
    }

    public FareRules getFareRules() {
        return fareRules;
    }

    public void setFareRules(FareRules fareRules) {
        this.fareRules = fareRules;
    }

    public Object getFareRulesId() {
        return fareRulesId;
    }

    public void setFareRulesId(Object fareRulesId) {
        this.fareRulesId = fareRulesId;
    }

    public boolean isNoCheckInLuggageAlert() {
        return noCheckInLuggageAlert;
    }

    public void setNoCheckInLuggageAlert(boolean noCheckInLuggageAlert) {
        this.noCheckInLuggageAlert = noCheckInLuggageAlert;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Object getLayoverDurationInMinutes() {
        return layoverDurationInMinutes;
    }

    public void setLayoverDurationInMinutes(Object layoverDurationInMinutes) {
        this.layoverDurationInMinutes = layoverDurationInMinutes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(flightId);
        dest.writeValue(flightCode);
        dest.writeValue(airlineCode);
        dest.writeValue(origin);
        dest.writeValue(destination);
        dest.writeValue(departureDatetime);
        dest.writeValue(arrivalDatetime);
        dest.writeValue(travelDuration);
        dest.writeValue(travelDurationInMinutes);
        dest.writeValue(aircraftType);
        dest.writeValue(visaRequired);
        dest.writeValue(wifi);
        dest.writeValue(numberOfStops);
        dest.writeValue(originTerminal);
        dest.writeValue(destinationTerminal);
        dest.writeValue(changeMatch);
        dest.writeList(pricing);
        dest.writeValue(extraLuggage);
        dest.writeValue(extraMeals);
        dest.writeValue(fareRules);
        dest.writeValue(fareRulesId);
        dest.writeValue(noCheckInLuggageAlert);
        dest.writeValue(orderId);
        dest.writeValue(layoverDurationInMinutes);
    }

    public int describeContents() {
        return  0;
    }

}
