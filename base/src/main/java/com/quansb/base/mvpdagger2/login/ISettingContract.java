package com.quansb.base.mvpdagger2.login;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
public interface ISettingContract {

    public interface M{
        void requestLogin(String name, String pwd);
    }

    public interface VP{
        void requestLogin(String name, String pwd);
        void requestResult(boolean loginResult);
    }

}
