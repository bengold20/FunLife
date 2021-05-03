package com.make.model;

public class GrammarStructureModel {

    private String titleStructure;
    private String descriptionStructure;

    public GrammarStructureModel() {
    }

    public GrammarStructureModel(String titleStructure, String descriptionStructure) {
        this.titleStructure = titleStructure;
        this.descriptionStructure = descriptionStructure;
    }

    public String getTitleStructure() {
        return titleStructure;
    }

    public void setTitleStructure(String titleStructure) {
        this.titleStructure = titleStructure;
    }

    public String getDescriptionStructure() {
        return descriptionStructure;
    }

    public void setDescriptionStructure(String descriptionStructure) {
        this.descriptionStructure = descriptionStructure;
    }

    @Override
    public String toString() {
        return "GrammarStructureModel{" +
                "titleStructure='" + titleStructure + '\'' +
                ", descriptionStructure='" + descriptionStructure + '\'' +
                '}';
    }
}

