package com.example.myapplication1.Model;

public class QuestionList {

    private String question;
    private String choices1;
    private String choices2;
    private String choices3;
    private String choices4;
    private String correctAns;
    private int timer;
    private boolean iscorrect1;
    private boolean iscorrect2;
    private boolean iscorrect3;
    private boolean iscorrect4;

    public QuestionList(String question, String choices1, String choices2, String choices3, String choices4, Boolean iscorrect1,Boolean iscorrect2,Boolean iscorrect3, Boolean iscorrect4,int timer) {
        this.question = question;
        this.choices1 = choices1;
        this.choices2 = choices2;
        this.choices3 = choices3;
        this.choices4 = choices4;
        this.iscorrect1=iscorrect1;
        this.iscorrect2=iscorrect2;
        this.iscorrect3=iscorrect3;
        this.iscorrect4=iscorrect4;
        this.timer=timer;
    }

    public boolean isIscorrect1() {
        return iscorrect1;
    }

    public void setIscorrect1(boolean iscorrect1) {
        this.iscorrect1 = iscorrect1;
    }

    public boolean isIscorrect2() {
        return iscorrect2;
    }

    public void setIscorrect2(boolean iscorrect2) {
        this.iscorrect2 = iscorrect2;
    }

    public boolean isIscorrect3() {
        return iscorrect3;
    }

    public void setIscorrect3(boolean iscorrect3) {
        this.iscorrect3 = iscorrect3;
    }

    public boolean isIscorrect4() {
        return iscorrect4;
    }

    public void setIscorrect4(boolean iscorrect4) {
        this.iscorrect4 = iscorrect4;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoices1() {
        return choices1;
    }

    public void setChoices1(String choices1) {
        this.choices1 = choices1;
    }

    public String getChoices2() {
        return choices2;
    }

    public void setChoices2(String choices2) {
        this.choices2 = choices2;
    }

    public String getChoices3() {
        return choices3;
    }

    public void setChoices3(String choices3) {
        this.choices3 = choices3;
    }

    public String getChoices4() {
        return choices4;
    }

    public void setChoices4(String choices4) {
        this.choices4 = choices4;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

}
