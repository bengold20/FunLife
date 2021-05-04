package com.make.Function.examTest.slide;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.make.database.DBHelper;
import com.make.model.QuestionModel;

import java.util.ArrayList;

public class QuestionController {
    private DBHelper dbHelper;

    public QuestionController(Context context) {
        dbHelper = new DBHelper(context);
    }

    public ArrayList<QuestionModel> getQuestion(int num_exam){
        ArrayList<QuestionModel> listData = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM examTest WHERE num_exam='"+num_exam+"'",null);
        cursor.moveToFirst();
        do{
            QuestionModel item;
            item = new QuestionModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)
                    ,cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7),"");
            listData.add(item);
        }while (cursor.moveToNext());
        return listData;
    }
}
