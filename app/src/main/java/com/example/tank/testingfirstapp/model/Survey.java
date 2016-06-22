package com.example.tank.testingfirstapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by tank on 6/20/16.
 */

public class Survey implements Parcelable{

    private ArrayList<QuestionAnswer> questions = new ArrayList<>();

    public ArrayList<QuestionAnswer> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionAnswer> questions) {
        this.questions = questions;
    }

    public Survey(){};

    private Survey(Parcel in){
        this.questions = new ArrayList<>();
        in.readTypedList(questions, QuestionAnswer.CREATOR);
    }

    public static final Parcelable.Creator<Survey> CREATOR
            = new Parcelable.Creator<Survey>() {
        public Survey createFromParcel(Parcel in) {
            return new Survey(in);
        }

        public Survey[] newArray(int size) {
            return new Survey[size];
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
