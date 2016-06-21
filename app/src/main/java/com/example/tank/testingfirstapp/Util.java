package com.example.tank.testingfirstapp;

import java.util.ArrayList;

/**
 * Created by tank on 6/20/16.
 */

public class Util {
    public static OverwatchQuestions getTestData(){
        final QuestionAnswer questionOne = buildQuestionAnswer("This is an intriguing demo",
                new String[]{"True", "False"});

        final QuestionAnswer questionTwo = buildQuestionAnswer("Shane is",
                new String[]{"Not tall",
                        "Some what Not Tall",
                        "Kind of Average Hieght",
                        "Taller then Some",
                        "A daa gum Giant"});

        final QuestionAnswer questionThree = buildQuestionAnswer("This is an intriguing demo",
                new String[]{"Batman",
                        "Superman",
                        "Captain America"});

        OverwatchQuestions overwatchQuestions = new OverwatchQuestions();
        overwatchQuestions.setQuestions(new ArrayList<QuestionAnswer>(){{
            add(questionOne);
            add(questionTwo);
            add(questionThree);
        }});
        return overwatchQuestions;
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

}
