package com.quansb.base.mvp.login;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.quansb.base.R;
import com.quansb.base.mvp.BaseActivity;

import butterknife.BindView;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements ISettingContract.VP {

  //  @BindView(R.id.tv_login)
    TextView tvLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void init() {

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin("qsb", "123456");
            }
        });
    }

    @Override
    public void requestLogin(String name, String pwd) {
        mPresenter.requestLogin(name, pwd);
    }

    @Override
    public void requestResult(boolean loginResult) {
        if (loginResult) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void destroy() {

    }

}
