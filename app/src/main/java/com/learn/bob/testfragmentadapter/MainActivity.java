package com.learn.bob.testfragmentadapter;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ViewPager mViewPager;
    private CommonTabLayout mTab;
    private FirstFragment firstFragment;
    private FirstReplaceFragment firstReplaceFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private ViewPagerAadpter viewPagerAadpter;
    private List<BaseFragment> fragmentList;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private FloatingActionButton mBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView(){
        mViewPager = (ViewPager)findViewById(R.id.view_main);
        mTab = (CommonTabLayout) findViewById(R.id.tab_main);
        mBtn = (FloatingActionButton)findViewById(R.id.float_button);


        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(null != firstFragment){
//                    firstFragment.setOnChangePageListener(new FirstFragment.OnChangePageListener() {
//                        @Override
//                        public void onFloatButtonClick() {
                            Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_LONG).show();
                            firstFragment.setText("替换的字符");
//                            firstFragment = new FirstFragment("替换的字符");
//                            fragmentList.remove(0);
//                            fragmentList.add(0,firstFragment);
//                            viewPagerAadpter.notifyDataSetChanged();
//                            mViewPager.setAdapter(viewPagerAadpter);
//                        }
//                    });
                }
            }
        });

        if(null == fragmentList){
            fragmentList = new ArrayList<BaseFragment>();
        }

        if(null  == firstFragment){
            firstFragment = new FirstFragment();
            fragmentList.add(firstFragment);
            mTabEntities.add(new TabEntity("首页",R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        }

        if(null == secondFragment){
            secondFragment = new SecondFragment();
            fragmentList.add(secondFragment);
            mTabEntities.add(new TabEntity("扉页",R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        }

        if(null == thirdFragment){
            thirdFragment = new ThirdFragment();
            fragmentList.add(thirdFragment);
            mTabEntities.add(new TabEntity("尾页",R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        }

        viewPagerAadpter = new ViewPagerAadpter(getSupportFragmentManager(),fragmentList);
        mViewPager.setAdapter(viewPagerAadpter);
        mTab.setTabData(mTabEntities);

        mViewPager.setOffscreenPageLimit(3);

        mTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /* if(null != firstFragment){
            firstFragment.setOnChangePageListener(new FirstFragment.OnChangePageListener() {
                @Override
                public void onFloatButtonClick() {

                }
            });
        }*/

    }

    private class ViewPagerAadpter extends FragmentPagerAdapter{

        private List<BaseFragment> fragments;
        private FragmentManager fragmentManager;

        public ViewPagerAadpter(FragmentManager fm, List<BaseFragment> fragmentList) {
            super(fm);
            this.fragments = fragmentList;
            this.fragmentManager = fm;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }



}
