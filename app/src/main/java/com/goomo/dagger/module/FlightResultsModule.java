package com.goomo.dagger.module;

import com.goomo.flight.searchresults.FlightResultsFragment;
import com.goomo.flight.searchresults.FlightResultsPresenter;
import com.goomo.flight.searchresults.FlightResultsView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
@Module
public class FlightResultsModule {
    private final FlightResultsFragment mFragment;
    private final FlightResultsView mView;

    public FlightResultsModule(FlightResultsFragment fragment, FlightResultsView view) {
        mFragment = fragment;
        mView = view;
    }

    @Provides
    @ActivityScope
    FlightResultsFragment provideFragment() {
        return mFragment;
    }

    @Provides
    @ActivityScope
    FlightResultsView provideView() {
        return mView;
    }

    @Provides
    @ActivityScope
    FlightResultsPresenter providePresenter(FlightResultsFragment flightResultsFragment, FlightResultsView view) {
        return new FlightResultsPresenter(view, flightResultsFragment.getContext());
    }
}
