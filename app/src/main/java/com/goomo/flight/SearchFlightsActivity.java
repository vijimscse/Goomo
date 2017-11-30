package com.goomo.flight;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.goomo.R;
import com.goomo.base.BaseActivity;
import com.goomo.flight.search.SearchFlightFragment;
import com.goomo.flight.searchresults.FlightResultsFragment;

/**
 * Class which is used for searching flights and on selection lead to book a flight.
 */
public class SearchFlightsActivity extends BaseActivity implements SearchFlightFragment.ISearchFlightFragmentListener {

    private static final String TAG = SearchFlightsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_flights);

        setActivityTitle(R.string.search_flights);

        addSearchFlightFragment();

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container_body);

                if (fragment != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(fragment instanceof FlightResultsFragment);
                }
            }
        });
    }

    /**
     * Adds the search flight fragment to back stack.
     */
    private void addSearchFlightFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container_body, SearchFlightFragment.newInstance());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onSearchTrackIdReceived(String searchTrackId) {
        addFlightResultsFragment(searchTrackId);
    }

    /**
     * Adds flights results fragment to back stack for a given search track id
     *
     * @param searchTrackId
     */
    private void addFlightResultsFragment(String searchTrackId) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_body, FlightResultsFragment.newInstance(searchTrackId));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
