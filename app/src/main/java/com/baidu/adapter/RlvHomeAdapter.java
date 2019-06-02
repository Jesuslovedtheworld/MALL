package com.baidu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baidu.bean.HomeBannerBean;
import com.baidu.mall.R;
import com.baidu.utils.GlideUtils;
import com.baidu.utils.Logger;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "RlvHomeAdapter";
    private final int BANNER_TYPE = 0;
    private Context context;
    private ArrayList<HomeBannerBean.DlistBean> mBanners;
    private ArrayList<String> images;

    public RlvHomeAdapter(Context context, ArrayList<HomeBannerBean.DlistBean> mBanners) {
        this.context = context;
        this.mBanners = mBanners;
    }

    public void setmBanners(ArrayList<HomeBannerBean.DlistBean> mBanners) {
        this.mBanners = mBanners;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int type = getItemViewType(i);
        RecyclerView.ViewHolder holder = null;
        if (type == BANNER_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_banner_item, null, false);
            holder = new BannerVH(view);
            return holder;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if (type == BANNER_TYPE){
            BannerVH bannerVH = (BannerVH) viewHolder;
            if (images == null){
                images = new ArrayList<>();
            }
            for (HomeBannerBean.DlistBean mBanner : mBanners) {
                images.add(mBanner.getPic());
            }
            bannerVH.banner.setImages(images);
            bannerVH.banner.setImageLoader(new MyImageLoader());
            bannerVH.banner.start();
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        Logger.logD(TAG,"下标"+position);
        if (mBanners != null && mBanners.size() > 0) {
                return BANNER_TYPE;
        }
        return 1;
    }

    public void addBanner(ArrayList<HomeBannerBean.DlistBean> banners) {
            mBanners.addAll(banners);
            notifyDataSetChanged();
    }

    class BannerVH extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner banner;
        public BannerVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    class MyImageLoader extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //HomeBannerBean.DlistBean bean = (HomeBannerBean.DlistBean) path;
            //GlideUtils.setCircleImage(context,bean.getPic(),imageView,R.drawable.ic_launcher_background);
        }
    }
}
