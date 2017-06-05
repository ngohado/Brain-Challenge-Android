package com.hado.brainchallenge;

import android.app.Application;

import com.hado.brainchallenge.di.component.ApplicationComponent;
import com.hado.brainchallenge.di.component.DaggerApplicationComponent;
import com.hado.brainchallenge.di.module.ApplicationModule;
import com.hado.brainchallenge.network.ApiClient;
import com.hado.brainchallenge.network.RetrofitClient;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by Hado on 5/22/17.
 */

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Inject
    RetrofitClient retrofitClient;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApiClient getApiClient() {
        return retrofitClient.getApiClient();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
