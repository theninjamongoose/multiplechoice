package com.example.tank.testingfirstapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tank on 6/20/16.
 */

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {

    private List<Answer> mAnswers = new ArrayList<>();
    private static int mCheckedPostion;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox mAnswerCheckBox;
        public ViewHolder(View rowView) {
            super(rowView);
            this.mAnswerCheckBox = (CheckBox) rowView.findViewById(R.id.answer_radio_btn);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AnswersAdapter(ArrayList<Answer> answers) {
        this.mAnswers = answers;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AnswersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.answer_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        initAnswerCheckBox(holder, position);
    }

    private void initAnswerCheckBox(final ViewHolder holder, final int position) {
        holder.mAnswerCheckBox.setChecked(position == mCheckedPostion);
        holder.mAnswerCheckBox.setText(mAnswers.get(position).getText());
        holder.mAnswerCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == mCheckedPostion) {
                    holder.mAnswerCheckBox.setChecked(false);
                    mCheckedPostion = -1;
                } else {
                    mCheckedPostion = position;
                    notifyDataSetChanged();
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mAnswers.size();
    }
}
