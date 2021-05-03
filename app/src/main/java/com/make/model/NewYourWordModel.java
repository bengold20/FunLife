package com.make.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "newWordTb")
public class NewYourWordModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String newWord;
    private String translater;
    private String meanning;

    public NewYourWordModel() {
    }

    public NewYourWordModel(String newWord, String translater, String meanning) {
        this.newWord = newWord;
        this.translater = translater;
        this.meanning = meanning;
    }

    public NewYourWordModel(int id, String newWord, String translater, String meanning) {
        this.id = id;
        this.newWord = newWord;
        this.translater = translater;
        this.meanning = meanning;
    }

    public String getNewWord() {
        return newWord;
    }

    public void setNewWord(String newWord) {
        this.newWord = newWord;
    }

    public String getTranslater() {
        return translater;
    }

    public void setTranslater(String translater) {
        this.translater = translater;
    }

    public String getMeanning() {
        return meanning;
    }

    public void setMeanning(String meanning) {
        this.meanning = meanning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NewYourWordModel{" +
                "id=" + id +
                ", newWord='" + newWord + '\'' +
                ", translater='" + translater + '\'' +
                ", meanning='" + meanning + '\'' +
                '}';
    }
}
