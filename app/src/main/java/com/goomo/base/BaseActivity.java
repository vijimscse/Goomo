package com.goomo.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goomo.R;
import com.goomo.io.IOManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by VijayaLakshmi.IN on 24-11-2017.
 */

public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.top_toolbar)
    Toolbar mTopToolbar;

    @BindView(R.id.sidebar_drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    @BindView(R.id.activity_title)
    TextView mActivityTitle;

    @BindView(R.id.back_btn)
    View mBackBtn;

    private ViewGroup mViewContainer;

    @Override
    public void setContentView(@LayoutRes int layoutId) {
        super.setContentView(R.layout.activity_base);
        mViewContainer = (ViewGroup) findViewById(R.id.layout_stub);
        mViewContainer.addView(getLayoutInflater().inflate(layoutId, null));
        ButterKnife.bind(this);

        setSupportActionBar(mTopToolbar);
    }

    protected void setActivityTitle(@StringRes int resourceId) {
        mActivityTitle.setVisibility(View.VISIBLE);
        mActivityTitle.setText(resourceId);
    }

    protected void hideActivityTitle() {
        mActivityTitle.setVisibility(View.GONE);
    }

    protected void hideBackButton() {
        mBackBtn.setVisibility(View.GONE);
    }

    protected void showBackButton() {
        mBackBtn.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.back_btn)
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            IOManager.cancelAllQueuedCalls();
            finish();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }
}
