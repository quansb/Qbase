package com.quansb.base.mvpdagger2.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.quansb.base.R;
import com.quansb.base.mvpdagger2.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements ISettingContract.VP {

   // @BindView(R.id.tv_login)
    TextView tvLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("mvp", "V层点击请求登录...");
                requestLogin("qsb", "123456");
            }
        });
    }

    @Override
    public void destroy() {

    }

    @Override
    public void inject() {
        mActivityComponent.inject(this);
    }

    @Override
    public void requestLogin(String name, String pwd) {
        mPresenter.requestLogin(name, pwd);
    }

    @Override
    public void requestResult(boolean loginResult) {
        Log.i("mvp", "V层收到结果...");
        if (loginResult) {
            Log.i("mvp", "展示UI...");
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
        }
    }

}
