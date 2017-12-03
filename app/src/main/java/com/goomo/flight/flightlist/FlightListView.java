package com.goomo.flight.flightlist;

import com.goomo.base.BaseView;
import com.goomo.io.dto.response.FlightResults;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */

public interface FlightListView extends BaseView {
    void setResponse(FlightResults response);
}
