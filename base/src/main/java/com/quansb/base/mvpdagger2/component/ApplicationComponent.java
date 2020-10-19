package com.quansb.base.mvpdagger2.component;
import android.app.Application;

import dagger.Component;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/18
 */
@Component
public interface ApplicationComponent {

    void inject(Application application);

}
