package com.goomo.flight.search;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.goomo.GoomoApplication;
import com.goomo.R;
import com.goomo.base.BaseFragment;
import com.goomo.dagger.module.SearchFlightsModule;
import com.goomo.io.dto.request.Location;
import com.goomo.io.dto.request.SearchRequest;
import com.goomo.io.dto.response.SearchTrackId;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by VijayaLakshmi.IN on 25-11-2017.
 */

public class SearchFlightFragment extends BaseFragment implements SearchFlightsView {

    private static final String TAG = SearchFlightFragment.class.getSimpleName();
    private static final String[] mAirportCodes = {"BOM", "DEL", "MAA", "BLR", "GOI", "CCU", "PNQ", "JAI", "IXC", "HYD"};
    private static final String[] mClassTypes = {"ECONOMY", "PREMIUM_ECONOMY", "BUSINESS", "FIRST_CLASS"};
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @BindView(R.id.source)
    AutoCompleteTextView mSource;

    @BindView(R.id.destination)
    AutoCompleteTextView mDestination;

    @BindView(R.id.departure_date)
    EditText mDepartureDate;

    @BindView(R.id.traveller_class_input_value)
    Spinner mClassType;

    @BindView(R.id.reverse_direction)
    ImageButton mChangeDirection;

    @Inject
    SearchFlightsPresenter mPresenter;

    @Inject
    DatePickerDialog mDatePickerDialog;

    private String mSelectedSource;
    private String mSelectedDestination;
    private ISearchFlightFragmentListener mSearchFlightFragmentListener;

    public interface ISearchFlightFragmentListener {
        void onSearchTrackIdReceived(String searchTrackId);
    }

    public static SearchFlightFragment newInstance() {
        return new SearchFlightFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (! (context instanceof ISearchFlightFragmentListener)) {
            throw new IllegalStateException(((FragmentActivity)context).getClass().getSimpleName() +  "must implement" + ISearchFlightFragmentListener.class.getSimpleName());
        }
        mSearchFlightFragmentListener = (ISearchFlightFragmentListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setLayout(inflater, R.layout.fragment_search_flights);

        ((GoomoApplication) getActivity().getApplicationContext()).getAppComponent().plus(
                new SearchFlightsModule(this, this)).inject(this);

        return mContentContainer;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initialiseAutoCompleteViews(mSource);
        initialiseAutoCompleteViews(mDestination);
        addTextListeners();
        mChangeDirection.setEnabled(false);
    }

    private void addTextListeners() {
        mSource.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mSelectedSource = mSource.getText().toString();
                if (!TextUtils.isEmpty(mSelectedDestination)) {
                    if (mSelectedSource.equalsIgnoreCase(mSelectedDestination)) {
                        mSource.setError(getString(R.string.source_and_destination_same_error));
                    } else {
                        mChangeDirection.setEnabled(true);
                    }
                }
            }
        });
        mDestination.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mSelectedDestination = mDestination.getText().toString();
                if (!TextUtils.isEmpty(mSelectedSource)) {
                    if (mSelectedSource.equalsIgnoreCase(mSelectedDestination)) {
                        mDestination.setError(getString(R.string.source_and_destination_same_error));
                    } else {
                        mChangeDirection.setEnabled(true);
                    }
                }
            }
        });
        mSource.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mSelectedSource = null;
                mSource.setError(null);
                mChangeDirection.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mDestination.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mSelectedDestination = null;
                mDestination.setError(null);
                mChangeDirection.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initialiseAutoCompleteViews(AutoCompleteTextView autoCompleteTextView) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.select_dialog_item, mAirportCodes);
        autoCompleteTextView.setThreshold(1);//will start working from first character
        autoCompleteTextView.setAdapter(adapter);
    }

    @Override
    public void updateDepartureDateView(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        mDepartureDate.setText(sdf.format(time));
    }

    @OnClick(R.id.reverse_direction)
    public void onReverseDirection() {
        String tempSelectedSource = mSelectedSource;
        String tempSelectedDestination = mSelectedDestination;
        mSource.setText(tempSelectedDestination);
        mDestination.setText(tempSelectedSource);

        mSelectedSource = mSource.getText().toString();
        mSelectedDestination = mDestination.getText().toString();
        mChangeDirection.setEnabled(true);
    }

    @OnClick(R.id.departure_date)
    public void onDepartureDateClick() {
        mDatePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        mDatePickerDialog.show();
    }

    @OnClick(R.id.search_flights)
    public void onSearchFlights() {
        boolean valid = false;
        if (TextUtils.isEmpty(mSelectedSource)) {
            mSource.setError(getString(R.string.select_source_from_suggestions));
        } else if (TextUtils.isEmpty(mSelectedDestination)) {
            mDestination.setError(getString(R.string.select_dest_from_suggestions));
        } else if (!TextUtils.isEmpty(mSelectedDestination) &&
                mSelectedSource.equalsIgnoreCase(mSelectedDestination)) {
            mSource.setError(getString(R.string.source_and_destination_same_error));
        } else if (!TextUtils.isEmpty(mSelectedSource) &&
                mSelectedSource.equalsIgnoreCase(mSelectedDestination)) {
            mDestination.setError(getString(R.string.source_and_destination_same_error));
        } else if (TextUtils.isEmpty(mDepartureDate.getText().toString())) {
            mDepartureDate.setError(getString(R.string.select_departure_date));
        } else {
            valid = true;
        }

        if (valid) {
            Location origin = new Location(mSelectedSource);
            Location destination = new Location(mSelectedDestination);
            int adultCount = 1;
            int childCount = 0;
            int infantCount = 0;

            SearchRequest searchRequest = new SearchRequest(origin, destination,
                    mDepartureDate.getText().toString(), mClassTypes[mClassType.getSelectedItemPosition()],
                    true, adultCount, childCount, infantCount);
            mPresenter.initiateSearch(searchRequest);
        }
    }

    @Override
    public void setResponse(SearchTrackId response) {
        if (response.getMeta() != null) {
            String searchTrackId = response.getMeta().getSearchTrackId();
            if (!TextUtils.isEmpty(searchTrackId)) {
                mSearchFlightFragmentListener.onSearchTrackIdReceived(searchTrackId);
            }
        }
    }
}
