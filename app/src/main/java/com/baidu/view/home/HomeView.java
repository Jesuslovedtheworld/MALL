package com.baidu.view.home;

import com.baidu.base.BaseMvpView;
import com.baidu.bean.HomeBannerBean;
import com.baidu.bean.HomeBrandBean;

public interface HomeView extends BaseMvpView {
    void onSuccess(HomeBannerBean bean);

    void onFail(String msg);

    void onBrandSuccess(HomeBrandBean bean);
}
