package com.make.model;

public class ExamTestModel {

    private String title;
    private String nameFileEX;
    private String timeFileEX;

    public ExamTestModel() {
    }

    public ExamTestModel(String title, String nameFileEX, String timeFileEX) {
        this.title = title;
        this.nameFileEX = nameFileEX;
        this.timeFileEX = timeFileEX;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameFileEX() {
        return nameFileEX;
    }

    public void setNameFileEX(String nameFileEX) {
        this.nameFileEX = nameFileEX;
    }

    public String getTimeFileEX() {
        return timeFileEX;
    }

    public void setTimeFileEX(String timeFileEX) {
        this.timeFileEX = timeFileEX;
    }
}
