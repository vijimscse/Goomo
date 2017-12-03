package com.goomo.flight;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.goomo.R;
import com.goomo.base.BaseActivity;
import com.goomo.flight.flightlist.FlightListFragment;
import com.goomo.flight.search.SearchFlightFragment;
import com.goomo.utils.DateUtils;

import butterknife.BindView;

/**
 * Class which is used for searching flights and on selection lead to book a flight.
 */
public class SearchActivity extends BaseActivity implements SearchFlightFragment.ISearchFlightFragmentListener {

    private static final String TAG = SearchActivity.class.getSimpleName();

    @BindView(R.id.flight_custom_title_container)
    View mCustomTitleContainer;

    @BindView(R.id.travel_origin_destination)
    TextView mTravelOriginDestinationTextView;

    @BindView(R.id.date)
    TextView mTravelDateView;

    @BindView(R.id.person_count)
    TextView mTravelPersonCountView;

    private String mTravelOriginDestination;
    private String mTravelDate;
    private int mTravelPersonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_flights);
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container_body);
                if (fragment != null) {
                    if (fragment instanceof SearchFlightFragment) {
                        setActivityTitle(R.string.search_flights);
                        hideBackButton();
                        mCustomTitleContainer.setVisibility(View.GONE);
                        mTravelOriginDestination = null;
                        mTravelDate = null;
                        mTravelPersonCount = 0;
                    } else {
                        hideActivityTitle();
                        showBackButton();
                        mCustomTitleContainer.setVisibility(View.VISIBLE);
                        mTravelOriginDestinationTextView.setText(mTravelOriginDestination);
                        mTravelDateView.setText(DateUtils.getHeaderDateFormat(mTravelDate));
                        mTravelPersonCountView.setText(String.valueOf(mTravelPersonCount));
                    }
                }
            }
        });

        addSearchFlightFragment();
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
    public void onSearchTrackIdReceived(String searchTrackId, String origindestination, int personCount, String date) {
        mTravelOriginDestination = origindestination;
        mTravelDate = date;
        mTravelPersonCount = personCount;
        addFlightResultsFragment(searchTrackId);
    }

    /**
     * Adds flights results fragment to back stack for a given search track id
     *
     * @param searchTrackId
     */
    private void addFlightResultsFragment(String searchTrackId) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_body, FlightListFragment.newInstance(searchTrackId));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
