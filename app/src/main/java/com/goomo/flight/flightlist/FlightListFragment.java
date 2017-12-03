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

import com.goomo.GoomoApplication;
import com.goomo.R;
import com.goomo.base.BaseFragment;
import com.goomo.dagger.module.FlightListModule;
import com.goomo.io.dto.response.FlightDetails;
import com.goomo.io.dto.response.FlightResults;
import com.goomo.utils.DialogUtility;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by VijayaLakshmi.IN on 25-11-2017.
 */
public class FlightListFragment extends BaseFragment implements FlightListView {

    private static final String SEARCH_TRACK_ID = "search_track_id";

    private ArrayList<FlightDetails> mFlightList = new ArrayList<>();
    private FlightListAdapter mFlightListAdapter;

    @Inject
    FlightListPresenter mPresenter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

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
        setLayout(inflater, R.layout.recycler_view);

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
            mPresenter.fetchSearchResults(bundle.getString(SEARCH_TRACK_ID));
        }
    }

    @Override
    public void setResponse(FlightResults response) {
        if (response != null && response.getFlightDetails() != null && !response.getFlightDetails().isEmpty()) {
            mFlightList.clear();
            mFlightList.addAll(response.getFlightDetails());
            mFlightListAdapter.notifyDataSetChanged();
        } else {
            DialogUtility.showToast(getActivity(), getString(R.string.no_flights_found));
        }
    }
}
