package com.hado.brainchallenge.ui.base;

/**
 * Created by Hado on 5/22/17.
 */

public interface BaseView {
    void showLoading();

    void hideLoading();

    void showError(String message);

    void hideKeyboard();
}
