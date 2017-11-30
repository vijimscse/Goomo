package com.goomo.io;

import android.support.annotation.NonNull;

import com.goomo.io.dto.request.SearchRequest;
import com.goomo.io.dto.response.FlightResults;
import com.goomo.io.dto.response.SearchTrackId;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.goomo.io.APIConstants.BASE_URL;

/**
 * Created by Vijayalakshmi.IN on 11/24/2017.
 */

public class IOManager {

    private static OkHttpClient okHttpClient;

    private static Retrofit getRetrofit() {
        OkHttpClient client = getOkHttpClient();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        }

        return okHttpClient;
    }

    /**
     * Cancels all the queued API calls initiated using this Http client
     */
    public static void cancelAllQueuedCalls() {
        for (okhttp3.Call call : getOkHttpClient().dispatcher().queuedCalls()) {
            call.cancel();
        }
    }

    public static void initiateSearch(SearchRequest searchRequest,
                                      Callback<SearchTrackId> callback) {
        APIEndPoints apiEndPoints = getRetrofit().create(APIEndPoints.class);
        Call<SearchTrackId> call = apiEndPoints.initiateSearch(searchRequest);
        call.enqueue(callback);
    }

    public static void fetchSearchResults(String searchTrackId, Callback<FlightResults> callback) {
        APIEndPoints apiEndPoints = getRetrofit().create(APIEndPoints.class);
        Call<FlightResults> call = apiEndPoints.fetchSearchResults(searchTrackId);
        call.enqueue(callback);
    }
}
