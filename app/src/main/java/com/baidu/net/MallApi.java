package com.baidu.net;

import com.baidu.bean.HomeBannerBean;
import com.baidu.bean.HomeBrandBean;
import com.baidu.bean.SpecialBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/*
* *  author gme
*    time
*/
public interface MallApi {

    String homeUrl  = "http://47.92.105.146:8002/";

    @GET("advertising_list")
    Observable<HomeBannerBean> getHomeBanner();

    @GET("brand")
    Observable<HomeBrandBean> getHomeBrand();

    @GET("youxuan")
    Observable<SpecialBean> getSpecial();
}
