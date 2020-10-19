package com.quansb.base.mvpdagger2;

import android.app.Activity;
import android.os.Bundle;
import com.quansb.base.mvpdagger2.component.ActivityComponent;
import com.quansb.base.mvpdagger2.component.DaggerActivityComponent;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
public abstract class BaseActivity<P extends BasePresenter> extends Activity {


    public ActivityComponent mActivityComponent;

    @Inject
    public P mPresenter;

    public abstract int getLayoutId();

    public abstract void init();

    public abstract void destroy();

    public abstract void inject();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        mActivityComponent = DaggerActivityComponent.builder().build();
        inject();
        mPresenter.bindView(this);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
        mPresenter.unBindView();
    }
}
