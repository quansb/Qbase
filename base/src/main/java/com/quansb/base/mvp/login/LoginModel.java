package com.quansb.base.mvp.login;

import com.quansb.base.mvp.BaseModel;

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

        //网络处理
        //...
        //返回结果
        mPresenter.requestResult(true);
    }
}
