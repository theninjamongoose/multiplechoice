package com.example.tank.testingfirstapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tank.testingfirstapp.R;
import com.example.tank.testingfirstapp.model.Survey;

/**
 * Created by tank on 6/21/16.
 */
public class AnswerSummaryFragment extends Fragment {
    private static final String TAG = "QuestionAnswerFragment";
    private static ViewPagerAdapter mViewPagerAdapter;

    private RecyclerView mAnswerRecyclerView;
    private RecyclerView.Adapter mAnswerAdapter;
    private RecyclerView.LayoutManager mAnswerLayoutManager;
    private View mFragmentView;
    private Survey mSurvey;

    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    public static AnswerSummaryFragment newInstance(Survey survey) {
        AnswerSummaryFragment answerSummaryFragment = new AnswerSummaryFragment();
        Bundle args = new Bundle();
        args.putParcelable("overWatchQuestions", survey);
        answerSummaryFragment.setArguments(args);
        return answerSummaryFragment;
    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSurvey = getArguments().getParcelable("overWatchQuestions");
        } else {
            Log.e(TAG, "no data in saved bundle state");
        }
    }

    /**
     * The Fragment's UI is just a simple text view showing its
     * instance number.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_answers_summary, container, false);
        initSummaryView();
        return mFragmentView;
    }

    private void initSummaryView() {
        initAnswersSummary();
        initSubmitBtn();
    }

    private void initSubmitBtn() {
        //todo
    }

    private void initAnswersSummary() {
        mAnswerRecyclerView = (RecyclerView) mFragmentView.findViewById(R.id.answers_summary_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mAnswerRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mAnswerLayoutManager = new LinearLayoutManager(mFragmentView.getContext());
        mAnswerRecyclerView.setLayoutManager(mAnswerLayoutManager);
        // specify an adapter (see also next example)
        mAnswerAdapter = new AnswersSummaryAdapter(mSurvey.getQuestions());
        mAnswerRecyclerView.setAdapter(mAnswerAdapter);
        mAnswerRecyclerView.setTag("answerSummary");
    }

}