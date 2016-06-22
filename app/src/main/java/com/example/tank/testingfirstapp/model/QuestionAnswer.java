package com.example.tank.testingfirstapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by tank on 6/20/16.
 */
public class QuestionAnswer implements Parcelable {
    private String question;
    private ArrayList<Answer> answers = new ArrayList<>();

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public QuestionAnswer(){};

    private QuestionAnswer(Parcel in){
        this.question = in.readString();
        this.answers = new ArrayList<>();
        in.readTypedList(answers, Answer.CREATOR);
    }

    public static final Parcelable.Creator<QuestionAnswer> CREATOR
            = new Parcelable.Creator<QuestionAnswer>() {
        public QuestionAnswer createFromParcel(Parcel in) {
            return new QuestionAnswer(in);
        }

        public QuestionAnswer[] newArray(int size) {
            return new QuestionAnswer[size];
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
