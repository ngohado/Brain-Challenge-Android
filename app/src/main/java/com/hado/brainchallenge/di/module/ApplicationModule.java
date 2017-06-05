package com.hado.brainchallenge.di.module;

import android.app.Application;
import android.content.Context;

import com.hado.brainchallenge.MyApplication;
import com.hado.brainchallenge.constant.AppConstant;
import com.hado.brainchallenge.di.ApplicationContext;
import com.hado.brainchallenge.di.BaseUrl;
import com.hado.brainchallenge.network.ApiClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hado on 5/23/17.
 */

@Module
public class ApplicationModule {

    private MyApplication mApplication;

    public ApplicationModule(MyApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    public Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @BaseUrl
    public String provideBaseUrl() {
        return AppConstant.BASE_URL;
    }

    @Provides
    public ApiClient provideApiClient() {
        return mApplication.getApiClient();
    }

    @Provides
    public Application provideApplication() {
        return mApplication;
    }


}
