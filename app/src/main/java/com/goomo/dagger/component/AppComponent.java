package com.goomo.dagger.component;

import com.goomo.dagger.module.AppModule;
import com.goomo.dagger.module.FlightListModule;
import com.goomo.dagger.module.SearchFlightsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {

    SearchFlightsComponent plus(SearchFlightsModule module);

    FlightResultsComponent plus(FlightListModule module);
}
