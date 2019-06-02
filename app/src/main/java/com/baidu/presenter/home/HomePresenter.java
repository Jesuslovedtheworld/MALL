package com.baidu.presenter.home;

import com.baidu.base.BasePresenter;
import com.baidu.bean.HomeBannerBean;
import com.baidu.bean.HomeBrandBean;
import com.baidu.model.home.HomeModel;
import com.baidu.net.ResultCallBack;
import com.baidu.view.home.HomeView;


public class HomePresenter extends BasePresenter<HomeView> implements ResultCallBack<HomeBannerBean> {

    private HomeModel mHomeModel;

    @Override
    protected void initModel() {
        mHomeModel = new HomeModel();
        mModels.add(mHomeModel);
    }

    public void getHomeBanner() {
        if (mHomeModel != null){
            mHomeModel.getHomeBanner(this);
        }
    }

    @Override
    public void onSuccess(HomeBannerBean bean) {
            if (bean != null){
                if (mMvpView != null){
                    mMvpView.onSuccess(bean);
                }
            }
    }

    @Override
    public void onFail(String msg) {
        if (mMvpView != null){
            mMvpView.onFail(msg);
        }
    }

    public void getBrand() {
        mHomeModel.getBrand(new ResultCallBack<HomeBrandBean>() {
            @Override
            public void onSuccess(HomeBrandBean bean) {
                if (bean != null){
                    if (mMvpView != null){
                        mMvpView.onBrandSuccess(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.onFail(msg);
                }
            }
        });
    }
}
