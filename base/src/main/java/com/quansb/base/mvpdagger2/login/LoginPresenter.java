package com.quansb.base.mvpdagger2.login;

import android.util.Log;

import com.quansb.base.mvpdagger2.BasePresenter;

import javax.inject.Inject;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
public class LoginPresenter extends BasePresenter<LoginModel, LoginActivity> implements ISettingContract.VP {

    @Inject
    public LoginPresenter(){

    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }

    @Override
    public void requestLogin(String name, String pwd) {
        Log.i("mvp", "P层处理请求登录...");
        mModel.requestLogin(name, pwd);
    }

    @Override
    public void requestResult(boolean loginResult) {
        Log.i("mvp", "P层收到结果...");
        Log.i("mvp", "P层通知UI...");
        mView.requestResult(loginResult);
    }
}
