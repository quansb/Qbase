package com.quansb.base.mvpdagger2;

/**
 * @author quanshibao
 * @description
 * @date 2020/8/5
 */
public abstract class BasePresenter<M extends BaseModel,V extends BaseActivity>  {

    public M mModel;

    public V mView;


    public BasePresenter(){
        this.mModel=getModel();
    }

    public void bindView(V mView){
        this.mView=mView;
    }

    public void unBindView(){
        this.mView=null;
    }

    public abstract M getModel();

}
