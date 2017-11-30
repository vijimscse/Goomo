package com.goomo;

import android.app.Application;

import com.goomo.dagger.component.AppComponent;
import com.goomo.dagger.component.DaggerAppComponent;
import com.goomo.dagger.module.AppModule;

/**
 * Created by VijayaLakshmi.IN on 29-11-2017.
 */

public class GoomoApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent()
    {
        return mAppComponent;
    }
}
