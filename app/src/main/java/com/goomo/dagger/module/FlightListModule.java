package com.goomo.dagger.module;

import com.goomo.flight.flightlist.FlightListFragment;
import com.goomo.flight.flightlist.FlightListPresenter;
import com.goomo.flight.flightlist.FlightListView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
@Module
public class FlightListModule {
    private final FlightListFragment mFragment;
    private final FlightListView mView;

    public FlightListModule(FlightListFragment fragment, FlightListView view) {
        mFragment = fragment;
        mView = view;
    }

    @Provides
    @ActivityScope
    FlightListFragment provideFragment() {
        return mFragment;
    }

    @Provides
    @ActivityScope
    FlightListView provideView() {
        return mView;
    }

    @Provides
    @ActivityScope
    FlightListPresenter providePresenter(FlightListFragment flightListFragment, FlightListView view) {
        return new FlightListPresenter(view, flightListFragment.getContext());
    }
}
