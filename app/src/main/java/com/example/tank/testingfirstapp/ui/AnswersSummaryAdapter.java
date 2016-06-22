package com.example.tank.testingfirstapp.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tank.testingfirstapp.R;
import com.example.tank.testingfirstapp.Util;
import com.example.tank.testingfirstapp.model.Answer;
import com.example.tank.testingfirstapp.model.QuestionAnswer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tank on 6/21/16.
 */
public class AnswersSummaryAdapter extends RecyclerView.Adapter<AnswersSummaryAdapter.ViewHolder> {

    private ArrayList<QuestionAnswer> mQuestionAnswers;
    private ArrayList<Answer> mUserAnswers;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mAnswerSummary;
        public Context mContext;
        public ViewHolder(View rowView) {
            super(rowView);
            mContext = rowView.getContext();
            this.mAnswerSummary = (TextView) rowView.findViewById(R.id.answer_summary_text_view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AnswersSummaryAdapter(ArrayList<QuestionAnswer> questionAnswers) {
        this.mQuestionAnswers = questionAnswers;
        this.mUserAnswers = Util.getUserAnswers(questionAnswers);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AnswersSummaryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.answer_summary_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        AnswersSummaryAdapter.ViewHolder vh = new AnswersSummaryAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AnswersSummaryAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        initAnswerSummaryTextView(holder, position);
    }

    private void initAnswerSummaryTextView(final AnswersSummaryAdapter.ViewHolder holder, final int position) {
        this.mUserAnswers = Util.getUserAnswers(mQuestionAnswers);
        if(position != 4) {
            String textToShow;
            int color;
            if (mUserAnswers.get(position) == null) {
                textToShow = position + 1 + ". " + "Not Answered";
                color = ContextCompat.getColor(holder.mContext, R.color.unansweredColor);

            } else {
                textToShow = position + 1 + ". " + mUserAnswers.get(position).getText();
                color = ContextCompat.getColor(holder.mContext, R.color.answeredColor);
            }
            Spannable spannable = new SpannableString(textToShow);
            spannable.setSpan(new ForegroundColorSpan(color),
                    textToShow.indexOf(" ") + 1, textToShow.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mAnswerSummary.setText(spannable, TextView.BufferType.SPANNABLE);
            holder.mAnswerSummary.setTag(position);
            holder.mAnswerSummary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Util.iPaginate.moveToPage(Integer.parseInt(holder.mAnswerSummary.getTag().toString()));
                }
            });
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mUserAnswers.size();
    }
}
