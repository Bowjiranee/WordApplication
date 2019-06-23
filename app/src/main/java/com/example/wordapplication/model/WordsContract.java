package com.example.wordapplication.model;

import android.provider.BaseColumns;

public class WordsContract  {
    private WordsContract(){ }

    public static class WordsTable implements BaseColumns{
        public static final String TABLE_NAME = "word_questions";
        public static final String COLUMN_GROUP_NAME = "groups";
        public static final String COLUMN_NAME_WORD = "words";
        public static final String COLUMN_IMAGE = "images";
    }
}
