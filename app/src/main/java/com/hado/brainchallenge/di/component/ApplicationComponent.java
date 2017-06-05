package com.hado.brainchallenge.di.component;

import android.app.Application;
import android.content.Context;

import com.hado.brainchallenge.MyApplication;
import com.hado.brainchallenge.di.ApplicationContext;
import com.hado.brainchallenge.di.module.ApplicationModule;
import com.hado.brainchallenge.network.ApiClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hado on 5/23/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(MyApplication application);

  @ApplicationContext
  Context getApplicationContext();

  Application getApplication();

  ApiClient getApiClient();
}
