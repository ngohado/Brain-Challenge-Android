package com.hado.brainchallenge.ui.login;

import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.hado.brainchallenge.R;
import com.hado.brainchallenge.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

  @Inject
  LoginPresenter presenter;

  @BindView(R.id.edt_username)
  EditText edtUsername;

  @BindView(R.id.edt_password)
  EditText edtPassword;

  @Override
  public void injecting() {
    getActivityComponent().inject(LoginActivity.this);
  }

  @Override
  public void initView() {
    edtPassword.setSingleLine();
    edtUsername.setSingleLine();

    presenter.onAttach(this);

    edtPassword.setOnEditorActionListener((v, actionId, event) -> {
      hideKeyboard();
      return true;
    });

    edtUsername.setOnEditorActionListener((v, actionId, event) -> {
      edtPassword.setImeOptions(EditorInfo.IME_ACTION_DONE);
      edtPassword.requestFocus();
      return true;
    });
  }

  @Override
  public void initData() {

  }

  @Override
  public int getLayoutID() {
    return R.layout.activity_login;
  }

  @Override
  protected void onDestroy() {
    presenter.onDetach();
    super.onDestroy();
  }

  @OnClick(R.id.btn_sign_in)
  public void loginClicked() {
    final String username = edtUsername.getText().toString();
    final String password = edtPassword.getText().toString();
    presenter.login(username, password);
  }


  @Override
  public void shakeUsername() {

  }

  @Override
  public void shakePassword() {

  }
}
