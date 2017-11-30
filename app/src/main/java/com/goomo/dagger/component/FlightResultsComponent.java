package com.goomo.dagger.component;

import com.goomo.dagger.module.ActivityScope;
import com.goomo.dagger.module.FlightResultsModule;
import com.goomo.flight.searchresults.FlightResultsFragment;

import dagger.Subcomponent;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
@ActivityScope
@Subcomponent
        (
                modules = FlightResultsModule.class
        )
public interface FlightResultsComponent {

    FlightResultsFragment inject(FlightResultsFragment flightResultsFragment);
}
