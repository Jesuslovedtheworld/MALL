package com.baidu.presenter.special;

import com.baidu.base.BasePresenter;
import com.baidu.bean.SpecialBean;
import com.baidu.model.home.HomeModel;
import com.baidu.net.ResultCallBack;
import com.baidu.view.home.HomeView;
import com.baidu.view.special.SpecialView;

public class SpecialPresenter extends BasePresenter<SpecialView> implements ResultCallBack<SpecialBean> {
    private HomeModel mHomeModel;

    @Override
    protected void initModel() {
        mHomeModel = new HomeModel();
        mModels.add(mHomeModel);
    }

    public void getSpecial() {
            mHomeModel.getSpecial(this);
    }

    @Override
    public void onSuccess(SpecialBean bean) {
        if (bean != null){
            if (mMvpView != null){
                mMvpView.onSuccesss(bean);
            }
        }
    }

    @Override
    public void onFail(String msg) {
        if (mMvpView != null){
            mMvpView.onFail(msg);
        }
    }
}
