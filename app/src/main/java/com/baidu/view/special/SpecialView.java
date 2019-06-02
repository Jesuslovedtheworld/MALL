package com.baidu.view.special;

import com.baidu.base.BaseMvpView;
import com.baidu.bean.SpecialBean;

public interface SpecialView extends BaseMvpView {
    void onSuccesss(SpecialBean bean);

    void onFail(String msg);
}
