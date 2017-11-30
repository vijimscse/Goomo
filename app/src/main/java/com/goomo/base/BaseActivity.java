package com.goomo.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.goomo.R;
import com.goomo.io.IOManager;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    private ViewGroup mViewContainer;

    @Override
    public void setContentView(@LayoutRes int layoutId) {
        super.setContentView(R.layout.activity_base);
        mViewContainer = (ViewGroup) findViewById(R.id.layout_stub);
        mViewContainer.addView(getLayoutInflater().inflate(layoutId, null));
       /* BaseView inflated = mViewContainer.inflate();*/
        ButterKnife.bind(this);

        setSupportActionBar(mTopToolbar);
    }

    protected void setActivityTitle(@StringRes int resourceId) {
        getSupportActionBar().setTitle(resourceId);
    }

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
