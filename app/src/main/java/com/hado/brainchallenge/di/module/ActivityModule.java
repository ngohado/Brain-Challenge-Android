package com.hado.brainchallenge.di.module;

import android.app.Activity;
import android.content.Context;

import com.hado.brainchallenge.di.ActivityContext;
import com.hado.brainchallenge.ui.base.BasePresenter;
import com.hado.brainchallenge.ui.login.LoginPresenter;
import com.hado.brainchallenge.ui.login.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hado on 5/23/17.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    public Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    public BasePresenter<LoginView> provideLoginPresenter(LoginPresenter presenter) {
        return presenter;
    }

}
