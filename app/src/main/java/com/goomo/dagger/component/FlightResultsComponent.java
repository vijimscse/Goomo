package com.goomo.dagger.component;

import com.goomo.dagger.module.ActivityScope;
import com.goomo.dagger.module.FlightListModule;
import com.goomo.flight.flightlist.FlightListFragment;

import dagger.Subcomponent;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
@ActivityScope
@Subcomponent
        (
                modules = FlightListModule.class
        )
public interface FlightResultsComponent {

    FlightListFragment inject(FlightListFragment flightListFragment);
}
