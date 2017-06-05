package com.hado.brainchallenge.di.module;

import android.app.Application;
import android.content.Context;

import com.hado.brainchallenge.MyApplication;
import com.hado.brainchallenge.constant.AppConstant;
import com.hado.brainchallenge.di.ApplicationContext;
import com.hado.brainchallenge.di.BaseUrl;
import com.hado.brainchallenge.network.ApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
  @Singleton
  @BaseUrl
  public String provideBaseUrl() {
    return AppConstant.BASE_URL;
  }

  @Provides
  @Singleton
  public ApiClient provideApiClient(@BaseUrl String baseUrl) {
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(ApiClient.class);
  }

  @Provides
  public Application provideApplication() {
    return mApplication;
  }

}
