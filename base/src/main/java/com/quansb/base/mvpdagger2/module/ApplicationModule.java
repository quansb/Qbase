package com.quansb.base.mvpdagger2.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/18
 */
@Module
public class ApplicationModule {

    @Provides
    public Application provideApplication() {
        return new Application();
    }


}
