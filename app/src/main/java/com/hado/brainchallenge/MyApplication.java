package com.hado.brainchallenge;

import android.app.Application;

import com.hado.brainchallenge.di.component.ApplicationComponent;
import com.hado.brainchallenge.di.component.DaggerApplicationComponent;
import com.hado.brainchallenge.di.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by Hado on 5/22/17.
 */

public class MyApplication extends Application {

  private ApplicationComponent applicationComponent;

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


  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
