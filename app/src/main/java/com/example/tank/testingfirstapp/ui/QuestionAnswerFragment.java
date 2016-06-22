package com.example.tank.testingfirstapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tank.testingfirstapp.R;
import com.example.tank.testingfirstapp.model.QuestionAnswer;

/**
 * Created by tank on 6/21/16.
 */

public class QuestionAnswerFragment extends Fragment {
    private static final String TAG = "QuestionAnswerFragment";
    private QuestionAnswer mQuestionAnswer;
    private TextView mQuestionTitleTextView;
    private TextView mQuestionContentTextView;
    private RecyclerView mAnswerRecyclerView;
    private RecyclerView.Adapter mAnswerAdapter;
    private RecyclerView.LayoutManager mAnswerLayoutManager;
    private int mPosition;
    private int mTotalQuestions;
    private View mFragmentView;
    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    public static QuestionAnswerFragment newInstance(QuestionAnswer questionAnswer, int postition,
                                                     int totalQuestions) {
        QuestionAnswerFragment questionAnswerFragment = new QuestionAnswerFragment();
        Bundle args = new Bundle();
        args.putParcelable("questionAnswer", questionAnswer);
        args.putInt("position", postition);
        args.putInt("totalQuestions", totalQuestions);
        questionAnswerFragment.setArguments(args);
        return questionAnswerFragment;
    }




    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mQuestionAnswer = getArguments().getParcelable("questionAnswer");
            mPosition = getArguments().getInt("position");
            mTotalQuestions = getArguments().getInt("totalQuestions");
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

        mFragmentView = inflater.inflate(R.layout.fragment_question_answer, container, false);
        initQuestionAnswerView();
        return mFragmentView;

    }

    private void initQuestionAnswerView() {
        initQuestionTitle();
        initQuestionContentText();
        initAnswers();
    }

    private void initQuestionTitle() {
        mQuestionTitleTextView = (TextView) mFragmentView.findViewById(R.id.question_title_text_view);
        mQuestionTitleTextView.append((mPosition + 1) + "/" + mTotalQuestions);
    }

    private void initQuestionContentText() {
        mQuestionContentTextView = (TextView) mFragmentView.findViewById(R.id.question_content_text_view);
        mQuestionContentTextView.setText(mQuestionAnswer.getQuestion());
    }

    private void initAnswers() {
        mAnswerRecyclerView = (RecyclerView) mFragmentView.findViewById(R.id.multiple_choice_answers_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mAnswerRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mAnswerLayoutManager = new LinearLayoutManager(mFragmentView.getContext());
        mAnswerRecyclerView.setLayoutManager(mAnswerLayoutManager);
        // specify an adapter (see also next example)
        mAnswerAdapter = new AnswersAdapter(mQuestionAnswer.getAnswers());
        mAnswerRecyclerView.setAdapter(mAnswerAdapter);
    }
}
