package com.baidu.ui.special.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.baidu.adapter.RlvSpecialAdapter;
import com.baidu.base.BaseFragment;
import com.baidu.bean.SpecialBean;
import com.baidu.mall.R;
import com.baidu.presenter.special.SpecialPresenter;
import com.baidu.view.special.SpecialView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialFragment extends BaseFragment<SpecialView, SpecialPresenter> implements SpecialView {

    private static final String TAG = "SpecialFragment";
    @BindView(R.id.tab_special)
    TabLayout tabSpecial;
    @BindView(R.id.rl_special)
    RecyclerView rlSpecial;
    private ArrayList<SpecialBean.DlistBean> mArr;
    private RlvSpecialAdapter mAdapter;
    private SpecialPresenter presenter;

    @Override
    protected SpecialPresenter initPresenter() {
        if (presenter == null){
            presenter = new SpecialPresenter();
        }
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_special;
    }


    @Override
    protected void initView() {
        tabSpecial.addTab(tabSpecial.newTab()
                .setText("全部专题")
                .setIcon(R.drawable.icon_tab_special_select));

        tabSpecial.addTab(tabSpecial.newTab()
                .setText("服务专题")
                .setIcon(R.drawable.icon_tab_special_select));
        tabSpecial.addTab(tabSpecial.newTab()
                .setText("全部专题")
                .setIcon(R.drawable.icon_tab_special_select));
        tabSpecial.addTab(tabSpecial.newTab()
                .setText("餐厨专题")
                .setIcon(R.drawable.icon_tab_special_select));
        tabSpecial.addTab(tabSpecial.newTab()
                .setText("配件专题")
                .setIcon(R.drawable.icon_tab_special_select));
        tabSpecial.addTab(tabSpecial.newTab()
                .setText("居家专题")
                .setIcon(R.drawable.icon_tab_special_select));
        tabSpecial.addTab(tabSpecial.newTab()
                .setText("洗护专题")
                .setIcon(R.drawable.icon_tab_special_select));

        rlSpecial.setLayoutManager(new LinearLayoutManager(getContext()));
        mArr = new ArrayList<>();
        mAdapter = new RlvSpecialAdapter(getContext(), mArr);
        rlSpecial.setAdapter(mAdapter);

    }

    @Override
    protected void initData() {
        presenter.getSpecial();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    @Override
    public void onSuccesss(SpecialBean bean) {
            if (bean != null && bean.getCode() == 200){
                mArr.addAll(bean.getDlist());
                mAdapter.addData(mArr);
            }
    }

    @Override
    public void onFail(String msg) {

    }
}
