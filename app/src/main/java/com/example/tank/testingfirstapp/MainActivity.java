package com.example.tank.testingfirstapp;

import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mQuestionTitleTextView;
    private TextView mQuestionContentTextView;
    private RecyclerView mAnswerRecyclerView;
    private RecyclerView.Adapter mAnswerAdapter;
    private RecyclerView.LayoutManager mAnswerLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int testIndex = 0;
        init(Util.getTestData().getQuestions().get(1), testIndex,
                Util.getTestData().getQuestions().size());
    }
    private void init(QuestionAnswer questionAnswer,
                      int currentIndex, int totalQuestions) {
        initQuestionTitle(currentIndex, totalQuestions);
        initQuestionContentText(questionAnswer.getQuestion());
        initAnswers(questionAnswer.getAnswers());
    }

    private void initQuestionTitle(int currentIndex, int totalQuestions) {
        mQuestionTitleTextView = (TextView) findViewById(R.id.question_title_text_view);
        mQuestionTitleTextView.append((currentIndex + 1) + "/" + totalQuestions);
    }

    private void initQuestionContentText(String question) {
        mQuestionContentTextView = (TextView) findViewById(R.id.question_content_text_view);
        mQuestionContentTextView.setText(question);
    }

    private void initAnswers(ArrayList<Answer> answers) {
        mAnswerRecyclerView = (RecyclerView) findViewById(R.id.multiple_choice_answers_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mAnswerRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mAnswerLayoutManager = new LinearLayoutManager(this);
        mAnswerRecyclerView.setLayoutManager(mAnswerLayoutManager);

        // specify an adapter (see also next example)
        mAnswerAdapter = new AnswersAdapter(answers);
        mAnswerRecyclerView.setAdapter(mAnswerAdapter);
    }


}
