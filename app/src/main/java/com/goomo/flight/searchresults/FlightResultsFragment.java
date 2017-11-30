package com.goomo.flight.searchresults;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goomo.GoomoApplication;
import com.goomo.R;
import com.goomo.base.BaseFragment;
import com.goomo.base.BaseView;
import com.goomo.dagger.module.FlightResultsModule;

import butterknife.BindView;

/**
 * Created by VijayaLakshmi.IN on 25-11-2017.
 */
public class FlightResultsFragment extends BaseFragment implements BaseView {

    private static final String SEARCH_TRACK_ID = "search_track_id";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    public static FlightResultsFragment newInstance(String searchTrackId) {
        FlightResultsFragment flightResultsFragment = new FlightResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SEARCH_TRACK_ID, searchTrackId);
        flightResultsFragment.setArguments(bundle);

        return flightResultsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        setLayout(inflater, R.layout.recycler_view);

        ((GoomoApplication) getActivity().getApplicationContext()).getAppComponent().plus(
                new FlightResultsModule(this, this)).inject(this);


        return mContentContainer;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null && !TextUtils.isEmpty(bundle.getString(SEARCH_TRACK_ID))) {
            //TODO: Fetch the flight results.
        }
    }
}
