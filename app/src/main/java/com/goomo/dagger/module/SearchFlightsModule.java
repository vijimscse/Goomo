package com.goomo.dagger.module;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.widget.DatePicker;

import com.goomo.R;
import com.goomo.flight.search.SearchFlightFragment;
import com.goomo.flight.search.SearchFlightsPresenter;
import com.goomo.flight.search.SearchFlightsView;

import java.util.Calendar;

import dagger.Module;
import dagger.Provides;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
@Module
public class SearchFlightsModule {
    private final SearchFlightFragment mFragment;
    private final SearchFlightsView mView;
    private DatePickerDialog mDatePickerDialog;
    private Calendar mCalendar;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    public SearchFlightsModule(SearchFlightFragment fragment, SearchFlightsView view) {
        mFragment = fragment;
        mView = view;
        mCalendar = Calendar.getInstance();
    }

    @Provides
    @ActivityScope
    SearchFlightFragment provideFragment() {
        return mFragment;
    }

    @Provides
    @ActivityScope
    SearchFlightsView provideView() {
        return mView;
    }

    @Provides
    @ActivityScope
    DatePickerDialog provideDatePicker() {
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, month);
                mCalendar.set(Calendar.DAY_OF_MONTH, day);

                mView.updateDepartureDateView(mCalendar.getTime());
            }
        };

        mDatePickerDialog = new DatePickerDialog(mFragment.getContext(), mDateSetListener, mCalendar
                .get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mDatePickerDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface arg0) {
                    mDatePickerDialog.getButton(mDatePickerDialog.BUTTON_NEGATIVE).setTextColor(
                            ContextCompat.getColor(mFragment.getContext(), R.color.custom_alert_dialog_button_text));
                    mDatePickerDialog.getButton(mDatePickerDialog.BUTTON_POSITIVE).setTextColor(
                            ContextCompat.getColor(mFragment.getContext(), R.color.custom_alert_dialog_button_text));
                }
            });
        }

        return mDatePickerDialog;
    }

    @Provides
    @ActivityScope
    SearchFlightsPresenter providePresenter(SearchFlightFragment searchFlightFragment, SearchFlightsView view) {
        return new SearchFlightsPresenter(view, searchFlightFragment.getContext());
    }
}
