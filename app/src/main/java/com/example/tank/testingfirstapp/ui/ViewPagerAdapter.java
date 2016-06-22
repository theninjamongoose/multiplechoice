package com.example.tank.testingfirstapp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tank.testingfirstapp.model.Survey;

/**
 * Created by tank on 6/21/16.
 */


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Survey mSurvey;

    public ViewPagerAdapter(FragmentManager fm, Survey survey) {
        super(fm);
        this.mSurvey = survey;
    }

    @Override
    public int getCount() {
        return mSurvey.getQuestions().size() + 1;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == getCount() - 1){
            return AnswerSummaryFragment.newInstance(mSurvey);
        } else {
            return QuestionAnswerFragment.newInstance(mSurvey.getQuestions().get(position),
                    position, getCount() - 1);
        }
    }
}
