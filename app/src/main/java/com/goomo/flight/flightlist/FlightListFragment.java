package com.goomo.flight.flightlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goomo.GoomoApplication;
import com.goomo.R;
import com.goomo.base.BaseFragment;
import com.goomo.dagger.module.FlightListModule;
import com.goomo.io.dto.response.FlightDetails;
import com.goomo.io.dto.response.FlightResults;
import com.goomo.io.dto.response.Meta;
import com.goomo.io.dto.response.Pricing_;
import com.goomo.utils.DialogUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by VijayaLakshmi.IN on 25-11-2017.
 */
public class FlightListFragment extends BaseFragment implements FlightListView {

    private static final String SEARCH_TRACK_ID = "search_track_id";
    private static final String STATUS_PENDING = "PENDING";

    private ArrayList<FlightDetails> mFlightList = new ArrayList<>();
    private ArrayList<FlightDetails> mActualList = new ArrayList<>();

    private FlightListAdapter mFlightListAdapter;

    @Inject
    FlightListPresenter mPresenter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.sort_by_price)
    TextView mSortByPrice;

    @BindView(R.id.sort_by_duration)
    TextView mSortByDuration;

    @BindView(R.id.sort_by_departure)
    TextView mSortByDeparture;

    private boolean mDescending;

    private SortType mPreviousSortType;
    private String mSearchTrackId;

    enum SortType {
        PRICE,
        DURATION,
        DEPARTURE
    }

    public static FlightListFragment newInstance(String searchTrackId) {
        FlightListFragment flightListFragment = new FlightListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SEARCH_TRACK_ID, searchTrackId);
        flightListFragment.setArguments(bundle);

        return flightListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        setLayout(inflater, R.layout.fragment_flight_list);

        ((GoomoApplication) getActivity().getApplicationContext()).getAppComponent().plus(
                new FlightListModule(this, this)).inject(this);


        return mContentContainer;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null && !TextUtils.isEmpty(bundle.getString(SEARCH_TRACK_ID))) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mFlightListAdapter = new FlightListAdapter(getActivity(), mFlightList);
            mRecyclerView.setAdapter(mFlightListAdapter);
            mSearchTrackId = bundle.getString(SEARCH_TRACK_ID);
            showLoading();
            mPresenter.fetchSearchResults(mSearchTrackId);
        }
    }

    @Override
    public void setResponse(FlightResults response) {
        if (response != null) {
            if (response.getFlightDetails() != null && !response.getFlightDetails().isEmpty()) {
                mActualList.addAll(response.getFlightDetails());
            }
            Meta meta = response.getMeta();
            if (meta != null && meta.getStatus() != null) {
                if (meta.getStatus().equalsIgnoreCase(STATUS_PENDING)) {
                    mPresenter.fetchSearchResults(mSearchTrackId);
                } else {
                    hideLoading();
                    mFlightList.clear();
                    mFlightList.addAll(mActualList);
                    mDescending = true;
                    sortFlightList(SortType.PRICE);
                    mFlightListAdapter.notifyDataSetChanged();
                }
            }
        }  else {
            hideLoading();
            DialogUtility.showToast(getActivity(), getString(R.string.no_flights_found));
        }
    }

    @OnClick({R.id.sort_by_departure, R.id.sort_by_duration, R.id.sort_by_price})
    public void onSortOptionsClick(View view) {
        switch (view.getId()) {
            case R.id.sort_by_departure:
                if (mPreviousSortType != null && mPreviousSortType == SortType.DEPARTURE) {
                    mDescending = !mDescending;
                } else {
                    mDescending = false;
                }
                mSortByDeparture.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, mDescending ?
                        R.drawable.ic_arrow_drop_up_black_18dp : R.drawable.ic_arrow_drop_down_black_18dp, 0);
                mSortByDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
                mSortByPrice.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);

                sortFlightList(SortType.DEPARTURE);
                break;

            case R.id.sort_by_duration:
                if (mPreviousSortType != null && mPreviousSortType == SortType.DURATION) {
                    mDescending = !mDescending;
                } else {
                    mDescending = false;
                }
                mSortByDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, mDescending ?
                        R.drawable.ic_arrow_drop_up_black_18dp : R.drawable.ic_arrow_drop_down_black_18dp, 0);
                mSortByDeparture.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
                mSortByPrice.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);

                sortFlightList(SortType.DURATION);
                break;

            case R.id.sort_by_price:
                if (mPreviousSortType != null && mPreviousSortType == SortType.PRICE) {
                    mDescending = !mDescending;
                } else {
                    mDescending = false;
                }
                mSortByPrice.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, mDescending ?
                        R.drawable.ic_arrow_drop_up_black_18dp : R.drawable.ic_arrow_drop_down_black_18dp, 0);
                mSortByDeparture.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
                mSortByDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);

                sortFlightList(SortType.PRICE);
                break;
        }

        mFlightListAdapter.notifyDataSetChanged();
    }

    private void sortFlightList(final SortType sortType) {
        mPreviousSortType = sortType;
        mFlightList.clear();
        mFlightList.addAll(mActualList);
        Collections.sort(mFlightList, new Comparator<FlightDetails>() {
            public int compare(FlightDetails obj1, FlightDetails obj2) {
                int compareResult = 0;
                switch (sortType) {
                    case PRICE:
                        Pricing_ pricing1 = obj1.getPricing();
                        int price1 = (pricing1.getAdult() != null ?
                                pricing1.getAdult().getPrice().getGrossAmount() : 0) +
                                (pricing1.getChild() != null ? pricing1.getChild().getPrice().getGrossAmount() : 0) +
                                (pricing1.getInfant() != null ? pricing1.getInfant().getPrice().getGrossAmount() : 0);
                        Pricing_ pricing2 = obj2.getPricing();
                        int price2 = (pricing2.getAdult() != null ?
                                pricing2.getAdult().getPrice().getGrossAmount() : 0) +
                                (pricing2.getChild() != null ? pricing2.getChild().getPrice().getGrossAmount() : 0) +
                                (pricing2.getInfant() != null ? pricing2.getInfant().getPrice().getGrossAmount() : 0);
                        compareResult = mDescending ? price2 - price1 : price1 - price2;

                        break;

                    case DURATION:
                        int travelDurationInMinutes2 = obj2.getTravelDurationInMinutes();
                        int travelDurationInMinutes1 = obj1.getTravelDurationInMinutes();
                        compareResult = mDescending ? travelDurationInMinutes2 - travelDurationInMinutes1 :
                                travelDurationInMinutes1 - travelDurationInMinutes2;
                        break;

                    case DEPARTURE:
                        compareResult = mDescending ? obj2.getFlights().get(0).getDepartureDatetime()
                                .compareToIgnoreCase(obj1.getFlights().get(0).getDepartureDatetime()) :
                                obj1.getFlights().get(0).getDepartureDatetime()
                                        .compareToIgnoreCase(obj2.getFlights().get(0).getDepartureDatetime());

                        break;
                }

                return compareResult;
            }
        });
    }
}
