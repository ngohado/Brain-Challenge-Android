package com.hado.brainchallenge.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.hado.brainchallenge.MyApplication;
import com.hado.brainchallenge.di.component.ActivityComponent;
import com.hado.brainchallenge.di.component.DaggerActivityComponent;
import com.hado.brainchallenge.di.module.ActivityModule;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Hado on 5/22/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder mUnBinder;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MyApplication) getApplication()).getApplicationComponent())
                .build();
        injecting();
        mUnBinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    public abstract void injecting();

    public abstract void initView();

    public abstract void initData();

    public abstract int getLayoutID();

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        snackbar.show();
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
