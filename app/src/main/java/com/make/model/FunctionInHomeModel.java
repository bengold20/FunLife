package com.make.model;

public class FunctionInHomeModel {

    private int resouceImage;
    private String nameFunction;

    public FunctionInHomeModel() {
    }

    public FunctionInHomeModel(int resouceImage, String nameFunction) {
        this.resouceImage = resouceImage;
        this.nameFunction = nameFunction;
    }

    public int getResouceImage() {
        return resouceImage;
    }

    public void setResouceImage(int resouceImage) {
        this.resouceImage = resouceImage;
    }

    public String getNameFunction() {
        return nameFunction;
    }

    public void setNameFunction(String nameFunction) {
        this.nameFunction = nameFunction;
    }
}
