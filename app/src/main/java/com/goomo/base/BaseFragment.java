package com.goomo.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goomo.R;
import com.goomo.utils.DialogUtility;

import butterknife.ButterKnife;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */

public abstract class BaseFragment extends DialogFragment implements BaseView {

    protected ViewGroup mContentContainer;
    private ProgressDialog mLoadingDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        mContentContainer = view.findViewById(R.id.fragment_view_container);

        return view;
    }

    protected void setLayout(LayoutInflater inflater, int layoutID) {
        if (inflater != null && layoutID != 0) {
            mContentContainer.addView(inflater.inflate(layoutID, null));
        }
        ButterKnife.bind(this, mContentContainer);
    }

    @Override
    public void showError() {
        DialogUtility.showToast(getActivity(), getString(R.string.generic_error));
    }

    @Override
    public void showConnectionErrorMessage() {
        DialogUtility.showToast(getActivity(), getString(R.string.network_error));
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void showLoading() {
        mLoadingDialog = new ProgressDialog(getActivity());
        mLoadingDialog.setCancelable(false);
        mLoadingDialog.show();
    }
}
