package com.goomo.flight.flightlist;

import android.content.Context;
import android.util.Log;

import com.goomo.io.IOManager;
import com.goomo.io.dto.response.FlightResults;
import com.goomo.utils.NetworkUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
public class FlightListPresenter {

    private static final String TAG = FlightListPresenter.class.getSimpleName();
    private FlightListView mView;
    private Context mContext;

    public FlightListPresenter(FlightListView view, Context context) {
        mView = view;
        mContext = context;
    }

    public void fetchSearchResults(String searchTrackId) {
        mView.showLoading();

        if (NetworkUtility.isInternetOn(mContext)) {
            IOManager.fetchSearchResults(searchTrackId,
                    new Callback<FlightResults>() {
                        @Override
                        public void onResponse(Call<FlightResults> call, Response<FlightResults> response) {
                            mView.hideLoading();
                            if (response != null && response.isSuccessful() && response.body() != null) {
                                Log.d(TAG, "" + response.body());
                                mView.setResponse(response.body());
                            } else {
                                mView.showError();
                            }
                        }

                        @Override
                        public void onFailure(Call<FlightResults> call, Throwable t) {
                            mView.hideLoading();
                            mView.showError();
                            Log.d(TAG, "Error");
                        }
                    });
        } else {
            mView.showConnectionErrorMessage();
        }
    }
}
