package com.example.mentalhealth;

public class answerclass {

    private int optionA, optionB, optionC, optionD, questionID, answerID;

    public answerclass (int questionId, int optiona, int optionb, int optionc, int optiond, int answerId)
    {

        questionID= questionId;
        optionA=optiona;
        optionB=optionb;
        optionC=optionc;
        optionD=optiond;
        answerID=answerId;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionID() {
        return questionID;
    }

    public int getAnswerID() {
        return answerID;
    }
}
