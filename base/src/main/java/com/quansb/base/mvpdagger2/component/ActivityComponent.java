package com.quansb.base.mvpdagger2.component;

import com.quansb.base.mvpdagger2.module.PresenterModule;
import com.quansb.base.mvpdagger2.login.LoginActivity;

import dagger.Component;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
@Component(
        dependencies = ApplicationComponent.class,
        modules = PresenterModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

}
