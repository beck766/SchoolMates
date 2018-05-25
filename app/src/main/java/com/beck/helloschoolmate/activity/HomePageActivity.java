package com.beck.helloschoolmate.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.beck.base.activity.BaseActivity;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.view.fragment.HomeBaseFragment;
import com.beck.helloschoolmate.view.fragment.homepage.DiscoverFragment;
import com.beck.helloschoolmate.view.fragment.homepage.LinkmanFragment;
import com.beck.helloschoolmate.view.fragment.homepage.MapFragment;
import com.beck.helloschoolmate.view.fragment.homepage.MessageFragment;
import com.beck.helloschoolmate.view.fragment.homepage.StateFragment;
import com.beck.helloschoolmate.view.widget.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by beck on 2018/5/16.
 * HomePage
 */
public class HomePageActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private static final String TAG = "HomePageActivity";
    private HomeBaseFragment discoverFragment, linkmanFragment, mapFragment, messageFragment, stateFragment;
    private Fragment mFragment;

    @BindView(R.id.bnb_bottem_container)
    BottomNavigationBar bnbBottemContainer;

    @BindView(R.id.container)
    View container;

    @BindView(R.id.header)
    View header;

    @BindView(R.id.iv_user_icon)
    CircleImageView ivUserIcon;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.iv_add)
    ImageView ivAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ButterKnife.bind(this);
        changeStatusBarColor();
        initBottomNavigationBar();
        initFragment();
    }

    private void changeStatusBarColor() {
        Window w = getWindow();
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        w.setStatusBarColor(Color.parseColor("#15C46C"));
    }

    private void initBottomNavigationBar() {
        //bottomNavigationBar的选中事件
        bnbBottemContainer.setTabSelectedListener(this);

        bnbBottemContainer
                .setBarBackgroundColor(R.color.blue_f)
                .setActiveColor(R.color.white_f)
                .setInActiveColor(R.color.black_f)
                .setMode(BottomNavigationBar.MODE_FIXED);

        bnbBottemContainer
                .addItem(new BottomNavigationItem(R.mipmap.fragment_message_seclect, R.string.fragment_title_message)
                        .setInactiveIconResource(R.mipmap.fragment_message))

                .addItem(new BottomNavigationItem(R.mipmap.fragment_linkman_select, R.string.fragment_title_linkman)
                        .setInactiveIconResource(R.mipmap.fragment_linkman))

                .addItem(new BottomNavigationItem(R.mipmap.fragment_map_seclect, R.string.bottom_text_map)
                        .setInactiveIconResource(R.mipmap.fragment_map))

                .addItem(new BottomNavigationItem(R.mipmap.fragment_state_seclect, R.string.fragment_title_state)
                        .setInactiveIconResource(R.mipmap.fragment_state))

                .addItem(new BottomNavigationItem(R.mipmap.fragment_discover_select, R.string.fragment_title_discover)
                        .setInactiveIconResource(R.mipmap.fragment_discover))

                .initialise();
    }

    private void initFragment() {
        initUserIcon();
        if (messageFragment == null) {
            messageFragment = MessageFragment.newInstance();
        }
        tvTitle.setText(R.string.fragment_title_message);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_homepage, messageFragment)
                .commit();
        mFragment = messageFragment;
    }

    private void initUserIcon() {
        // TODO: 2018/5/17 通过glide加载用户头像
        ivUserIcon.setImageResource(R.mipmap.user_icon);
    }


    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                if (messageFragment == null) {
                    messageFragment = MessageFragment.newInstance();
                }
                switchFragment(messageFragment);
                tvTitle.setText(R.string.fragment_title_message);
                ivAdd.setVisibility(View.VISIBLE);
                break;
            case 1:
                if (linkmanFragment == null) {
                    linkmanFragment = LinkmanFragment.newInstance();
                }
                switchFragment(linkmanFragment);
                tvTitle.setText(R.string.fragment_title_linkman);
                ivAdd.setVisibility(View.VISIBLE);
                break;
            case 2:
                if (mapFragment == null) {
                    mapFragment = MapFragment.newInstance();
                }
                switchFragment(mapFragment);
                tvTitle.setText(R.string.fragment_title_map);
                ivAdd.setVisibility(View.GONE);
                break;
            case 3:
                if (stateFragment == null) {
                    stateFragment = StateFragment.newInstance();
                }
                switchFragment(stateFragment);
                tvTitle.setText(R.string.fragment_title_state);
                ivAdd.setVisibility(View.GONE);
                break;
            case 4:
                if (discoverFragment == null) {
                    discoverFragment = DiscoverFragment.newInstance();
                }
                switchFragment(discoverFragment);
                tvTitle.setText(R.string.fragment_title_discover);
                ivAdd.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if (mFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment)
                        .add(R.id.fragment_homepage, fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

    public View getContainerView() {
        return container;
    }

    public ImageView getLeftView() {
        return ivUserIcon;
    }

    public TextView getTitleView() {
        return tvTitle;
    }

    public ImageView getRightView() {
        return ivAdd;
    }

    public View getHeaderView() {
        return header;
    }


    @OnClick({R.id.iv_user_icon, R.id.iv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_user_icon:
                // TODO: 2018/5/21 点击头像右滑
                this.finish();
                break;
            case R.id.iv_add:
                // TODO: 2018/5/21 点击添加
                break;
        }
    }
}
