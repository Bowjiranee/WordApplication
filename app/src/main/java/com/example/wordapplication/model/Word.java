package com.example.wordapplication.model;

import java.util.Locale;

public class Word {
    private String group;
    private String nameWord;
    private String image;

    public Word(){}
    public Word(String group, String nameWord, String image) {
        this.group = group;
        this.nameWord = nameWord;
        this.image = image;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getNameWord() {
        return nameWord;
    }

    public void setNameWord(String nameWord) {
        this.nameWord = nameWord;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    @Override
//    public String toString() {
//        String msg = String.format(
//                Locale.getDefault(),
//                "%s (%s)",
//                this.title,
//                this.number
//        );
//        return msg;
//    }

}
