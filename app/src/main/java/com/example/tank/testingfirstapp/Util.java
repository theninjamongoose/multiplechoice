package com.example.tank.testingfirstapp;

import com.example.tank.testingfirstapp.model.Answer;
import com.example.tank.testingfirstapp.model.Survey;
import com.example.tank.testingfirstapp.model.QuestionAnswer;
import com.example.tank.testingfirstapp.ui.IPaginate;

import java.util.ArrayList;

/**
 * Created by tank on 6/20/16.
 */

public class Util {
    public static Survey getTestData(){
        final QuestionAnswer intrigueQuestion = buildQuestionAnswer("This is an intriguing demo.",
                new String[]{"True", "False"});

        final QuestionAnswer heightQuestion = buildQuestionAnswer("Shane is  ____________",
                new String[]{"Not tall",
                        "Some what Not Tall",
                        "Kind of Average Hieght",
                        "Taller then Some",
                        "A daa gum Giant"});

        final QuestionAnswer sevenQuestion = buildQuestionAnswer("This is 7 Options",
                new String[]{"1", "2", "3", "4", "5", "6", "7"});

        final QuestionAnswer superHeroQuestion = buildQuestionAnswer("Who is your favorite super hero?",
                new String[]{"Batman",
                        "Superman",
                        "Captain America"});

        Survey survey = new Survey();
        survey.setQuestions(new ArrayList<QuestionAnswer>(){{
            add(heightQuestion);
            add(sevenQuestion);
            add(superHeroQuestion);
            add(intrigueQuestion);
        }});
        return survey;
    }

    private static QuestionAnswer buildQuestionAnswer(String question, final String[] answerText){
        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.setQuestion(question);
        questionAnswer.setAnswers(new ArrayList<Answer>(){{
            for(int i = 0; i < answerText.length; i++){
                Answer answer = new Answer();
                answer.setText(answerText[i]);
                add(answer);
            }
        }});
        return questionAnswer;
    }

    public static IPaginate iPaginate;

    public static ArrayList<Answer> getUserAnswers(ArrayList<QuestionAnswer> questionAnswers) {
        ArrayList<Answer> userAnswers = new ArrayList<>();
        for(QuestionAnswer questionAnswer : questionAnswers){
            boolean answerSubmitted = false;
            for(int i = 0; i < questionAnswer.getAnswers().size(); i ++){
                if(questionAnswer.getAnswers().get(i).isSelected()){
                    answerSubmitted = true;
                    userAnswers.add(questionAnswer.getAnswers().get(i));
                }
            }
            if(!answerSubmitted){
                userAnswers.add(null);
            }
        }
        return userAnswers;
    }
}
