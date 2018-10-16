package com.example.android.placementassist;

import java.io.Serializable;

public class Question implements Serializable {
    private String mQuestion;
    private int mWeightage;
    private String mKeyNotes;

    public Question(String question, int weightage, String keyNotes) {
        this.mKeyNotes = keyNotes;
        this.mQuestion = question;
        this.mWeightage = weightage;
    }

    public Question(String question) {
        this.mQuestion = question;
        this.mWeightage = 5;
        this.mKeyNotes = "";
    }

    public int getmWeightage() {
        return mWeightage;
    }

    public String getmKeyNotes() {
        return mKeyNotes;
    }

    public String getmQuestion() {
        return mQuestion;
    }


    public void setmKeyNotes(String mKeyNotes) {
        this.mKeyNotes = mKeyNotes;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public void setmWeightage(int mWeightage) {
        this.mWeightage = mWeightage;
    }
}
