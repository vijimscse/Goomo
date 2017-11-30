package com.goomo.base;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */
public interface BaseView {
    void hideLoading();

    void showLoading();

    void showError();

    void showConnectionErrorMessage();
}