package com.baidu.ui.classfly.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.base.BaseFragment;
import com.baidu.mall.R;
import com.baidu.presenter.classfly.ClassFlyPresenter;
import com.baidu.presenter.home.HomePresenter;
import com.baidu.view.classfly.ClassFlyView;
import com.baidu.view.home.HomeView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassFlyFragment extends BaseFragment<ClassFlyView,ClassFlyPresenter> implements ClassFlyView {


    @Override
    protected ClassFlyPresenter initPresenter() {
        return new ClassFlyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_class_fly;
    }
}
