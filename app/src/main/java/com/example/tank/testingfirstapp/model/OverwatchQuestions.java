package com.example.tank.testingfirstapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by tank on 6/20/16.
 */

public class OverwatchQuestions implements Parcelable{

    private ArrayList<QuestionAnswer> questions = new ArrayList<>();

    public ArrayList<QuestionAnswer> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionAnswer> questions) {
        this.questions = questions;
    }

    public OverwatchQuestions(){};

    private OverwatchQuestions(Parcel in){
        this.questions = new ArrayList<>();
        in.readTypedList(questions, QuestionAnswer.CREATOR);
    }

    public static final Parcelable.Creator<OverwatchQuestions> CREATOR
            = new Parcelable.Creator<OverwatchQuestions>() {
        public OverwatchQuestions createFromParcel(Parcel in) {
            return new OverwatchQuestions(in);
        }

        public OverwatchQuestions[] newArray(int size) {
            return new OverwatchQuestions[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

}
