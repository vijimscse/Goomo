package com.goomo.flight.search;

import android.content.Context;
import android.util.Log;

import com.goomo.io.IOManager;
import com.goomo.io.dto.request.SearchRequest;
import com.goomo.io.dto.response.SearchTrackId;
import com.goomo.utils.NetworkUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
public class SearchFlightsPresenter {
    private static final String TAG = SearchFlightsPresenter.class.getSimpleName();
    private SearchFlightsView mView;
    private Context mContext;

    public SearchFlightsPresenter(SearchFlightsView view, Context context) {
        mView = view;
        mContext = context;
    }

    public void initiateSearch(SearchRequest searchRequest) {
        mView.showLoading();

        if (NetworkUtility.isInternetOn(mContext)) {
            IOManager.initiateSearch(searchRequest,
                    new Callback<SearchTrackId>() {
                        @Override
                        public void onResponse(Call<SearchTrackId> call, Response<SearchTrackId> response) {
                            mView.hideLoading();
                            if (response.isSuccessful() && response.body() != null) {
                                Log.d(TAG, "" + response.body());
                                mView.setResponse(response.body());
                            } else {
                                mView.showError();
                            }
                        }

                        @Override
                        public void onFailure(Call<SearchTrackId> call, Throwable t) {
                            mView.hideLoading();
                            mView.showError();
                        }
                    });
        } else {
            mView.showConnectionErrorMessage();
        }
    }
}
