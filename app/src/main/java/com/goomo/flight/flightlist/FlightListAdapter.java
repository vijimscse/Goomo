package com.goomo.flight.flightlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goomo.R;
import com.goomo.io.dto.response.Flight;
import com.goomo.io.dto.response.FlightDetails;
import com.goomo.io.dto.response.Pricing_;
import com.goomo.utils.DateUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VijayaLakshmi.IN on 03-12-2017.
 */

public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.FlightResultViewHolder> {
    private static final String AIRLINE_CODE_AI = "AI";
    private static final String AIRLINE_CODE_9W = "9W";
    private Context mContext;
    private List<FlightDetails> mFlightList;

    public FlightListAdapter(Context context, List<FlightDetails> flightFlightDetails) {
        mContext = context;
        mFlightList = flightFlightDetails;
    }

    @Override
    public FlightResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_flight, parent, false);

        return new FlightResultViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FlightResultViewHolder holder, int position) {
        FlightDetails flightDetails = mFlightList.get(position);
        holder.bindViews(flightDetails);
    }

    @Override
    public int getItemCount() {
        return mFlightList.size();
    }

    public class FlightResultViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.departure_time)
        TextView mDepartureTime;

        @BindView(R.id.arrival_time)
        TextView mArrivalTime;

        @BindView(R.id.flight_fare)
        TextView mFlightFare;

        @BindView(R.id.no_of_stops)
        TextView mNoOfStops;

        @BindView(R.id.travel_time)
        TextView mTravelTime;

        @BindView(R.id.travel_origin_destination)
        TextView mTravelOriginDestination;

        @BindView(R.id.travel_flight_name)
        TextView mTravelFlightName;

        public FlightResultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindViews(FlightDetails flightDetails) {
            if (flightDetails != null) {
                List<Flight> flightList = flightDetails.getFlights();

                Flight originFlight = flightList.get(0);
                int lastFlightIndex = flightList.size() - 1;
                Flight destinationFlight = flightList.get(lastFlightIndex);
                mDepartureTime.setText(DateUtils.getTimeFormat(originFlight.getDepartureDatetime()));
                mArrivalTime.setText(DateUtils.getTimeFormat(destinationFlight.getArrivalDatetime()));
                mNoOfStops.setText(mContext.getString(R.string.no_of_stops, lastFlightIndex));

                long seconds = TimeUnit.MINUTES.toMillis(flightDetails.getTravelDurationInMinutes()) / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;
                long days = hours / 24;
               // String time = days + ":" + hours % 24 + ":" + minutes % 60 + ":" + seconds % 60;

                StringBuilder timeStringBuilder = new StringBuilder();
                timeStringBuilder.append(days > 0 ? days + "d " : "")
                        .append((hours % 24 > 0 || days > 0) ? hours % 24 + "h " : "")
                        .append(minutes % 60 > 0 ? minutes % 60 + "m " : "");

                mTravelTime.setText(timeStringBuilder.toString());
                mTravelOriginDestination.setText(mContext.getString(R.string.
                                travel_origin_destination, originFlight.getOrigin(),
                        destinationFlight.getDestination()));
                switch (originFlight.getAirlineCode()) {
                    case AIRLINE_CODE_AI:
                        mTravelFlightName.setText(R.string.airline_india);
                        break;

                    case AIRLINE_CODE_9W:
                        mTravelFlightName.setText(R.string.go_air);
                        break;
                }

                Pricing_ pricing = flightDetails.getPricing();
                int price = (pricing.getAdult() != null ?
                        pricing.getAdult().getPrice().getGrossAmount() : 0) +
                        (pricing.getChild() != null ? pricing.getChild().getPrice().getGrossAmount() : 0) +
                        (pricing.getInfant() != null ? pricing.getInfant().getPrice().getGrossAmount() : 0);
                //pricing.getInfant().getPrice().getGrossAmount();

                mFlightFare.setText(mContext.getString(R.string.amount_format, price));
            }
        }
    }
}