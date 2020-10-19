package com.quansb.base.mvp.login;

import com.quansb.base.mvp.BasePresenter;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
public class LoginPresenter extends BasePresenter<LoginModel, LoginActivity> implements ISettingContract.VP {

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }

    @Override
    public void requestLogin(String name, String pwd) {
        mModel.requestLogin(name, pwd);
    }

    @Override
    public void requestResult(boolean loginResult) {
        mView.requestResult(loginResult);
    }


}
