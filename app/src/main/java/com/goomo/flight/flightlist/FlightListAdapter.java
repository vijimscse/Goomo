package com.goomo.flight.flightlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

public class FlightListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String AIRLINE_CODE_AI = "AI";
    private static final String AIRLINE_CODE_9W = "9W";
    private static final String AIRLINE_CODE_6E = "6E";
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private Context mContext;
    private List<FlightDetails> mFlightList;
    private boolean mShowLoading;

    public FlightListAdapter(Context context, List<FlightDetails> flightFlightDetails) {
        mContext = context;
        mFlightList = flightFlightDetails;
    }

    public void showLoading(boolean showLoading) {
        mShowLoading = showLoading;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case VIEW_TYPE_ITEM:
                view = LayoutInflater.from(mContext).inflate(R.layout.list_item_flight, parent, false);
                return new FlightResultViewHolder(view);

            case VIEW_TYPE_LOADING:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_loading, parent, false);
                return new LoadingViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == mFlightList.size()) {
            ((LoadingViewHolder) holder).mProgressBar.setVisibility(mShowLoading ? View.VISIBLE : View.GONE);
        } else {
            FlightDetails flightDetails = mFlightList.get(position);
            ((FlightResultViewHolder) holder).bindViews(flightDetails);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == mFlightList.size() ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;

    }

    @Override
    public int getItemCount() {
        return mFlightList.size() + 1;
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

        @BindView(R.id.flight_image)
        ImageView mFlightImage;

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
                mTravelTime.setText(getDurationString(flightDetails).toString());
                mTravelOriginDestination.setText(mContext.getString(R.string.
                                travel_origin_destination, originFlight.getOrigin(),
                        destinationFlight.getDestination()));
                setAirplaneNameAndImage(originFlight);

                Pricing_ pricing = flightDetails.getPricing();
                int price = (pricing.getAdult() != null ?
                        pricing.getAdult().getPrice().getGrossAmount() : 0) +
                        (pricing.getChild() != null ? pricing.getChild().getPrice().getGrossAmount() : 0) +
                        (pricing.getInfant() != null ? pricing.getInfant().getPrice().getGrossAmount() : 0);

                mFlightFare.setText(mContext.getString(R.string.amount_format, price));
            }
        }

        private void setAirplaneNameAndImage(Flight originFlight) {
            switch (originFlight.getAirlineCode()) {
                case AIRLINE_CODE_AI:
                    mTravelFlightName.setText(R.string.airline_india);
                    mFlightImage.setImageResource(R.drawable.air_india_plane);
                    break;

                case AIRLINE_CODE_9W:
                    mTravelFlightName.setText(R.string.go_air);
                    mFlightImage.setImageResource(R.drawable.go_air);
                    break;

                case AIRLINE_CODE_6E:
                    mTravelFlightName.setText(R.string.indigo);
                    mFlightImage.setImageResource(R.drawable.indigo);
                    break;

                default:
                    mTravelFlightName.setText(originFlight.getAirlineCode());
                    mFlightImage.setImageResource(R.drawable.default_plane);
                    break;
            }
        }

        @NonNull
        private StringBuilder getDurationString(FlightDetails flightDetails) {
            long seconds = TimeUnit.MINUTES.toMillis(flightDetails.getTravelDurationInMinutes()) / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            // String time = days + ":" + hours % 24 + ":" + minutes % 60 + ":" + seconds % 60;

            StringBuilder timeStringBuilder = new StringBuilder();
            timeStringBuilder.append(days > 0 ? days + "d " : "")
                    .append((hours % 24 > 0 || days > 0) ? hours % 24 + "h " : "")
                    .append(minutes % 60 > 0 ? minutes % 60 + "m " : "");
            return timeStringBuilder;
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressBar)
        ProgressBar mProgressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}