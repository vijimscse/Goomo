package com.goomo.dagger.component;

import com.goomo.dagger.module.ActivityScope;
import com.goomo.dagger.module.SearchFlightsModule;
import com.goomo.flight.search.SearchFlightFragment;

import dagger.Subcomponent;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
@ActivityScope
@Subcomponent
        (
                modules = SearchFlightsModule.class
        )
public interface SearchFlightsComponent {

    SearchFlightFragment inject(SearchFlightFragment searchFlightFragment);
}
