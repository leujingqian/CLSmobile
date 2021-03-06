package com.example.myapplication1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HR_Choice {

    @SerializedName("numPlayers")
    @Expose
    private Integer numPlayers;
    @SerializedName("accuracy")
    @Expose
    private Integer accuracy;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("choice")
    @Expose
    private String choice;
    @SerializedName("is_correct")
    @Expose
    private Boolean isCorrect;

    public Integer getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(Integer numPlayers) {
        this.numPlayers = numPlayers;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

}