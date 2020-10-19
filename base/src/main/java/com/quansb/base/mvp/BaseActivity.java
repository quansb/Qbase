package com.quansb.base.mvp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
public abstract class BaseActivity<P extends BasePresenter> extends Activity {

    public P mPresenter;

    public abstract int getLayoutId();

    public abstract P getPresenter();

    public abstract void init();

    public abstract void destroy();

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mPresenter = getPresenter();
        mPresenter.bindView(this);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
        mPresenter.unBindView();
        if(unbinder!=null){
            unbinder=null;
        }
    }
}
