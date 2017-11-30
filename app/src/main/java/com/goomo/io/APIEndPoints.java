package com.goomo.io;

import com.goomo.io.dto.request.SearchRequest;
import com.goomo.io.dto.response.Meta;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Vijayalakshmi.IN on 11/24/2017.
 */

public interface APIEndPoints {

    @POST("flights/one_way/search")
    Call<Meta> initiateSearch(@Body SearchRequest searchRequest);

    @GET("flights/one_way/{search_track_id}")
    Call<String> fetchSearchResults(@Path("search_track_id") String searchTrackID);
}

