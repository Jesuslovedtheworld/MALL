package com.baidu.model.home;

import com.baidu.base.BaseModel;
import com.baidu.bean.HomeBannerBean;
import com.baidu.bean.HomeBrandBean;
import com.baidu.bean.SpecialBean;
import com.baidu.net.BaseObserver;
import com.baidu.net.HttpUtils;
import com.baidu.net.MallApi;
import com.baidu.net.ResultCallBack;
import com.baidu.net.RxUtils;
import com.baidu.utils.Logger;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class HomeModel extends BaseModel {
    private static final String TAG = "HomeModel";
    public void getHomeBanner(final ResultCallBack<HomeBannerBean> resultCallBack) {
        MallApi apiserver = HttpUtils.getInstance().getApiserver(MallApi.homeUrl, MallApi.class);
        Observable<HomeBannerBean> homeBanner = apiserver.getHomeBanner();
        homeBanner.compose(RxUtils.<HomeBannerBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HomeBannerBean>() {
                    @Override
                    public void onNext(HomeBannerBean homeBannerBean) {
                            if (homeBannerBean != null){
                                Logger.logD(TAG,"数据"+homeBannerBean.toString());
                                resultCallBack.onSuccess(homeBannerBean);
                            }
                    }

                    @Override
                    public void error(String msg) {
                        Logger.logD(TAG,"错误的信息"+msg);
                            resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                            addDisposable(d);
                    }
                });
    }

    //获取商城列表
    public void getBrand(final ResultCallBack<HomeBrandBean> resultCallBack) {
        MallApi apiserver = HttpUtils.getInstance().getApiserver(MallApi.homeUrl, MallApi.class);
        Observable<HomeBrandBean> homeBrand = apiserver.getHomeBrand();
        homeBrand.compose(RxUtils.<HomeBrandBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HomeBrandBean>() {
                    @Override
                    public void onNext(HomeBrandBean HomeBrandBean) {
                        if (HomeBrandBean != null){
                            Logger.logD(TAG,"数据"+HomeBrandBean.toString());
                            resultCallBack.onSuccess(HomeBrandBean);
                        }
                    }

                    @Override
                    public void error(String msg) {
                        Logger.logD(TAG,"错误的信息"+msg);
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });

    }


    //获取专题列表
    public void getSpecial(final ResultCallBack<SpecialBean> resultCallBack) {
        MallApi apiserver = HttpUtils.getInstance().getApiserver(MallApi.homeUrl, MallApi.class);
        Observable<SpecialBean> special = apiserver.getSpecial();
        special.compose(RxUtils.<SpecialBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SpecialBean>() {
                    @Override
                    public void onNext(SpecialBean specialBean) {
                        if (specialBean != null){
                            Logger.logD(TAG,"数据"+specialBean.toString());
                            resultCallBack.onSuccess(specialBean);
                        }
                    }

                    @Override
                    public void error(String msg) {
                        Logger.logD(TAG,"错误的信息"+msg);
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }
}
