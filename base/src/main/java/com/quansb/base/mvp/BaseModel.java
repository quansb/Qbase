package com.quansb.base.mvp;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
public abstract class BaseModel<P extends BasePresenter> {

    public P mPresenter;

    public BaseModel(P mPresenter){
        this.mPresenter=mPresenter;
    }


}
