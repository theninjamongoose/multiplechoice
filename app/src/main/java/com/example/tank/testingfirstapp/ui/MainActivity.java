package com.example.tank.testingfirstapp.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.example.tank.testingfirstapp.R;
import com.example.tank.testingfirstapp.Util;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity implements IPaginate {


    private ViewPagerAdapter mViewPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Util.iPaginate = this;
    }

    private void init() {
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), Util.getTestData());
        mViewPager = (ViewPager)findViewById(R.id.question_answer_view_pager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if(position == 4){
                    RecyclerView recyclerView = (RecyclerView) mViewPager.findViewWithTag("answerSummary");
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == 0){
                    try {
                        Field mScroller = ViewPager.class.getDeclaredField("mScroller");
                        mScroller.setAccessible(true);
                        FixedSpeedScroller scroller = new FixedSpeedScroller(mViewPager.getContext());
                        scroller.setDuration(300);
                        mScroller.set(mViewPager, scroller);
                    } catch (NoSuchFieldException e) {
                    } catch (IllegalArgumentException e) {
                    } catch (IllegalAccessException e) {
                    }
                }
            }
        });
        mViewPager.setAdapter(mViewPagerAdapter);
    }


    public void moveToNextPage(){
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(mViewPager.getContext(), new AccelerateInterpolator());
            scroller.setDuration(1800);
            mScroller.set(mViewPager, scroller);
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
    }

}
