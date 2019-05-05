package com.zkp.gank.module.login.register;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.Button;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.zkp.gank.R;
import com.zkp.gank.base.activity.BaseActivity;
import com.zkp.gank.bean.LoginBean;

import java.util.Objects;

import butterknife.BindView;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.login.register
 * @time: 2019/5/5 15:34
 * @description:
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterActivityContract.View {

    @BindView(R.id.etUserName)
    TextInputLayout mEtUserName;

    @BindView(R.id.etPassword)
    TextInputLayout mEtPassword;

    @BindView(R.id.etRePassword)
    TextInputLayout mEtRePassword;

    @BindView(R.id.btnLogin)
    Button mBtnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        mPresenter = new RegisterPresenter();
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

            if (TextUtils.isEmpty(Objects.requireNonNull(mEtRePassword.getEditText()).getText().toString())) {
                SmartToast.show("请再次输入密码");
                return;
            }

            if (!mEtPassword.getEditText().getText().toString().equals(mEtRePassword.getEditText().getText().toString())) {
                SmartToast.show("两次输入的密码不一致");
                return;
            }

            mPresenter.register(mEtUserName.getEditText().getText().toString(),
                    mEtPassword.getEditText().getText().toString(),
                    mEtRePassword.getEditText().getText().toString());

        });

    }

    @Override
    public void registerSuccess(LoginBean data) {
        Intent intent = new Intent();
        intent.putExtra("userName", data.getData().getUsername());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void registerError(String errMsg) {
        SmartToast.show(errMsg);
    }
}
