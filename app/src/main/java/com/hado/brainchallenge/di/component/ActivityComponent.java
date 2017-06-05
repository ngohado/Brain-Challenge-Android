package com.hado.brainchallenge.di.component;

import com.hado.brainchallenge.di.PerActivity;
import com.hado.brainchallenge.di.module.ActivityModule;
import com.hado.brainchallenge.ui.login.LoginActivity;

import dagger.Component;

/**
 * Created by Hado on 5/23/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(LoginActivity loginActivity);

}
