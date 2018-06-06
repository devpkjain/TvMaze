package com.android.ashwiask.tvmaze;

import android.app.Activity;
import android.app.Application;

import com.android.ashwiask.tvmaze.di.AppComponent;
import com.android.ashwiask.tvmaze.di.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


/**
 * @author Ashwini Kumar.
 */
public class TvMazeApplication extends Application
        implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
