package com.example.tank.testingfirstapp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tank.testingfirstapp.model.OverwatchQuestions;
import com.example.tank.testingfirstapp.model.QuestionAnswer;
import com.example.tank.testingfirstapp.ui.QuestionAnswerFragment;

import java.util.ArrayList;

/**
 * Created by tank on 6/21/16.
 */


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private OverwatchQuestions mOverwatchQuestions;

    public ViewPagerAdapter(FragmentManager fm, OverwatchQuestions overwatchQuestions) {
        super(fm);
        this.mOverwatchQuestions = overwatchQuestions;
    }

    @Override
    public int getCount() {
        return mOverwatchQuestions.getQuestions().size() + 1;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == getCount() - 1){
            return AnswerSummaryFragment.newInstance(mOverwatchQuestions);
        } else {
            return QuestionAnswerFragment.newInstance(mOverwatchQuestions.getQuestions().get(position),
                    position, getCount());
        }
    }
}
