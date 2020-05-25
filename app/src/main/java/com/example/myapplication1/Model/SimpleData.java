package com.example.myapplication1.Model;

import androidx.annotation.Nullable;

import com.omega_r.libs.omegarecyclerview.expandable_recycler_view.data.GroupProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleData implements GroupProvider<Quizzes,Quizzes> {
    private Quizzes pquizQuestion;
    private List<Quizzes> cquizQuestion;

    public static SimpleData from(Quizzes quizQuestion,Quizzes... quiz){
        return new SimpleData(quizQuestion,Arrays.asList(quiz));

    }

    public SimpleData(Quizzes quizQuestion,List<Quizzes> quiz){
        pquizQuestion=quizQuestion;
        cquizQuestion=quiz;
    }
    public Quizzes getPQuizzes(){
        return pquizQuestion;
    }

    public void  setPQuizzes(Quizzes quizzes){
        pquizQuestion=quizzes;
    }

    public List<Quizzes> getCquizQuestion(){
        return cquizQuestion;
    }
    public void setCquizQuestion(List<Quizzes> question){
        cquizQuestion=question;
    }

    @Override
    public Quizzes provideGroup() {
        return pquizQuestion;
    }

    @Override
    public List<Quizzes> provideChilds() {
        return cquizQuestion;
    }

    @Nullable
    @Override
    public Integer provideStickyId() {
        return null;
    }
}
