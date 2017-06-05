package com.hado.brainchallenge.ui.login;

import android.util.Log;

import com.hado.brainchallenge.network.ApiClient;
import com.hado.brainchallenge.ui.base.BasePresenter;
import com.hado.brainchallenge.utils.StringUtil;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hado on 5/23/17.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    @Inject
    public LoginPresenter(ApiClient apiClient) {
        super(apiClient);
    }

    public void login(String username, String password) {
        if (username == null || username.isEmpty()) {
            getView().shakeUsername();
        } else if (password == null || password.isEmpty()) {
            getView().shakePassword();
        } else {
            final String hashedPassword = StringUtil.md5(password.trim());
            Log.d("Password", password.trim());
            Log.d("PasswordHashed", hashedPassword);

            apiClient.login(username, hashedPassword)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doFinally(() -> getView().hideLoading())
                    .subscribe(response -> {

                    }, throwable -> Log.d(getClass().getName(), throwable.getMessage()));
        }
    }
}
