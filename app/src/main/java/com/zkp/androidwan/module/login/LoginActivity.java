package com.zkp.androidwan.module.login;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.zkp.androidwan.R;
import com.zkp.androidwan.app.App;
import com.zkp.androidwan.base.activity.BaseActivity;
import com.zkp.androidwan.bean.LoginBean;
import com.zkp.androidwan.module.login.register.RegisterActivity;
import com.zkp.androidwan.utils.SPUtils;

import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.login
 * @time: 2019/5/5 14:04
 * @description:
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginActivityContract.View {

    private static final int REGISTER = 0x0001;

    @BindView(R.id.etUserName)
    TextInputLayout mEtUserName;

    @BindView(R.id.etPassword)
    TextInputLayout mEtPassword;

    @BindView(R.id.btnLogin)
    Button mBtnLogin;

    @BindView(R.id.tvRegister)
    TextView mTvRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        App.getApplication().addActivity(this);

        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void initEventAndData() {
        mBtnLogin.setOnClickListener(v -> {
            if (TextUtils.isEmpty(Objects.requireNonNull(mEtUserName.getEditText()).getText().toString())) {
                SmartToast.show("用户名不能为空");
                return;
            }

            if (TextUtils.isEmpty(Objects.requireNonNull(mEtPassword.getEditText()).getText().toString())) {
                SmartToast.show("密码不能为空");
                return;
            }

            mPresenter.login(mEtUserName.getEditText().getText().toString(), mEtPassword.getEditText().getText().toString());

        });

        mTvRegister.setOnClickListener(v -> {
            Objects.requireNonNull(mEtUserName.getEditText()).setText("");
            Objects.requireNonNull(mEtPassword.getEditText()).setText("");
            startActivityForResult(new Intent(LoginActivity.this, RegisterActivity.class), REGISTER);
        });
    }

    @Override
    public void loginSuccess(LoginBean data) {
        SPUtils.putBoolean(App.getContext(), "loginStatus", true);
        mPresenter.setUserAccount(data.getData().getUsername());
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void loginError(String errMsg) {
        SmartToast.show(errMsg);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REGISTER:
                    assert data != null;
                    Objects.requireNonNull(mEtUserName.getEditText()).setText(data.getStringExtra("userName"));
                    break;
                default:
                    break;
            }
        }
    }
}
