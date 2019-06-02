package com.baidu.ui.home.fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.base.BaseFragment;
import com.baidu.bean.HomeBannerBean;
import com.baidu.bean.HomeBrandBean;
import com.baidu.mall.R;
import com.baidu.presenter.home.HomePresenter;
import com.baidu.utils.GlideUtils;
import com.baidu.utils.Logger;
import com.baidu.utils.ToastUtil;
import com.baidu.view.home.HomeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomeView, HomePresenter> implements HomeView {
    @BindView(R.id.banner)
    Banner bannerID;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.tv_more_price)
    TextView tvMorePrice;
    @BindView(R.id.img_wifi)
    ImageView imgWifi;
    @BindView(R.id.tv_mujj)
    TextView tvMujj;
    @BindView(R.id.tv_mujj_price)
    TextView tvMujjPrice;
    @BindView(R.id.img_mujj)
    ImageView imgMujj;
    @BindView(R.id.tv_aimu)
    TextView tvAimu;
    @BindView(R.id.tv_aimu_price)
    TextView tvAimuPrice;
    @BindView(R.id.img_aimu)
    ImageView imgAimu;
    @BindView(R.id.tv_neiye)
    TextView tvNeiye;
    @BindView(R.id.tv_neiye_price)
    TextView tvNeiyePrice;
    @BindView(R.id.img_neiye)
    ImageView imgNeiye;
    private HomePresenter homePresenter;
    private ArrayList<String> mBanners;

    @Override
    protected HomePresenter initPresenter() {
        if (homePresenter == null) {
            homePresenter = new HomePresenter();
        }
        return homePresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        homePresenter.getHomeBanner();
        //homePresenter.getBrand();
    }

    @Override
    public void onSuccess(HomeBannerBean bean) {
        if (bean != null && bean.getCode() == 200) {
            setBanner(bean);
        }
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showLong(msg);
    }

    @Override
    public void onBrandSuccess(HomeBrandBean bean) {
        Logger.logD("tag","信息"+bean.toString());
       if (bean != null){
           List<HomeBrandBean.DlistBean> dlist = bean.getDlist();
           HomeBrandBean.DlistBean dlistBean = dlist.get(0);
           tvMore.setText(dlistBean.getName());
           tvMorePrice.setText(dlistBean.getZuidijia());
           GlideUtils.setImage(getContext(),dlistBean.getBigPic(),imgWifi,R.drawable.place);

           HomeBrandBean.DlistBean dlistBean1 = dlist.get(1);
           tvMujj.setText(dlistBean1.getName());
           tvMujjPrice.setText(dlistBean1.getZuidijia());
           GlideUtils.setImage(getContext(),dlistBean1.getBigPic(),imgMujj,R.drawable.place);

           HomeBrandBean.DlistBean dlistBean2 = dlist.get(2);
           tvAimu.setText(dlistBean2.getName());
           tvAimuPrice.setText(dlistBean2.getZuidijia());
           GlideUtils.setImage(getContext(),dlistBean2.getBigPic(),imgAimu,R.drawable.place);

           HomeBrandBean.DlistBean dlistBean3 = dlist.get(3);
           tvNeiye.setText(dlistBean3.getName());
           tvNeiyePrice.setText(dlistBean3.getZuidijia());
           GlideUtils.setImage(getContext(),dlistBean3.getBigPic(),imgNeiye,R.drawable.place);
       }


    }


    private void setBanner(HomeBannerBean bean) {
        if (mBanners == null) {
            mBanners = new ArrayList<>();
        }
        List<HomeBannerBean.DlistBean> banner = bean.getDlist();
        for (HomeBannerBean.DlistBean dlistBean : banner) {
            mBanners.add(dlistBean.getPic());
        }
        bannerID.setImageLoader(new MyImageLoader());
        bannerID.setImages(mBanners);
        bannerID.start();
    }

    class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            GlideUtils.setImage(context, (String) path, imageView, R.drawable.ic_launcher_background);
        }
    }
}
