package com.quansb.base.mvpdagger2.login;

import android.util.Log;

import com.quansb.base.mvpdagger2.BaseModel;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
public class LoginModel extends BaseModel<LoginPresenter> implements ISettingContract.M {

    public LoginModel(LoginPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public void requestLogin(String name, String pwd) {

        //.....

        //.....


        Log.i("mvp", "M层网络请求处理中...");



        Log.i("mvp", "M层网络请求返回结果...");
        mPresenter.requestResult(true);
    }
}
