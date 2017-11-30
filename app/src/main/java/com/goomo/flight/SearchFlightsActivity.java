package com.goomo.flight;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.goomo.R;
import com.goomo.base.BaseActivity;
import com.goomo.flight.search.SearchFlightFragment;
import com.goomo.flight.searchresults.FlightResultsFragment;

public class SearchFlightsActivity extends BaseActivity implements SearchFlightFragment.ISearchFlightFragmentListener {

    private static final String TAG = SearchFlightsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        setActivityTitle(R.string.search_flights);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.container_body, SearchFlightFragment.newInstance());
        fragmentTransaction.commit();
    }

    @Override
    public void onSearchTrackIdReceived(String searchTrackId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null).add(R.id.container_body, FlightResultsFragment.newInstance(searchTrackId));
        fragmentTransaction.commit();
    }
}
