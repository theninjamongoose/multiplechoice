package com.example.tank.testingfirstapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tank on 6/20/16.
 */
public class QuestionAnswer {
    private String question;
    private ArrayList<Answer> answers = new ArrayList<>();
    boolean isSelected;

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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
