package com.example.wordapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.wordapplication.model.Word;
import com.example.wordapplication.model.WordsContract;

import java.util.ArrayList;
import java.util.List;

public class WordDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "WordDb.db";
    private static final int DATABASE_VERSION = 10;

    private SQLiteDatabase db;

    public WordDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_WORD_TABLE = "CREATE TABLE " +
                WordsContract.WordsTable.TABLE_NAME + " ( " +
                WordsContract.WordsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WordsContract.WordsTable.COLUMN_GROUP_NAME + " TEXT, " +
                WordsContract.WordsTable.COLUMN_NAME_WORD + " TEXT, " +
                WordsContract.WordsTable.COLUMN_IMAGE + " BLOB " +
                ")";
        db.execSQL(SQL_CREATE_WORD_TABLE);
        fillWordsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ WordsContract.WordsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillWordsTable() {

        //fruits
        Word f1 = new Word("FRUIT","Grapes", "grape.png");
        addVocubulary(f1);
        Word f2 = new Word("FRUIT","Longon", "longon.png");
        addVocubulary(f2);
        Word f3 = new Word("FRUIT","Mango", "mango.png");
        addVocubulary(f3);
        Word f4 = new Word("FRUIT","Lychee", "lychee.png");
        addVocubulary(f4);
        Word f5 = new Word("FRUIT","Mangosteen", "mangosteen.png");
        addVocubulary(f5);

        //colors
        Word c1 = new Word("COLOR","Blue","blue.png");
        addVocubulary(c1);
        Word c2 = new Word("COLOR","Pink","pink.png");
        addVocubulary(c2);
        Word c3 = new Word("COLOR","Red","red.png");
        addVocubulary(c3);
        Word c4 = new Word("COLOR","Yellow","yellow.png");
        addVocubulary(c4);
        Word c5 = new Word("COLOR","Green","green.png");
        addVocubulary(c5);

        //animals
        Word a1 = new Word("ANIMAL","Bird","bird.png");
        addVocubulary(a1);
        Word a2 = new Word("ANIMAL","Elephant","elephant.png");
        addVocubulary(a2);
        Word a3 = new Word("ANIMAL","Cat","cat.png");
        addVocubulary(a3);
        Word a4 = new Word("ANIMAL","Pig","pig.png");
        addVocubulary(a4);
        Word a5 = new Word("ANIMAL","Dog","dog.png");
        addVocubulary(a5);

        //bodies
        Word b1 = new Word("BODY","Eyes","eyes.png");
        addVocubulary(b1);
        Word b2 = new Word("BODY","Face","face.png");
        addVocubulary(b2);
        Word b3 = new Word("BODY","Hand","hand.png");
        addVocubulary(b3);
        Word b4 = new Word("BODY","Mouth","mouth.png");
        addVocubulary(b4);
        Word b5 = new Word("BODY","Nose","nose.png");
        addVocubulary(b5);

        //shapes
        Word sh1 = new Word("SHAPE","Circle","circle.png");
        addVocubulary(sh1);
        Word sh2 = new Word("SHAPE","Heart","heart.png");
        addVocubulary(sh2);
        Word sh3 = new Word("SHAPE","Square","square.png");
        addVocubulary(sh3);
        Word sh4 = new Word("SHAPE","Star","star.png");
        addVocubulary(sh4);
        Word sh5 = new Word("SHAPE","Triangle","triangle.png");
        addVocubulary(sh5);
    }

    private void addVocubulary(Word word) {
        ContentValues cv = new ContentValues();
        cv.put(WordsContract.WordsTable.COLUMN_GROUP_NAME,word.getGroup());
        cv.put(WordsContract.WordsTable.COLUMN_NAME_WORD,word.getNameWord());
        cv.put(WordsContract.WordsTable.COLUMN_IMAGE,word.getImage());
        db.insert(WordsContract.WordsTable.TABLE_NAME,null,cv);
    }

    public List<Word> getAllWords(){
        List<Word> wordList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ WordsContract.WordsTable.TABLE_NAME,null);
        if(c.moveToFirst()){
            do{
                Word word = new Word();
                word.setGroup(c.getString(c.getColumnIndex(WordsContract.WordsTable.COLUMN_GROUP_NAME)));
                word.setNameWord(c.getString(c.getColumnIndex(WordsContract.WordsTable.COLUMN_NAME_WORD)));
//                word.setImage(c.getBlob(c.getColumnIndex(WordsContract.WordsTable.COLUMN_IMAGE)));
                word.setImage(c.getString(c.getColumnIndex(WordsContract.WordsTable.COLUMN_IMAGE)));
            } while (c.moveToNext());
        }
        c.close();
        return wordList;
    }

}
