package com.baidu.ui.mine.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.base.BaseFragment;
import com.baidu.mall.R;
import com.baidu.presenter.home.HomePresenter;
import com.baidu.presenter.mine.MinePresenter;
import com.baidu.view.home.HomeView;
import com.baidu.view.mine.MineView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment<MineView,MinePresenter> implements MineView {


    @Override
    protected MinePresenter initPresenter() {
        return new MinePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}
