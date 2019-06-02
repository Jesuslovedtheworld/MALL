package com.baidu.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.base.BaseActivity;
import com.baidu.base.BaseApp;
import com.baidu.mall.R;
import com.baidu.presenter.main.MainPresenter;
import com.baidu.ui.classfly.fragment.ClassFlyFragment;
import com.baidu.ui.home.fragment.HomeFragment;
import com.baidu.ui.mine.fragment.MineFragment;
import com.baidu.ui.special.fragment.SpecialFragment;
import com.baidu.view.main.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.img_home)
    ImageView imgHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.img_classify)
    ImageView imgClassify;
    @BindView(R.id.tv_classify)
    TextView tvClassify;
    @BindView(R.id.img_specia)
    ImageView imgSpecia;
    @BindView(R.id.tv_specia)
    TextView tvSpecia;
    @BindView(R.id.img_mine)
    ImageView imgMine;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private ClassFlyFragment mClassFragment;
    private SpecialFragment mSpecialFragment;
    private MineFragment mMineFragment;
    private ArrayList<Fragment> fragments;
    private final int HOME_TYPE = 0;
    private final int CLASSFLY_TYPE = 1;
    private final int SPECIAL_TYPE = 2;
    private final int MINE_TYPE = 3;
    private int mLastFragmentPosition;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        toolBar.setTitle("");
        toolBar.setSubtitle("");
        //支持toolbar
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.mipmap.icon_bell);
        initFragment();//初始化Fragmetn
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mClassFragment = new ClassFlyFragment();
        mSpecialFragment = new SpecialFragment();
        mMineFragment = new MineFragment();
        if (fragments == null) {
            fragments = new ArrayList<>();
        }
        fragments.add(mHomeFragment);
        fragments.add(mClassFragment);
        fragments.add(mSpecialFragment);
        fragments.add(mMineFragment);

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .add(R.id.fl, mHomeFragment)
                .add(R.id.fl, mClassFragment)
                .add(R.id.fl, mSpecialFragment)
                .add(R.id.fl, mMineFragment)
                .commit();
        mFragmentManager.beginTransaction()
                .replace(R.id.fl, mHomeFragment).commit();

    }

    @OnClick({R.id.img_home, R.id.tv_home, R.id.img_classify, R.id.tv_classify, R.id.img_specia, R.id.tv_specia, R.id.img_mine, R.id.tv_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_home:
                switchFragment(HOME_TYPE);
                break;
            case R.id.tv_home:
                switchFragment(HOME_TYPE);
                break;
            case R.id.img_classify:
                switchFragment(CLASSFLY_TYPE);
                break;
            case R.id.tv_classify:
                switchFragment(CLASSFLY_TYPE);
                break;
            case R.id.img_specia:
                switchFragment(SPECIAL_TYPE);
                break;
            case R.id.tv_specia:
                switchFragment(SPECIAL_TYPE);
                break;
            case R.id.img_mine:
                switchFragment(MINE_TYPE);
                break;
            case R.id.tv_mine:
                switchFragment(MINE_TYPE);
                break;
        }
    }

    private void switchFragment(int home_type) {
        setColor(home_type);

        //显示一个fragmnet,隐藏一个Fragment
        //显示
        Fragment fragment = fragments.get(home_type);
        //需要隐藏
        Fragment hideFragment = fragments.get(mLastFragmentPosition);
        FragmentTransaction beginTransaction = mFragmentManager.beginTransaction();
        if (!fragment.isAdded()) {
            beginTransaction.add(R.id.fl, fragment);
        }

        beginTransaction.hide(hideFragment);
        beginTransaction.show(fragment);
        beginTransaction.commit();

        mLastFragmentPosition = home_type;

    }

    private void setColor(int home_type) {
        switch (home_type) {//设置颜色
            case 0:
                imgHome.setImageResource(R.drawable.icon_tab_home_select);
                imgClassify.setImageResource(R.drawable.icon_tab_classify_unselect);
                imgSpecia.setImageResource(R.drawable.icon_tab_special_unselect);
                imgMine.setImageResource(R.drawable.icon_tab_my_unselect);
                tvHome.setTextColor(BaseApp.getRes().getColor(R.color.c_607cd9));
                tvClassify.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                tvSpecia.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                tvMine.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                break;
            case 1:
                imgHome.setImageResource(R.drawable.icon_tab_home_unselect);
                imgClassify.setImageResource(R.drawable.icon_tab_classify_select);
                imgSpecia.setImageResource(R.drawable.icon_tab_special_unselect);
                imgMine.setImageResource(R.drawable.icon_tab_my_unselect);
                tvHome.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                tvClassify.setTextColor(BaseApp.getRes().getColor(R.color.c_607cd9));
                tvSpecia.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                tvMine.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                break;
            case 2:
                imgHome.setImageResource(R.drawable.icon_tab_home_unselect);
                imgClassify.setImageResource(R.drawable.icon_tab_classify_unselect);
                imgSpecia.setImageResource(R.drawable.icon_tab_special_select);
                imgMine.setImageResource(R.drawable.icon_tab_my_unselect);
                tvHome.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                tvClassify.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                tvSpecia.setTextColor(BaseApp.getRes().getColor(R.color.c_607cd9));
                tvMine.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                break;
            case 3:
                imgHome.setImageResource(R.drawable.icon_tab_home_unselect);
                imgClassify.setImageResource(R.drawable.icon_tab_classify_unselect);
                imgSpecia.setImageResource(R.drawable.icon_tab_special_unselect);
                imgMine.setImageResource(R.drawable.icon_tab_my_select);
                tvHome.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                tvClassify.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                tvSpecia.setTextColor(BaseApp.getRes().getColor(R.color.c_a4a4a4));
                tvMine.setTextColor(BaseApp.getRes().getColor(R.color.c_607cd9));
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
