package com.goomo.flight.search;

import com.goomo.base.BaseView;
import com.goomo.io.dto.response.Meta;

import java.util.Date;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */

public interface SearchView extends BaseView {

    void updateDepartureDateView(Date time);
    void setResponse(Meta response);
}
