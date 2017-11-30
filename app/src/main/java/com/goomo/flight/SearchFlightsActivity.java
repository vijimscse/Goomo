package com.goomo.flight;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

        setActivityTitle(R.string.search_flights);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_body, SearchFlightFragment.newInstance());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container_body);
                if (fragment instanceof FlightResultsFragment) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                } else {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                }
            }
        });
    }

    @Override
    public void onSearchTrackIdReceived(String searchTrackId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_body, FlightResultsFragment.newInstance(searchTrackId));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
