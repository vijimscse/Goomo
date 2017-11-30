package com.goomo.flight.searchresults;

import com.goomo.base.BaseView;
import com.goomo.io.dto.response.FlightResults;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */

public interface FlightResultsView extends BaseView {
    void setResponse(FlightResults response);
}
