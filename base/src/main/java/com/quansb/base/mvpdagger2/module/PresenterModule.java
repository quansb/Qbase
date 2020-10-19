package com.quansb.base.mvpdagger2.module;

import com.quansb.base.mvpdagger2.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */

@Module
public class PresenterModule {

    @Provides
    public LoginPresenter providerLoginPresenter() {
        return new LoginPresenter();
    }


}
